package com.example.projectandroid.ui.systemManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectandroid.R;

public class FixUserActivity extends AppCompatActivity {
EditText edt_fix_maND, edt_fix_matKhauND, edt_fix_hoTenND, edt_fix_chucVuND;
Button btn_fixNguoiDung, btn_huyFixNguoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_fix_maND = findViewById(R.id.edt_fix_maND);
        edt_fix_matKhauND = findViewById(R.id.edt_fix_matKhauND);
        edt_fix_hoTenND = findViewById(R.id.edt_fix_hoTenND);
        edt_fix_chucVuND = findViewById(R.id.edt_fix_chucVuND);

        btn_fixNguoiDung = findViewById(R.id.btn_fixNguoiDung);
        btn_huyFixNguoiDung = findViewById(R.id.btn_huyFixNguoiDung);

        btn_fixNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fix_maND = edt_fix_maND.getText().toString();
                String fix_matKhauND = edt_fix_matKhauND.getText().toString();
                String fix_hoTenND = edt_fix_hoTenND.getText().toString();
                String fix_chucVuND = edt_fix_chucVuND.getText().toString();
            }
        });
        btn_huyFixNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FixUserActivity.this,FragmentStaff.class));
            }
        });
    }
}
