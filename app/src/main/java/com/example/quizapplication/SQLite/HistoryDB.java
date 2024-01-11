package com.example.quizapplication.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoryDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME=Utils.DATABASE_NAME;
    private static final int DATABASE_VERSION=1;
    Context context;
    public HistoryDB(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ Utils.TABLE_BAITHI + "(" +
                Utils.COLUMN_BAITHI_ID + " INTEGER ," +
                Utils.COLUMN_BAITHI_QUESTION + " TEXT, " +
                Utils.COLUMN_BAITHI_OPTIONA+ " TEXT, " +
                Utils.COLUMN_BAITHI_OPTIONB + " TEXT, " +
                Utils.COLUMN_BAITHI_OPTIONC + " TEXT, " +
                Utils.COLUMN_BAITHI_OPTIOND + " TEXT, " +
                Utils.COLUMN_BAITHI_MADE + " INTEGER PRIMARY KEY, " +
                Utils.COLUMN_BAITHI_CORECTANSWER + " TEXT, " +
                Utils.COLUMN_BAITHI_SCORE + " INTEGER " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utils.TABLE_BAITHI);
        onCreate(db);
    }
}
