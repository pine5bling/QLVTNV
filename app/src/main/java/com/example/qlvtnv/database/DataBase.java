package com.example.qlvtnv.database;

import static com.example.qlvtnv.database.NhanVienHelper.KEY_ID_NV;
import static com.example.qlvtnv.database.NhanVienHelper.KEY_NAME_NV;
import static com.example.qlvtnv.database.NhanVienHelper.KEY_NAM_SINH;
import static com.example.qlvtnv.database.NhanVienHelper.KEY_QUE_QUAN;
import static com.example.qlvtnv.database.NhanVienHelper.KEY_TRINH_DO;
import static com.example.qlvtnv.database.NhanVienHelper.NAME_DATA_BASE_NV;
import static com.example.qlvtnv.database.ViTriCongViecHelper.KEY_ID_NV_VTCV;
import static com.example.qlvtnv.database.ViTriCongViecHelper.KEY_ID_VT_VTCV;
import static com.example.qlvtnv.database.ViTriCongViecHelper.KEY_MO_TA_VTCV;
import static com.example.qlvtnv.database.ViTriCongViecHelper.KEY_THOI_DIEM_GAN;
import static com.example.qlvtnv.database.ViTriCongViecHelper.NAME_DATA_BASE_VTCV;
import static com.example.qlvtnv.database.ViTriHelper.KEY_ID_VT;
import static com.example.qlvtnv.database.ViTriHelper.KEY_MO_TA_VT;
import static com.example.qlvtnv.database.ViTriHelper.KEY_NAME_VT;
import static com.example.qlvtnv.database.ViTriHelper.NAME_DATA_BASE_VT;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlvtnv.model.NhanVien;
import com.example.qlvtnv.model.ViTri;
import com.example.qlvtnv.model.ViTriCongViec;

import java.util.ArrayList;

public class DataBase {
    private NhanVienHelper nhanVienHelper;

    private ViTriHelper viTriHelper;

    private ViTriCongViecHelper viTriCongViecHelper;

    private Context context;

    public DataBase(NhanVienHelper nhanVienHelper, Context context) {
        this.nhanVienHelper = nhanVienHelper;
        this.context = context;
    }

    public DataBase(ViTriHelper viTriHelper, Context context) {
        this.viTriHelper = viTriHelper;
        this.context = context;
    }

    public DataBase(ViTriCongViecHelper viTriCongViecHelper,NhanVienHelper nhanVienHelper,ViTriHelper viTriHelper, Context context) {
        this.nhanVienHelper = nhanVienHelper;
        this.viTriCongViecHelper = viTriCongViecHelper;
        this.viTriHelper = viTriHelper;
        this.context = context;
    }

    /**
     * @param nhanVien
     */

    public void themNV(NhanVien nhanVien) {
        SQLiteDatabase db = nhanVienHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Không có KEY_ID_NV vì đã xét nó AUTOINCREMENT
        contentValues.put(KEY_NAME_NV, nhanVien.getTenNV());
        contentValues.put(KEY_NAM_SINH, nhanVien.getNamSinh());
        contentValues.put(KEY_QUE_QUAN, nhanVien.getQueQuan());
        contentValues.put(KEY_TRINH_DO, nhanVien.getTrinhDo());

        db.insert(NAME_DATA_BASE_NV, null, contentValues);
    }

    public ArrayList<NhanVien> getDSNV() {
        SQLiteDatabase db = nhanVienHelper.getReadableDatabase();

        ArrayList<NhanVien> nhanVienList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + NAME_DATA_BASE_NV, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = new NhanVien(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            nhanVienList.add(nhanVien);
            cursor.moveToNext();
        }
        cursor.close();
        return nhanVienList;
    }

    public ArrayList<Integer> getDSIdNV() {
        SQLiteDatabase db = nhanVienHelper.getReadableDatabase();

        ArrayList<Integer> idNVList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT " + KEY_ID_NV + " FROM " + NAME_DATA_BASE_NV, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            @SuppressLint("Range") int idNV = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID_NV)));
            idNVList.add(idNV);
            cursor.moveToNext();
        }
        cursor.close();
        return idNVList;
    }

    //        if (cursor.moveToFirst()) {
//            do {
//                @SuppressLint("Range") int columnIdNV = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID_NV)));
//                idNVList.add(columnIdNV);
//            } while (cursor.moveToNext());
//        }

    public ArrayList<NhanVien> getLietKe() {
        SQLiteDatabase db = nhanVienHelper.getReadableDatabase();

        ArrayList<NhanVien> nhanVienList = new ArrayList<>();

        Cursor cursor = db.rawQuery(" SELECT * FROM NAME_DATA_BASE_NV WHERE KEY_NAME_NV = 'Nam' AND KEY_NAM_SINH = 1995", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nhanVien = new NhanVien(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            nhanVienList.add(nhanVien);
            cursor.moveToNext();
        }
        cursor.close();
        return nhanVienList;
    }

    /**
     * @param viTri
     */

    public void themVT(ViTri viTri) {
        SQLiteDatabase db = viTriHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // Không có KEY_ID_VT vì đã xét nó AUTOINCREMENT
        contentValues.put(KEY_NAME_VT, viTri.getTenVT());
        contentValues.put(KEY_MO_TA_VT, viTri.getMoTa());

        db.insert(NAME_DATA_BASE_VT, null, contentValues);
    }

    public ArrayList<ViTri> getDSVT() {
        SQLiteDatabase db = viTriHelper.getReadableDatabase();

        ArrayList<ViTri> viTriList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + NAME_DATA_BASE_VT, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ViTri viTri = new ViTri(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );

            viTriList.add(viTri);
            cursor.moveToNext();
        }
        cursor.close();
        return viTriList;
    }

    public ArrayList<Integer> getDSIdVT() {
        SQLiteDatabase db = viTriHelper.getReadableDatabase();

        ArrayList<Integer> idVTList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT " + KEY_ID_VT + " FROM " + NAME_DATA_BASE_VT, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            @SuppressLint("Range") int idVT = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID_VT)));
            idVTList.add(idVT);
            cursor.moveToNext();
        }

        cursor.close();
        return idVTList;
    }

    /**
     * @param viTriCongViec
     */
    public void themVTCV(ViTriCongViec viTriCongViec) {
        SQLiteDatabase db = viTriCongViecHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_ID_NV_VTCV, viTriCongViec.getIdNhanVien());
        contentValues.put(KEY_ID_VT_VTCV, viTriCongViec.getIdViTri());
        contentValues.put(KEY_THOI_DIEM_GAN, viTriCongViec.getThoiDiemGan());
        contentValues.put(KEY_MO_TA_VTCV, viTriCongViec.getMoTaCV());

        db.insert(NAME_DATA_BASE_VTCV, null, contentValues);
    }

    public ArrayList<ViTriCongViec> getDSVTCV() {
        SQLiteDatabase db = viTriCongViecHelper.getReadableDatabase();

        ArrayList<ViTriCongViec> viTriCongViecList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + NAME_DATA_BASE_VTCV, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ViTriCongViec viTriCongViec = new ViTriCongViec(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );

            viTriCongViecList.add(viTriCongViec);
            cursor.moveToNext();
        }
        cursor.close();
        return viTriCongViecList;
    }

}
