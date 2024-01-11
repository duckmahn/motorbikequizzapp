package com.example.quizapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizapplication.R;
import com.example.quizapplication.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        int totalScore = getIntent().getIntExtra("total", 0);
        int correctAns = getIntent().getIntExtra("score", 0);
        int wrongAns = totalScore - correctAns;
        binding.tvTotalQ.setText(String.valueOf(totalScore));
        binding.tvRightAns.setText(String.valueOf(correctAns));

        binding.tvWrongAns.setText(String.valueOf(wrongAns));
        binding.btnRetry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, SetsActivity.class);
                startActivity(intent);
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}