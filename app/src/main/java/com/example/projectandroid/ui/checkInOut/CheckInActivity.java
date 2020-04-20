package com.example.projectandroid.ui.checkInOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.projectandroid.R;

public class CheckInActivity extends AppCompatActivity {
EditText edt_nameClient_checkIn,edt_idCard_checkIn,edt_location_checkIn
        ,edt_email_checkIn,edt_sdt_checkIn,edt_ngaySinh_checkIn,edt_vip_checkIn;
Spinner spQuocTich;

Button btn_checkIn, btn_huy_checkIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_nameClient_checkIn = findViewById(R.id.edt_nameClient_checkIn);
        edt_idCard_checkIn = findViewById(R.id.edt_idCard_checkIn);
        edt_location_checkIn = findViewById(R.id.edt_location_checkIn);
        edt_email_checkIn = findViewById(R.id.edt_email_checkIn);
        edt_sdt_checkIn = findViewById(R.id.edt_sdt_checkIn);
        edt_ngaySinh_checkIn = findViewById(R.id.edt_ngaySinh_checkIn);
        edt_vip_checkIn = findViewById(R.id.edt_vip_checkIn);

        btn_checkIn = findViewById(R.id.btn_checkIn);
        btn_huy_checkIn = findViewById(R.id.btn_cancel_checkIn);
        spQuocTich = findViewById(R.id.sp_quocTich_checkIn);

        btn_checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameClient_checkIn = edt_nameClient_checkIn.getText().toString();
                String idCard_checkIn = edt_nameClient_checkIn.getText().toString();
                String location_checkIn = edt_nameClient_checkIn.getText().toString();
                String email_checkIn = edt_nameClient_checkIn.getText().toString();
                String sdt_checkIn = edt_nameClient_checkIn.getText().toString();
                String ngaySinh_checkIn = edt_nameClient_checkIn.getText().toString();
                String vip_checkIn = edt_nameClient_checkIn.getText().toString();
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();

            }
        });


    }
}
