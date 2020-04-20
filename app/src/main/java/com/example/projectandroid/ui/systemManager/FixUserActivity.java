package com.example.projectandroid.ui.systemManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectandroid.R;
import com.example.projectandroid.repository.KorRepo;

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

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        edt_fix_maND.setText(bundle.getString("maND_user"));
        edt_fix_hoTenND.setText(bundle.getString("hoTen_user"));
        edt_fix_matKhauND.setText(bundle.getString("matKhau_user"));
        edt_fix_chucVuND.setText(bundle.getString("chucVu_user"));

        btn_fixNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fix_maND = edt_fix_maND.getText().toString();
                String fix_matKhauND = edt_fix_matKhauND.getText().toString();
                String fix_hoTenND = edt_fix_hoTenND.getText().toString();
                String fix_chucVuND = edt_fix_chucVuND.getText().toString();

                if (fix_hoTenND.isEmpty()){
                    edt_fix_hoTenND.setError("Vui lòng nhập họ tên");
                }
                else if (fix_matKhauND.isEmpty()){
                    edt_fix_matKhauND.setError("Vui lòng nhập họ tên");
                }
                else if (fix_hoTenND.isEmpty()){
                    edt_fix_chucVuND.setError("Vui lòng nhập họ tên");
                }else {

                }
            }
        });
        btn_huyFixNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FixUserActivity.this,FragmentStaff.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete){

        }
        return super.onOptionsItemSelected(item);
    }
}
