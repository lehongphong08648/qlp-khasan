package com.example.projectandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.UserRepo;
import com.example.projectandroid.ui.systemManager.SystemManagerActivity;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    ImageView imgLogologin;
    TextView tvwellcome,tvcontinue;
    public static User user;

    EditText edt_tenNd_login, edt_makhau_login;
    Button dangNhap, DangKi;

    UserRepo userRepo;


    String userName = "";
    String mk = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imgLogologin = findViewById(R.id.imglogologin);
        tvwellcome = findViewById(R.id.tvwwellcome);
        tvcontinue = findViewById(R.id.tvcontinue);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.fale_in_anim);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.bot_animation);

        imgLogologin.startAnimation(animation);
        imgLogologin.startAnimation(animation1);
        tvcontinue.startAnimation(animation2);
        tvwellcome.startAnimation(animation2);

        edt_tenNd_login = findViewById(R.id.edt_tenND_login);
        edt_makhau_login = findViewById(R.id.edt_matKhau_login);

        dangNhap = findViewById(R.id.btn_dangNhap);
        DangKi = findViewById(R.id.btn_dangKy);

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

//                    user = userRepo.getUserByUserName(tk);
                    checkLogin(tenND,makhau);
//                    if (user != null){
//                        if (user.getPassword().matches(mk)){
//                            Intent intent = new Intent(Login.this, SystemManagerActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(Login.this, "Sai họ tên hoặc mật khẩu", Toast.LENGTH_SHORT).show();
//                        }
//                    }



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
            Intent intent = new Intent(Login.this, SystemManagerActivity.class);
                         startActivity(intent);
            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Login.this, "Sai họ tên hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }
}
