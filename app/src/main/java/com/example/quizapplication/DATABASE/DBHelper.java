package com.example.quizapplication.DATABASE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quizapplication.Models.BienBao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    String DATABASE_NAME="LT.db";
    String tblname="CacBienBaotbl";
    Context context;

    public DBHelper(Context context) {
        this.context= context;
        copyDatabaseFromAssets();
    }
    public SQLiteDatabase openDB(){
        return context.openOrCreateDatabase(DATABASE_NAME,Context.MODE_PRIVATE,null);
    }
    public void closeDB(SQLiteDatabase db){
        db.close();
    }
    public List<BienBao> getAllCN(){
        List<BienBao> tmp = new ArrayList<>();
        SQLiteDatabase db = openDB();
        Cursor cursor = db.query(tblname,null,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String TenBienBao = cursor.getString(1);
            String Hinh = cursor.getString(2);
            String NoiDung = cursor.getString(3);
            tmp.add(new BienBao(id,TenBienBao,Hinh,NoiDung));
        }
        closeDB(db);
        return tmp;

    }

    private void copyDatabaseFromAssets() {
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = context.getDatabasePath(DATABASE_NAME).getPath();
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
