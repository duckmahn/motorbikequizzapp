package com.example.quizapplication.DATABASE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.Models.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;


public class DethiDB {
    String DB_NAME = "DBBasic.db";
    SQLiteDatabase databases;
    ArrayList<SetAdapter> dethis;
    SetAdapter adapter;
    Context context;


    public DethiDB(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDB(){
        return context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE,null);
    }

    public ArrayList<Dethi> getDe(){
        ArrayList<Dethi> tmp = new ArrayList<>();
        String sql = "SELECT * FROM Basic GROUP BY made";
        databases = openDB();
        Cursor cursor = databases.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String opt1 = cursor.getString(2);
            String opt2 = cursor.getString(3);
            String opt3 = cursor.getString(4);
            String opt4 = cursor.getString(5);
            int made = cursor.getInt(6);
            String ans = cursor.getString(7);
            Dethi dethi = new Dethi(id,name,opt1,opt2,opt3,opt4,made,ans);
            tmp.add(dethi);
        }
        databases.close();
        return tmp;
    }

    public ArrayList<Dethi> getDeRandom() {
        ArrayList<Dethi> tmp = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Random random = new Random();
            int rand = random.nextInt();
            String sql = "SELECT id =" + rand + " FROM Basic LIMIT 1";
            databases = openDB();
            Cursor cursor = databases.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String opt1 = cursor.getString(2);
                String opt2 = cursor.getString(3);
                String opt3 = cursor.getString(4);
                String opt4 = cursor.getString(5);
                int made = cursor.getInt(6);
                String ans = cursor.getString(7);
                Dethi question = new Dethi(id, name, opt1, opt2, opt3, opt4, made, ans);
                tmp.add(question);
            }
        }
        return tmp;

    }


        public ArrayList<Dethi> getDeId(int idmade)
        {
            ArrayList<Dethi> tmp2 = new ArrayList<>();
            String sql = "SELECT * FROM Basic WHERE made = "+ idmade;
            databases = openDB();
            Cursor cursor = databases.rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String opt1 = cursor.getString(2);
                String opt2 = cursor.getString(3);
                String opt3 = cursor.getString(4);
                String opt4 = cursor.getString(5);
                int made = cursor.getInt(6);
                String ans = cursor.getString(7);
                Dethi question = new Dethi(id, name, opt1,opt2,opt3,opt4,made,ans);
                tmp2.add(question);
            }
            databases.close();
            return tmp2;
        }

    public void CopyDB() {
        File dbFile = context.getDatabasePath(DB_NAME);
        if(!dbFile.exists()){
            try {
                InputStream is= context.getAssets().open(DB_NAME);
                OutputStream os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0){
                    os.write(buffer);
                }

                os.flush();
                os.close();
                is.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
