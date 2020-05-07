package com.example.projectandroid.ui.systemManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.QuocTich;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.ui.bookingRoom.FragmentAddBooing;
import com.example.projectandroid.ui.checkInOut.CheckInActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddClientActivity extends AppCompatActivity {
EditText edt_nameClient, edt_idCard, edt_location, edt_sdt, edt_ngaySinh, edt_vip, edt_email;
AppCompatSpinner sp_quocTich_client;
Button btn_add_client, btn_cancel_client;
List<QuocTich>listQuocTich;

Client client;
ClientRepo clientRepo;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_nameClient = findViewById(R.id.edt_nameClient);
        edt_idCard = findViewById(R.id.edt_idCard);
        edt_location = findViewById(R.id.edt_location);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_ngaySinh = findViewById(R.id.edt_ngaySinh);
        edt_vip = findViewById(R.id.edt_vip);
        edt_email = findViewById(R.id.edt_email);

        btn_add_client = findViewById(R.id.btn_add_client);
        btn_cancel_client = findViewById(R.id.btn_cancel_client);

        sp_quocTich_client = findViewById(R.id.sp_quocTich_client);
        showQuocTich();

        edt_ngaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edt_ngaySinh);
            }
        });

        btn_add_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameClient = edt_nameClient.getText().toString();
                String idCard = edt_idCard.getText().toString();
                String location = edt_location.getText().toString();
                String sdt = edt_sdt.getText().toString();
                String ngaySinh = edt_ngaySinh.getText().toString();
                String vip = edt_vip.getText().toString();
                String email = edt_email.getText().toString();
                QuocTich mQuocTich = (QuocTich) sp_quocTich_client.getSelectedItem();
                String quocTich = mQuocTich.getQuocTich();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                     date = simpleDateFormat.parse(ngaySinh);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (nameClient.isEmpty()){
                    edt_nameClient.setError("Vui lòng không bỏ trống khách hàng");
                }
                if (idCard.isEmpty()){
                    edt_idCard.setError("Vui lòng không bỏ trống CMNN");
                }
                if (location.isEmpty()){
                    edt_location.setError("Vui lòng không bỏ trống địa chỉ");
                }
                if (sdt.isEmpty()){
                    edt_sdt.setError("Vui lòng không bỏ trống SDT");
                }
                if (ngaySinh.isEmpty()){
                    edt_ngaySinh.setError("Vui lòng không bỏ trống ngày sinh");
                }
                if (vip.isEmpty()){
                    edt_vip.setError("Vui lòng không bỏ trống VIP");
                }
                if (email.isEmpty()){
                    edt_email.setError("Vui lòng không bỏ trống email");
                }else {
                    clientRepo = new ClientRepo(AddClientActivity.this);
                    client = new Client(nameClient,idCard,quocTich,location,Integer.parseInt(sdt),Integer.parseInt(vip),date,email);
                    clientRepo.insert(client);

                    edt_nameClient.setText("");
                    edt_idCard.setText("");
                    edt_location.setText("");
                    edt_sdt.setText("");
                    edt_ngaySinh.setText("");
                    edt_vip.setText("");
                    edt_email.setText("");
                }



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

        ArrayAdapter<QuocTich> kindOfRoomArrayAdapter = new ArrayAdapter<>(AddClientActivity.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_quocTich_client.setAdapter(kindOfRoomArrayAdapter);
    }

    private void showDateDialog(final EditText edt_date){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy ");
                edt_date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new DatePickerDialog(AddClientActivity.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}
