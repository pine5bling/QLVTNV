package com.example.qlvtnv.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ViTriHelper extends SQLiteOpenHelper {
    public static String KEY_TABLE_VT = "KEY_TABLE_VT";

    public static int KEY_VERSION = 1;

    public static String NAME_DATA_BASE_VT = "NAME_DATA_BASE_VT";

    public static String KEY_ID_VT = "KEY_ID_VT";

    public static String KEY_NAME_VT = "KEY_NAME_VT";

    public static String KEY_MO_TA_VT = "KEY_MO_TA_VT";

    public ViTriHelper(Context context) {
        super(context, KEY_TABLE_VT, null, KEY_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBang = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)",
                NAME_DATA_BASE_VT, KEY_ID_VT, KEY_NAME_VT, KEY_MO_TA_VT);
        db.execSQL(taoBang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String xoaBang = String.format("DROP TABLE IF EXISTS %s", NAME_DATA_BASE_VT);
        db.execSQL(xoaBang);

        // Tạo lại bảng
        onCreate(db);
    }
}
