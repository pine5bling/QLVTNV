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
import com.example.qlvtnv.database.DatabaseHelper;
import com.example.qlvtnv.model.ViTriCongViec;

import java.util.ArrayList;
import java.util.List;

public class ViTriCongViecActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private EditText edt3, edt4;
    Spinner sp1, sp2;
    private ListView lv;
    List<ViTriCongViec> viTriCongViecs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_tri_cong_viec_activity);

        databaseHelper = new DatabaseHelper(getBaseContext());

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        Button btnVTCV = findViewById(R.id.btnVTCV);
        lv = findViewById(R.id.lvVTCV);

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
        List<Integer> idNVList;
        idNVList = databaseHelper.getDSIdNV();
        ArrayAdapter<Integer> spinNV = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idNVList);
        sp1.setAdapter(spinNV);
    }

    private void setupSpinnerVT() {
        List<Integer> idVTList;
        idVTList = databaseHelper.getDSIdVT();
        ArrayAdapter<Integer> spinVT = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idVTList);
        sp2.setAdapter(spinVT);
    }

    private void getVTCVList() {
        viTriCongViecs = databaseHelper.layDanhSachViTriCV();
        ArrayAdapter<ViTriCongViec> viTriCongViecArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viTriCongViecs);
        lv.setAdapter(viTriCongViecArrayAdapter);
    }

    private void themVTCV(ViTriCongViec viTriCongViec) {
        databaseHelper.themViTriCongViec(viTriCongViec);
        getVTCVList();
    }
}
