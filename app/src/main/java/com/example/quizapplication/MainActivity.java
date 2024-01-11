package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;

import com.example.quizapplication.Activities.BienBaoActivity;
import com.example.quizapplication.Activities.HistoryActivity;
import com.example.quizapplication.Activities.RandomActivity;
import com.example.quizapplication.Activities.SetsActivity;
import com.example.quizapplication.Activities.SettingActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
CardView DeNgauNhien,BoDeThi,CacBienBao,CacDeThiDaLam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        DeNgauNhien = findViewById(R.id.DeNgauNhien);
        BoDeThi = findViewById(R.id.BoDeThi);
        CacBienBao = findViewById(R.id.CacBienBao);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        CacDeThiDaLam = findViewById(R.id.CacDeThiDaLam);
        CacDeThiDaLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        DeNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                        startActivity(intent);
                    }
                });
        BoDeThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RandomActivity.class);
//                Random rd = new Random();
//                int[] arr = new int[25];
//                for (int i = 0; i < arr.length; i++) {
//                    arr[i] = rd.nextInt();}
//                intent.putExtra("randomnum",arr);
                startActivity(intent);
        }});
        CacBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BienBaoActivity.class);
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}