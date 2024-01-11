package com.example.quizapplication.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.quizapplication.Models.BienBao;
import com.example.quizapplication.R;

public class ChitietActivity extends AppCompatActivity {
    ImageView imageView;
    TextView noidung;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getBundleExtra("chitiet");
        BienBao bienBao = (BienBao) bundle.get("bienbao");
        imageView = findViewById(R.id.ivChitiet);
        noidung = findViewById(R.id.tvNoidung);
        Glide.with(imageView.getContext()).load(bienBao.getImage()).into(imageView);
        noidung.setText(bienBao.getNoidung());

    }
    @Override
    public void onBackPressed(){super.onBackPressed();}
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}