package com.example.projectandroid.ui.systemManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.UserRepo;

public class Fragment_Add_User extends AppCompatActivity {
    EditText edt_maND, edt_matKhauND, edt_hoTenND, edt_chucVuND;
    Button btn_themNguoiDung,btn_huyThemNguoiDung;

    User user;
    UserRepo userRepo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment__add__user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_maND = findViewById(R.id.edt_maND);
        edt_matKhauND = findViewById(R.id.edt_matKhauND);
        edt_hoTenND = findViewById(R.id.edt_hoTenND);
        edt_chucVuND = findViewById(R.id.edt_chucVuND);

        btn_themNguoiDung = findViewById(R.id.btn_themNguoiDung);
        btn_huyThemNguoiDung = findViewById(R.id.btn_huyThemNguoiDung);

        btn_themNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maND = edt_maND.getText().toString();
                String matKhauND = edt_matKhauND.getText().toString();
                String hoTenND = edt_hoTenND.getText().toString();
                String chucVuND = edt_chucVuND.getText().toString();
                if (matKhauND.isEmpty()){
                    edt_matKhauND.setError("Vui lòng không bỏ trống mật khẩu");
                }else if (hoTenND.isEmpty()){
                    edt_matKhauND.setError("Vui lòng không bỏ trống họ tên");
                }
                else if (chucVuND.isEmpty()){
                    edt_matKhauND.setError("Vui lòng không bỏ trống chức vụ");
                }else {
                    //todo: Xử lý lại constructor user
                    //user = new User(matKhauND,hoTenND,chucVuND);
                    userRepo = new UserRepo(Fragment_Add_User.this);
                    user = new User(maND,matKhauND,hoTenND,chucVuND);
                    userRepo.insert(user);
                    Toast.makeText(Fragment_Add_User.this,"Đăng kí thàng công",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_huyThemNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fragment_Add_User.this,FragmentStaff.class));
            }
        });
    }


}
