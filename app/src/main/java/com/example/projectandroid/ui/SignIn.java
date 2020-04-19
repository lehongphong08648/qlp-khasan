package com.example.projectandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.UserRepo;

public class SignIn extends AppCompatActivity {
EditText edt_maND_signIn, edt_matKhauND_signIn, edt_hoTenND_signIn, edt_chucVuND_signIn;
Button btn_dangKy_signIn, btn_huy_signIn;
User user;
UserRepo userRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edt_maND_signIn = findViewById(R.id.edt_maND_signIn);
        edt_matKhauND_signIn = findViewById(R.id.edt_matKhauND_signIn);
        edt_hoTenND_signIn = findViewById(R.id.edt_hoTenND_signIn);
        edt_chucVuND_signIn = findViewById(R.id.edt_chucVuND_signIn);

        btn_dangKy_signIn = findViewById(R.id.btn_dangKy_signIn);
        btn_huy_signIn = findViewById(R.id.btn_huy_signIn);

        btn_dangKy_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maND_signIn = edt_maND_signIn.getText().toString();
                String matKhauND_signIn = edt_matKhauND_signIn.getText().toString();
                String hoTenND_signIn = edt_hoTenND_signIn.getText().toString();
                String chucVuND_signIn = edt_chucVuND_signIn.getText().toString();

                if (matKhauND_signIn.isEmpty()){
                    edt_matKhauND_signIn.setError("Vui lòng không bỏ trống mật khẩu");
                }
                else if(hoTenND_signIn.isEmpty()){
                    edt_hoTenND_signIn.setError("Vui lòng không bỏ trống mật khẩu");
                }
                else if(chucVuND_signIn.isEmpty()){
                    edt_chucVuND_signIn.setError("Vui lòng không bỏ trống mật khẩu");
                }else {
                    user = new User(matKhauND_signIn,hoTenND_signIn,chucVuND_signIn);
                    userRepo = new UserRepo(SignIn.this);
                    userRepo.insert(user);
                    Toast.makeText(SignIn.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                    edt_maND_signIn.setText("");
                    edt_matKhauND_signIn.setText("");
                    edt_hoTenND_signIn.setText("");
                    edt_chucVuND_signIn.setText("");
                    mdialog();
                }



            }
        });

        btn_huy_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this,Login.class));
            }
        });
    }

    private void mdialog(){
        //showw id lên không người dùng đăng nhập bằng liền tin hhi
    }
}
