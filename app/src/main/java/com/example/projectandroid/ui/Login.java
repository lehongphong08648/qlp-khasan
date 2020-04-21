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

    //TODO: Anh lấy ra cả model luôn r e get id ra nhé
    //TODO:Đọc repo test xem nhé có gì lỗi bảo a
    //todo an vượt làm cả login luôn nhá, làm chất vào nhé !!!!
    public static User user;

    EditText edt_tenNd_login, edt_makhau_login;
    Button dangNhap, DangKi;
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
                    bundle.putString("tk", tk);
                    bundle.putString("mk", mk);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Sai họ tên hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignIn.class));
            }
        });
    }

    //TODO
    //Hàm check login trong db
    //Lắp hàm này vào btn đăng nhập lấy user Name và pass word của ng dùng nhập vào
    public void checkLogin(String userName, String password) {
        if (userRepo.checkUserLogin(userName, password).size() == 1) {
            user = userRepo.checkUserLogin(userName, password).get(0);

            //Xử lý tiếp nếu User đúng với db
        } else {
            //Xử lý nếu User sai
        }
    }
}
