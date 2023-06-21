package com.example.qlvtnv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qlvtnv.R;
import com.example.qlvtnv.database.DatabaseHelper;
import com.example.qlvtnv.model.NhanVien;
import com.example.qlvtnv.model.ThongKe;

import java.util.List;

public class ThongKeActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private ListView lv;
    List<ThongKe> thongKes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_ke_activity);

        databaseHelper = new DatabaseHelper(getBaseContext());

        lv = findViewById(R.id.lvThongKe);

        getThongKeNV();
    }

    private void getThongKeNV() {
        thongKes = databaseHelper.layDanhSachThongKe();
        ArrayAdapter<ThongKe> thongKeArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thongKes);
        lv.setAdapter(thongKeArrayAdapter);
    }
}
