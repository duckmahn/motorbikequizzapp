package com.example.quizapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.R;
import com.example.quizapplication.SQLite.HistoryAdapter;
import com.example.quizapplication.SQLite.HistoryDB;
import com.example.quizapplication.SQLite.HistoryData;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    HistoryAdapter historyAdapter;
    HistoryDB historyDB;
    ArrayList<Dethi> dethis;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.rvHis);
        back = findViewById(R.id.imageView2 );
        historyDB = new HistoryDB(HistoryActivity.this);
        dethis = HistoryData.getDe(HistoryActivity.this);
        historyAdapter = new HistoryAdapter(HistoryActivity.this,dethis);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HistoryActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(historyAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}