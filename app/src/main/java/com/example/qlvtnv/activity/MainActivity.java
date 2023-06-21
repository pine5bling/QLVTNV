package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qlvtnv.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNV = findViewById(R.id.btnMain1);
        Button btnVT = findViewById(R.id.btnMain2);
        Button btnVTNV = findViewById(R.id.btnMain3);
        Button btnLietKe = findViewById(R.id.btnMain4);
        Button btnThongKe = findViewById(R.id.btnMain5);

        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NhanVienActivity.class);
                startActivity(intent);
            }
        });

        btnVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViTriActivity.class);
                startActivity(intent);
            }
        });

        btnVTNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViTriCongViecActivity.class);
                startActivity(intent);
            }
        });

        btnLietKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LietKeActivity.class);
                startActivity(intent);
            }
        });

        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThongKeActivity.class);
                startActivity(intent);
            }
        });

    }
}
