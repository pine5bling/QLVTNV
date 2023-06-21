package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qlvtnv.R;
import com.example.qlvtnv.database.DataBase;
import com.example.qlvtnv.database.NhanVienHelper;
import com.example.qlvtnv.database.ViTriCongViecHelper;
import com.example.qlvtnv.database.ViTriHelper;
import com.example.qlvtnv.model.ViTriCongViec;

import java.util.ArrayList;

public class ViTriCongViecActivity extends AppCompatActivity {

    private ViTriCongViecHelper viTriCongViecHelper;
    private NhanVienHelper nhanVienHelper;
    private ViTriHelper viTriHelper;

    private DataBase dataBase;

    private EditText edt3, edt4;

    Spinner sp1, sp2;

    private ListView lv;

    ArrayList<ViTriCongViec> viTriCongViecs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_tri_cong_viec_activity);

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        Button btnVTCV = findViewById(R.id.btnVTCV);
        lv = findViewById(R.id.lvVTCV);

        viTriCongViecHelper = new ViTriCongViecHelper(this.getApplicationContext());
        viTriHelper = new ViTriHelper(this.getApplicationContext());
        nhanVienHelper = new NhanVienHelper(this.getApplicationContext());

        dataBase = new DataBase(viTriCongViecHelper, nhanVienHelper, viTriHelper, this);

        setupSpinnerNV();
        setupSpinnerVT();

        btnVTCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViTriCongViec viTriCongViec = new ViTriCongViec();
                viTriCongViec.setIdNhanVien(Integer.parseInt(sp1.getSelectedItem().toString()));
                viTriCongViec.setIdViTri(Integer.parseInt(sp2.getSelectedItem().toString()));
                viTriCongViec.setThoiDiemGan(edt3.getText().toString());
                viTriCongViec.setMoTaCV(edt4.getText().toString());
                themVTCV(viTriCongViec);
                sp1.setSelection(0);
                sp2.setSelection(0);
                edt3.setText("");
                edt4.setText("");
            }
        });
    }

    private void setupSpinnerNV() {
        ArrayList<Integer> idNVList;
        idNVList = dataBase.getDSIdNV();
        ArrayAdapter<Integer> spinNV = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idNVList);
        sp1.setAdapter(spinNV);
    }

    private void setupSpinnerVT() {
        ArrayList<Integer> idVTList;
        idVTList = dataBase.getDSIdVT();
        ArrayAdapter<Integer> spinVT = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idVTList);
        sp2.setAdapter(spinVT);
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
