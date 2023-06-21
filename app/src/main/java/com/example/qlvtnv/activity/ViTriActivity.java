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
import com.example.qlvtnv.database.DatabaseHelper;
import com.example.qlvtnv.model.ViTri;

import java.util.List;

public class ViTriActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Button btnVT;
    EditText edtNameVT, edtMoTaVT;
    ListView lv;
    List<ViTri> viTris;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_tri_activity);

        edtNameVT = findViewById(R.id.edtNameVT);
        edtMoTaVT = findViewById(R.id.edtMoTaVT);
        btnVT = findViewById(R.id.btnVT);
        lv = findViewById(R.id.lvVT);

        databaseHelper = new DatabaseHelper(getBaseContext());

        btnVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViTri viTri = new ViTri();
                viTri.setTenVT(edtNameVT.getText().toString());
                viTri.setMoTa(edtMoTaVT.getText().toString());
                themViTri(viTri);
                edtNameVT.setText("");
                edtMoTaVT.setText("");
            }
        });
    }
    private void getVTList() {
        viTris = databaseHelper.layDanhSachViTri();
        ArrayAdapter<ViTri> viTriArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viTris);
        lv.setAdapter(viTriArrayAdapter);
    }

    private void themViTri(ViTri viTri) {
        databaseHelper.themViTri(viTri);
        getVTList();
    }
}

