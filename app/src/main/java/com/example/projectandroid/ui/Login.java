package com.example.projectandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.UserRepo;
import com.example.projectandroid.ui.systemManager.SystemManagerActivity;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    EditText edt_tenNd_login, edt_makhau_login;
    Button dangNhap , DangKi;
    List<User> users;
    UserRepo userRepo;

    String userName = "";
    String mk = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_tenNd_login = findViewById(R.id.edt_tenND_login);
        edt_makhau_login = findViewById(R.id.edt_matKhau_login);

        dangNhap = findViewById(R.id.btn_dangNhap);
        DangKi = findViewById(R.id.btn_dangKy);

        users = new ArrayList<>();
        userRepo = new UserRepo(Login.this);
        users= userRepo.getAll();
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenND = edt_tenNd_login.getText().toString();
                String makhau = edt_makhau_login.getText().toString();
                if (tenND.isEmpty() || makhau.isEmpty()) {
                    if (tenND.isEmpty()) {
                        edt_tenNd_login.setError("Vui lòng nhập họ tên");
                    }
                    if (makhau.isEmpty()) {
                        edt_makhau_login.setError("Vui lòng nhập mật khẩu");
                    }
                } else {
                    String tk = edt_tenNd_login.getText().toString();
                    String mk = edt_makhau_login.getText().toString();
                    Intent intent = new Intent(Login.this, SystemManagerActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("tk",tk);
                    bundle.putString("mk",mk);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Sai họ tên hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
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
