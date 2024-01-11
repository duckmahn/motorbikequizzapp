package com.example.quizapplication.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.MainActivity;
import com.example.quizapplication.R;

public class ShowScoreActivity extends AppCompatActivity {
    TextView TxtScore;
    TextView TxtStatus;
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        getSupportActionBar().hide();

        TxtScore = findViewById(R.id.txtscore);
        TxtStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));

        TxtScore.setText(scores);
        TxtStatus.setText(setStatus(scores));
        audio.start();
    }

    private String setStatus(String scores){
        int score = Integer.parseInt(scores);

        if(score >= 25){
            audio = MediaPlayer.create(this, R.raw.high_score);
            return "Bro u gud af!";
        }

        if (score >= 21){
            audio = MediaPlayer.create(this,  R.raw.medium_score);
            return "ĐẬU";
        }

        audio = MediaPlayer.create(this,  R.raw.low_score);
        return "RỚT";

    }


    public void goToHome(View v){
        Intent home = new Intent(this, SetsActivity.class);
        startActivity(home);
        finish();
    }

}
