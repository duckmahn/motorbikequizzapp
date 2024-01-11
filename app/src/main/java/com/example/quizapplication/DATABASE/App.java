package com.example.quizapplication.DATABASE;

import android.app.Application;

public class App extends Application {
    DethiDB dethiDB;

    @Override
    public void onCreate() {
        super.onCreate();

            dethiDB =  new DethiDB(this);
            dethiDB.CopyDB();
        }
    }

