package com.example.quizapplication.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapplication.DATABASE.BienBaoAdapter;
import com.example.quizapplication.DATABASE.DBHelper;
import com.example.quizapplication.Models.BienBao;
import com.example.quizapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BienBaoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BienBaoAdapter adapter;
    DBHelper dbHelper;
    EditText search;
    List<BienBao> bienBaoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        getSupportActionBar().hide();
        dbHelper = new DBHelper(this);
        bienBaoList = dbHelper.getAllCN();
        GridLayoutManager grid = new GridLayoutManager(this,1);
        recyclerView = findViewById(R.id.rvBienBao);
        recyclerView.setLayoutManager(grid);
        adapter = new BienBaoAdapter(bienBaoList);
        recyclerView.setAdapter(adapter);
        search();
    }

    public void search(){
        search = findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String keyword = s.toString();
                if(!TextUtils.isEmpty(s)){
                    List<BienBao> search = search(keyword);
                    adapter.setList(search);
                }else {
                    adapter.setList(dbHelper.getAllCN());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<BienBao> search(String keyword) {
        List<BienBao> search = new ArrayList<>();
        keyword = keyword.toLowerCase();
        for (BienBao bienBao : dbHelper.getAllCN()){
            if(bienBao.getName().toLowerCase().contains(keyword)){
                search.add(bienBao);
            }
        }
        return search;
    }
}