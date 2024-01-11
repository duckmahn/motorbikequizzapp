package com.example.quizapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.DATABASE.DethiDB;
import com.example.quizapplication.DATABASE.SetAdapter;
import com.example.quizapplication.Models.Question;
import com.example.quizapplication.R;
import com.example.quizapplication.SQLite.HistoryData;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    //ArrayList<Question> list = new ArrayList<>();
//    private int count = 0;
//    private int position = 0;
    private int score = 0;
    //CountDownTimer timer;

    private int position = 0;
    TextView Ques ;
    String Answer;
    String rightAnswer;
    RadioButton  Opt1, Opt2, Opt3, Opt4;
    RadioGroup radioGroup;
    Button confirm;

    ArrayList<Dethi> questions;
    SetAdapter adapter;
    DethiDB dethiDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().hide();

        Ques = (TextView)findViewById(R.id.tv_question);
        Opt1 = findViewById(R.id.rb_answer_a);
        Opt2 = findViewById(R.id.rb_answer_b);
        Opt3 = findViewById(R.id.rb_answer_c);
        Opt4 = findViewById(R.id.rb_answer_d);
        confirm = findViewById(R.id.confirm);
        radioGroup = findViewById(R.id.radioGroup);



        Intent intent = getIntent();
        int idmade = intent.getIntExtra("idDethi",0);

        position = idmade;
        dethiDB = new DethiDB(QuestionActivity.this );
        questions = dethiDB.getDeId(idmade);
        //Toast.makeText(this, "du lieu de " + idmade, Toast.LENGTH_SHORT).show();

        adapter = new SetAdapter(questions);
        loadQuestion();

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        loadQuestion();
    }


    private void loadQuestion(){
        if(questions.size() > 0) {
            Dethi q = questions.remove(0);
            Ques.setText(q.getQuestion());
            //String answers = q.getCorrectAnswer();

            Opt1.setText(q.getOptionA());
            Opt2.setText(q.getOptionB());
            Opt3.setText(q.getOptionC());
            Opt4.setText(q.getOptionD());

            rightAnswer = q.getCorrectAnswer();
            //Toast.makeText(this, "answer = " + rightAnswer, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ShowScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    public void loadAnswer(View view) {
        int op = radioGroup.getCheckedRadioButtonId();

        switch (op){
            case R.id.rb_answer_a:
                Answer="A";
                break;

            case R.id.rb_answer_b:
                Answer="B";
                break;

            case R.id.rb_answer_c:
                Answer="C";
                break;

            case R.id.rb_answer_d:
                Answer="D";
                break;

            default:
                return;

        }

        radioGroup.clearCheck();

        this.startActivity(isRightOrWrong(Answer));

    }

    private Intent isRightOrWrong(String Answer){
        Intent screen;
        if(Answer.equals(rightAnswer)) {
            this.score += 1;

            Dethi dethi = new Dethi(position,this.score);
            HistoryData.updateDiem(QuestionActivity.this,dethi);
            screen = new Intent(this, RightActivity.class);
        }else {
            screen = new Intent(this, WrongActivity.class);
        }
        return screen;
    }
}

