package com.example.quizapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.DATABASE.DethiDB;
import com.example.quizapplication.DATABASE.SetAdapter;
import com.example.quizapplication.R;

import java.util.ArrayList;

import com.example.quizapplication.DATABASE.SetAdapter.*;
import com.example.quizapplication.SQLite.HistoryData;

public class SetsActivity extends AppCompatActivity implements Listener {

    RecyclerView list;
    SetAdapter adapter;
    ArrayList<Dethi> dethis;
    DethiDB dethiDB;
    ImageView back;
    ConstraintLayout layout;
    TextView TotalTest , maxscore;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);
        getSupportActionBar().hide();

        back = findViewById(R.id.imageView2 );
        dethiDB = new DethiDB(SetsActivity.this);
        layout = findViewById(R.id.history);
        TotalTest = (TextView)findViewById(R.id.totaltest);
        maxscore = findViewById(R.id.maxscore);

        initPreferences();
        String saveData = sharedPreferences.getString("DATA","");
        TotalTest.setText(saveData);


        dethis = dethiDB.getDe();
        list = findViewById(R.id.rvSets);
        adapter = new SetAdapter(dethis, this::onItemListener) ;
        list.setLayoutManager(new LinearLayoutManager(SetsActivity.this,LinearLayoutManager.VERTICAL,false));
        list.setAdapter(adapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetsActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }


    @Override
    public void onItemListener(Dethi dethi) {
        int id = dethi.getId();
        String name = dethi.getQuestion();
        String A = dethi.getOptionA();
        String B = dethi.getOptionB();
        String C = dethi.getOptionC();
        String D = dethi.getOptionD();
        int made = dethi.getMade();
        String ans = dethi.getCorrectAnswer();
        int score = dethi.getScore();
        Dethi dethi1 = new Dethi(id,name,A,B,C,D,made,ans,score);
        HistoryData.insert(SetsActivity.this,dethi1);
        Intent intent = new Intent(SetsActivity.this,QuestionActivity.class);
        int idmade = dethi.getMade();
        intent.putExtra("idDethi",idmade) ;
//        if (dethi.getMade() == 1)
//            Toast.makeText(this, "de 1", Toast.LENGTH_SHORT).show();
//        if (dethi.getMade() == 2)
//            Toast.makeText(this, "de 2", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}