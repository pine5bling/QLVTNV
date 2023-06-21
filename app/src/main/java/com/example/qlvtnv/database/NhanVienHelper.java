package com.example.qlvtnv.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NhanVienHelper extends SQLiteOpenHelper {

    public static String KEY_TABLE_NV = "KEY_TABLE_NV";

    public static int KEY_VERSION = 1;

    public static String NAME_DATA_BASE_NV = "NAME_DATA_BASE_NV";

    public static String KEY_ID_NV = "KEY_ID_NV";

    public static String KEY_NAME_NV = "KEY_NAME_NV";

    public static String KEY_NAM_SINH = "KEY_NAM_SINH";

    public static String KEY_QUE_QUAN = "KEY_QUE_QUAN";

    public static String KEY_TRINH_DO = "KEY_TRINH_DO";

    public NhanVienHelper(Context context) {
        super(context, KEY_TABLE_NV, null, KEY_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBang = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT)",
                NAME_DATA_BASE_NV, KEY_ID_NV, KEY_NAME_NV, KEY_NAM_SINH, KEY_QUE_QUAN, KEY_TRINH_DO);
        db.execSQL(taoBang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String xoaBang = String.format("DROP TABLE IF EXISTS %s", NAME_DATA_BASE_NV);
        db.execSQL(xoaBang);

        // Tạo lại bảng
        onCreate(db);
    }
}
