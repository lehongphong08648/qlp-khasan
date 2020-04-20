package com.example.projectandroid.ui.checkInOut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectandroid.R;
import com.example.projectandroid.model.QuocTich;

import java.util.ArrayList;
import java.util.List;

public class CheckInActivity extends AppCompatActivity {
EditText edt_nameClient_checkIn,edt_idCard_checkIn,edt_location_checkIn
        ,edt_email_checkIn,edt_sdt_checkIn,edt_ngaySinh_checkIn,edt_vip_checkIn;
AppCompatSpinner spQuocTich;

Button btn_checkIn, btn_huy_checkIn;
List<QuocTich> listQuocTich;
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
        btn_huy_checkIn = findViewById(R.id.btn_cancel_client);
        spQuocTich = findViewById(R.id.sp_quocTich_checkIn);
        showQuocTich();
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

                /*
                * vì bundle chỉ
                *
                * */

//                String idKor = bundle.get("idKor");
//                String Id =  bundle.get("Id");
//                String Floor =  bundle.get("Floor");
//                String Service =  bundle.get("Service");
//                String Describe = bundle.get("Describe");
            }
        });


    }

    public void showQuocTich(){
        //set spiner quốc tịch
        listQuocTich = new ArrayList<>();
        QuocTich quocTich = new QuocTich("Việt Nam");
        QuocTich quocTich1 = new QuocTich("Úc");
        QuocTich quocTich2 = new QuocTich("Anh Quốc");
        QuocTich quocTich3 = new QuocTich("Mỹ");
        QuocTich quocTich4 = new QuocTich("Thái Lan");
        QuocTich quocTich5 = new QuocTich("Trung Quốc");
        QuocTich quocTich6 = new QuocTich("Nga");
        QuocTich quocTich7 = new QuocTich("Nhật Bản");
        QuocTich quocTich8 = new QuocTich("Hàn Quốc");
        QuocTich quocTich9 = new QuocTich("khác");

        listQuocTich.add(quocTich);listQuocTich.add(quocTich1);listQuocTich.add(quocTich2);
        listQuocTich.add(quocTich3);listQuocTich.add(quocTich4);listQuocTich.add(quocTich5);
        listQuocTich.add(quocTich6);listQuocTich.add(quocTich7);listQuocTich.add(quocTich8);listQuocTich.add(quocTich9);

        ArrayAdapter<QuocTich> kindOfRoomArrayAdapter = new ArrayAdapter<>(CheckInActivity.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuocTich.setAdapter(kindOfRoomArrayAdapter);
    }
}
