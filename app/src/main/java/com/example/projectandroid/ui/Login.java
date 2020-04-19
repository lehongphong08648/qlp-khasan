package com.example.projectandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;

public class Login extends AppCompatActivity {

    EditText edt_tenNd_login, edt_makhau_login;
    Button dangNhap , DangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_tenNd_login = findViewById(R.id.edt_tenND_login);
        edt_makhau_login = findViewById(R.id.edt_matKhau_login);

        dangNhap = findViewById(R.id.btn_dangNhap);
        DangKi = findViewById(R.id.btn_dangKy);

        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });

        DangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(Login.this,SignIn.class));
            }
        });
}
}
