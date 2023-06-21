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
import com.example.qlvtnv.model.NhanVien;

import java.util.ArrayList;

public class NhanVienActivity extends AppCompatActivity {

    private NhanVienHelper nhanVienHelper;

    private DataBase dataBase;

    Button btnNV;
    EditText edtNV2, edtNV3, edtNV4;

    Spinner spNV5;
    ListView lv;
    ArrayList<NhanVien> nhanViens;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhan_vien_activity);

        edtNV2 = findViewById(R.id.edtNV2);
        edtNV3 = findViewById(R.id.edtNV3);
        edtNV4 = findViewById(R.id.edtNV4);
        spNV5 = findViewById(R.id.spNV5);
        btnNV = findViewById(R.id.btnNV);
        lv = findViewById(R.id.lvNV);

        nhanVienHelper = new NhanVienHelper(this.getApplicationContext());
        dataBase = new DataBase(nhanVienHelper, this);

        setupSpinner();
        getNV();

        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setTenNV(edtNV2.getText().toString());
                nhanVien.setNamSinh(Integer.parseInt(edtNV3.getText().toString()));
                nhanVien.setQueQuan(edtNV4.getText().toString());
                nhanVien.setTrinhDo(spNV5.getSelectedItem().toString());
                themNhanVien(nhanVien);
                edtNV2.setText("");
                edtNV3.setText("");
                edtNV4.setText("");
                edtNV2.setText("");
                spNV5.setSelection(0);
            }
        });
    }

    private void getNV() {
        nhanViens = dataBase.getDSNV();
        ArrayAdapter<NhanVien> nhanVienArrayAdapterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanViens);
        lv.setAdapter(nhanVienArrayAdapterAdapter);
    }

    private void setupSpinner() {
        ArrayList<String> trinhDoType = new ArrayList<>();
        trinhDoType.add("Cao đẳng");
        trinhDoType.add("Đại học");
        trinhDoType.add("Sau đại học");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, trinhDoType);
        spNV5.setAdapter(stringArrayAdapter);
    }

    private void themNhanVien(NhanVien nhanVien) {
        dataBase.themNV(nhanVien);
        getNV();
    }
}
