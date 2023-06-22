package com.example.qlvtnv.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qlvtnv.model.NhanVien;
import com.example.qlvtnv.model.ThongKe;
import com.example.qlvtnv.model.ViTri;
import com.example.qlvtnv.model.ViTriCongViec;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DATABASE_NAME";
    public static String NAME_TABLE_NV = "NAME_TABLE_NV";
    public static String NAME_TABLE_VT = "NAME_TABLE_VT";
    public static String NAME_TABLE_VTCV = "NAME_TABLE_VTCV";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBang = "create table NAME_TABLE_NV (" +
                "maNV integer primary key autoincrement, " +
                "tenNV text, " +
                "namSinh integer, " +
                "queQuan text, " +
                "trinhDo text) ";
        db.execSQL(taoBang);
        taoBang = "create table NAME_TABLE_VT (" +
                "maVT integer primary key autoincrement, " +
                "tenVT text, " +
                "moTa text)";
        db.execSQL(taoBang);
        taoBang = "create table NAME_TABLE_VTCV(" +
                "idNhanVien integer, " +
                "idViTri integer, " +
                "thoiDiemGan text, " +
                "moTaCV text, " +
                "foreign key(idNhanVien) references NAME_TABLE_NV(maNV), " +
                "foreign key(idViTri) references NAME_TABLE_VT(maVT))";
        db.execSQL(taoBang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists NAME_TABLE_NV");
        db.execSQL("drop table if exists NAME_TABLE_VT");
        db.execSQL("drop table if exists NAME_TABLE_VTCV");
        onCreate(db);
    }

    /**
     * nhanVien
     */

    public void them(String tenBang, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tenBang, null, values);
        db.close();
    }

    public List<NhanVien> getCursorNV(Cursor cursor, SQLiteDatabase db) {
        List<NhanVien> nvList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(cursor.getInt(0));
                nhanVien.setTenNV(cursor.getString(1));
                nhanVien.setNamSinh(cursor.getInt(2));
                nhanVien.setQueQuan(cursor.getString(3));
                nhanVien.setTrinhDo(cursor.getString(4));
                nvList.add(nhanVien);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nvList;
    }

    public List<Integer> layIdList(Cursor cursor, String tenCotId) {
        List<Integer> idList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(tenCotId)));
            idList.add(id);
            cursor.moveToNext();
        }
        cursor.close();
        return idList;
    }

    public void themNhanVien(NhanVien nhanVien) {
        ContentValues values = new ContentValues();
        values.put("tenNV", nhanVien.getTenNV());
        values.put("namSinh", nhanVien.getNamSinh());
        values.put("queQuan", nhanVien.getQueQuan());
        values.put("trinhDo", nhanVien.getTrinhDo());
        them(NAME_TABLE_NV, values);
    }

    public List<NhanVien> layDanhSachNhanVien() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from NAME_TABLE_NV", null);
        return getCursorNV(cursor, db);
    }

    public List<NhanVien> layDSLietKe() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from NAME_TABLE_NV where tenNV like '%nam%' and namSinh like '%1995%'", null);
        return getCursorNV(cursor, this.getReadableDatabase());
    }

    public List<Integer> layDSIdNV() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT maNV FROM NAME_TABLE_NV", null);
        return layIdList(cursor, "maNV");
    }

    /**
     * viTri
     */

    public void themViTri(ViTri viTri) {
        ContentValues values = new ContentValues();
        values.put("tenVT", viTri.getTenVT());
        values.put("moTa", viTri.getMoTa());

        them(NAME_TABLE_VT, values);
    }

    public List<ViTri> layDanhSachViTri() {
        List<ViTri> viTriList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from NAME_TABLE_VT", null);
        if (cursor.moveToFirst()) {
            do {
                ViTri viTri = new ViTri();
                viTri.setMaVT(cursor.getInt(0));
                viTri.setTenVT(cursor.getString(1));
                viTri.setMoTa(cursor.getString(2));
                viTriList.add(viTri);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return viTriList;
    }

    public List<Integer> layDSIdVT() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT maVT FROM NAME_TABLE_VT", null);
        return layIdList(cursor, "maVT");
    }

    /**
     * viTriCongViec
     */

    public void themViTriCongViec(ViTriCongViec viTriCongViec) {
        ContentValues values = new ContentValues();
        values.put("idNhanVien", viTriCongViec.getIdNhanVien());
        values.put("idViTri", viTriCongViec.getIdViTri());
        values.put("thoiDiemGan", viTriCongViec.getThoiDiemGan());
        values.put("moTaCV", viTriCongViec.getMoTaCV());

        them(NAME_TABLE_VTCV, values);
    }

    public List<ViTriCongViec> layDanhSachViTriCV() {
        List<ViTriCongViec> listDangKy = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from NAME_TABLE_VTCV", null);
        if (cursor.moveToFirst()) {
            do {
                ViTriCongViec vitriCV = new ViTriCongViec();
                vitriCV.setIdNhanVien(cursor.getInt(0));
                vitriCV.setIdViTri(cursor.getInt(1));
                vitriCV.setThoiDiemGan(cursor.getString(2));
                vitriCV.setMoTaCV(cursor.getString(3));
                listDangKy.add(vitriCV);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listDangKy;
    }

    public List<ThongKe> layDanhSachThongKe() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<ThongKe> thongKeList = new ArrayList<>();

        String query = "Select NAME_TABLE_VT.maVT, NAME_TABLE_VT.tenVT, count(*) as soNhanVien from NAME_TABLE_VTCV " +
                "inner join NAME_TABLE_VT on NAME_TABLE_VTCV.idViTri = NAME_TABLE_VT.maVT " +
                "group by idViTri order by soNhanVien desc";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                ThongKe thongKe = new ThongKe();
                thongKe.setIdVT(cursor.getInt(0));
                thongKe.setTenVT(cursor.getString(1));
                thongKe.setSoNhanVien(cursor.getInt(2));
                thongKeList.add(thongKe);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return thongKeList;
    }
}
