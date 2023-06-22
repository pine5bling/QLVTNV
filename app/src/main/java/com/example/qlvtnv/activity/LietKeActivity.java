package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qlvtnv.R;
import com.example.qlvtnv.database.DatabaseHelper;
import com.example.qlvtnv.model.NhanVien;

import java.util.List;

public class LietKeActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView lv;
    List<NhanVien> nhanViens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liet_ke_activity);

        databaseHelper = new DatabaseHelper(getBaseContext());

        lv = findViewById(R.id.lvLietKe);

        getLietKeNV();
    }

    private void getLietKeNV() {
        nhanViens = databaseHelper.layDSLietKe();
        ArrayAdapter<NhanVien> nhanVienArrayAdapterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nhanViens);
        lv.setAdapter(nhanVienArrayAdapterAdapter);
    }
}
