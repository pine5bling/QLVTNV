package com.example.qlvtnv.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ViTriCongViecHelper extends SQLiteOpenHelper {

    public static String KEY_TABLE_VTCV = "KEY_TABLE_VTCV";

    public static int KEY_VERSION = 1;

    public static String NAME_DATA_BASE_VTCV = "NAME_DATA_BASE_VTCV";

    public static String KEY_ID_NV_VTCV = "KEY_ID_NV_VTCV";

    public static String KEY_ID_VT_VTCV = "KEY_ID_VT_VTCV";

    public static String KEY_THOI_DIEM_GAN= "KEY_THOI_DIEM_GAN";

    public static String KEY_MO_TA_VTCV = "KEY_MO_TA_VTCV";

    public ViTriCongViecHelper(Context context) {
        super(context, KEY_TABLE_VTCV, null, KEY_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBang = String.format("CREATE TABLE %s(%s INT, %s INT, %s TEXT,  %s TEXT, PRIMARY KEY(%s ,%s));",
                NAME_DATA_BASE_VTCV, KEY_ID_NV_VTCV, KEY_ID_VT_VTCV, KEY_THOI_DIEM_GAN, KEY_MO_TA_VTCV, KEY_ID_NV_VTCV, KEY_ID_VT_VTCV);
        db.execSQL(taoBang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String xoaBang = String.format("DROP TABLE IF EXISTS %s", NAME_DATA_BASE_VTCV);
        db.execSQL(xoaBang);

        // Tạo lại bảng
        onCreate(db);
    }
}
