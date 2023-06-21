package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qlvtnv.R;
import com.example.qlvtnv.database.DataBase;

import java.util.ArrayList;

public class ThongKeActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_ke_activity);

        lv = findViewById(R.id.lvThongKe);

    }
}
