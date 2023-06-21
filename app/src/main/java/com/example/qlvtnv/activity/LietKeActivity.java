package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class LietKeActivity extends AppCompatActivity {

    private NhanVienHelper nhanVienHelper;

    private DataBase dataBase;

    ListView lv;

    ArrayList<NhanVien> nhanViens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liet_ke_activity);

        lv = findViewById(R.id.lvLietKe);

        nhanVienHelper = new NhanVienHelper(this.getApplicationContext());
        dataBase = new DataBase(nhanVienHelper, this);

        getLietKeNV();
    }

    private void getLietKeNV() {
        nhanViens = dataBase.getLietKe();
        ArrayAdapter<NhanVien> nhanVienArrayAdapterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanViens);
        lv.setAdapter(nhanVienArrayAdapterAdapter);
    }
}
