package com.example.quizapplication.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quizapplication.DATABASE.SetAdapter;
import com.example.quizapplication.Models.Dethi;

import java.util.ArrayList;

public class HistoryData {
    String DB_NAME = "DBBasic.db";
    SQLiteDatabase databases;
    ArrayList<SetAdapter> dethis;
    SetAdapter adapter;
    Context context;
    public static  long insert(Context context , Dethi dethi){
        HistoryDB db = new HistoryDB(context);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utils.COLUMN_BAITHI_ID, dethi.getId() );
        values.put(Utils.COLUMN_BAITHI_QUESTION, dethi.getQuestion());
        values.put(Utils.COLUMN_BAITHI_OPTIONA , dethi.getOptionA());
        values.put(Utils.COLUMN_BAITHI_OPTIONB , dethi.getOptionB());
        values.put(Utils.COLUMN_BAITHI_OPTIONC , dethi.getOptionC());
        values.put(Utils.COLUMN_BAITHI_OPTIOND , dethi.getOptionD());
        values.put(Utils.COLUMN_BAITHI_MADE, dethi.getMade());
        values.put(Utils.COLUMN_BAITHI_CORECTANSWER, dethi.getCorrectAnswer());
        values.put(Utils.COLUMN_BAITHI_SCORE, dethi.getScore());
        long rs=sqLiteDatabase.insert(Utils.TABLE_BAITHI,null,values);
        return (rs);
    }
    public static boolean delete(Context context,String made)
    {
        HistoryDB historyDB = new HistoryDB(context);
        SQLiteDatabase sqLiteDatabase=historyDB.getWritableDatabase();
        int rs=sqLiteDatabase.delete(Utils.TABLE_BAITHI,Utils.COLUMN_BAITHI_MADE+"=?",new String[]{String.valueOf(made)});
        return (rs>0);
    }
    public static long updateDiem(Context context, Dethi dethi){
        HistoryDB db = new HistoryDB(context);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utils.COLUMN_BAITHI_SCORE,dethi.getScore());
        long rs = sqLiteDatabase.update(Utils.TABLE_BAITHI,values,Utils.COLUMN_BAITHI_MADE+"=?",new String[]{String.valueOf(dethi.getMade())});
        return rs;
    }
    public static ArrayList<Dethi> getDe(Context context){
        ArrayList<Dethi> tmp = new ArrayList<>();
        HistoryDB historyDB = new HistoryDB(context);
        SQLiteDatabase databases = historyDB.getReadableDatabase();
        Cursor cursor = databases.rawQuery("select * from " + Utils.TABLE_BAITHI + " GROUP BY made ",null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String opt1 = cursor.getString(2);
            String opt2 = cursor.getString(3);
            String opt3 = cursor.getString(4);
            String opt4 = cursor.getString(5);
            int made = cursor.getInt(6);
            String ans = cursor.getString(7);
            int score = cursor.getInt(8);
            Dethi dethi = new Dethi(id,name,opt1,opt2,opt3,opt4,made,ans,score);
            tmp.add(dethi);
        }
        databases.close();
        return tmp;
    }
}
