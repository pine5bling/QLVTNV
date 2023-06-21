package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qlvtnv.R;
import com.example.qlvtnv.database.DataBase;
import com.example.qlvtnv.database.ViTriCongViecHelper;
import com.example.qlvtnv.model.ViTriCongViec;

import java.util.ArrayList;

public class ViTriCongViecActivity extends AppCompatActivity {

    private ViTriCongViecHelper viTriCongViecHelper;

    private DataBase dataBase;

    private EditText edt1, edt2, edt3, edt4;

    private ListView lv;

    ArrayList<ViTriCongViec> viTriCongViecs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_tri_cong_viec_activity);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        Button btnVTCV = findViewById(R.id.btnVTCV);
        lv = findViewById(R.id.lvVTCV);

        viTriCongViecHelper = new ViTriCongViecHelper(this.getApplicationContext());
        dataBase = new DataBase(viTriCongViecHelper, this);

        btnVTCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViTriCongViec viTriCongViec = new ViTriCongViec();
                viTriCongViec.setIdNhanVien(Integer.parseInt(edt1.getText().toString()));
                viTriCongViec.setIdViTri(Integer.parseInt(edt2.getText().toString()));
                viTriCongViec.setThoiDiemGan(edt3.getText().toString());
                viTriCongViec.setMoTaCV(edt4.getText().toString());
                themVTCV(viTriCongViec);
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");
                edt4.setText("");
            }
        });
    }

    private void getVTCV() {
        viTriCongViecs = dataBase.getDSVTCV();
        ArrayAdapter<ViTriCongViec> viTriCongViecArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viTriCongViecs);
        lv.setAdapter(viTriCongViecArrayAdapter);
    }

    private void themVTCV(ViTriCongViec viTriCongViec) {
        dataBase.themVTCV(viTriCongViec);
        getVTCV();
    }
}
