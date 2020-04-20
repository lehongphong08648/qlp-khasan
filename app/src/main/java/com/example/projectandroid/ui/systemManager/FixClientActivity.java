package com.example.projectandroid.ui.systemManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.QuocTich;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FixClientActivity extends AppCompatActivity {
    EditText edt_fix_nameClient, edt_fix_idCard, edt_fix_location, edt_fix_sdt, edt_fix_ngaySinh, edt_fix_vip, edt_fix_email;
    AppCompatSpinner sp_fix_quocTich_client;
    Button btn_fix_client, btn_cancel_fix_client;
    List<QuocTich> listQuocTich;
    String idClient;
    Client client;
    ClientRepo clientRepo;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_client);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edt_fix_nameClient = findViewById(R.id.edt_fix_nameClient);
        edt_fix_idCard = findViewById(R.id.edt_fix_idCard);
        edt_fix_location = findViewById(R.id.edt_fix_location);
        edt_fix_sdt = findViewById(R.id.edt_fix_sdt);
        edt_fix_ngaySinh = findViewById(R.id.edt_fix_ngaySinh);
        edt_fix_vip = findViewById(R.id.edt_fix_vip);
        edt_fix_email = findViewById(R.id.edt_fix_email);

        btn_fix_client = findViewById(R.id.btn_fix_client);
        btn_cancel_fix_client = findViewById(R.id.btn_cancel_fix_client);

        sp_fix_quocTich_client = findViewById(R.id.sp_fix_quocTich_client);
        showQuocTich();

        edt_fix_ngaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edt_fix_ngaySinh);
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        edt_fix_nameClient.setText(bundle.getString("nameClient"));
        edt_fix_idCard.setText(bundle.getString("idCard"));
        edt_fix_location.setText(bundle.getString("Address"));
        edt_fix_sdt.setText(bundle.getString("PhoneNumber"));
        edt_fix_ngaySinh.setText(bundle.getString("BirthOfDate"));
        edt_fix_vip.setText(bundle.getString("vip"));
        edt_fix_email.setText(bundle.getString("Email"));
        idClient = bundle.getString("Id");
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

        ArrayAdapter<QuocTich> kindOfRoomArrayAdapter = new ArrayAdapter<>(FixClientActivity.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_fix_quocTich_client.setAdapter(kindOfRoomArrayAdapter);
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

        new DatePickerDialog(FixClientActivity.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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

            String nameClient = edt_fix_nameClient.getText().toString();
            String idCard = edt_fix_idCard.getText().toString();
            String location = edt_fix_location.getText().toString();
            String sdt = edt_fix_sdt.getText().toString();
            String ngaySinh = edt_fix_ngaySinh.getText().toString();
            String vip = edt_fix_vip.getText().toString();
            String email = edt_fix_email.getText().toString();
            QuocTich mQuocTich = (QuocTich) sp_fix_quocTich_client.getSelectedItem();
            String quocTich = mQuocTich.getQuocTich();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = simpleDateFormat.parse(ngaySinh);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            clientRepo = new ClientRepo(FixClientActivity.this);
            client = new Client(nameClient,idCard,quocTich,location,Integer.parseInt(sdt),Integer.parseInt(vip),date,email);
            client.setId(Integer.parseInt(idClient));
            clientRepo.delete(client);
            startActivity(new Intent(FixClientActivity.this,ClientActivity.class));
            Toast.makeText(FixClientActivity.this,"Đã xóa",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
