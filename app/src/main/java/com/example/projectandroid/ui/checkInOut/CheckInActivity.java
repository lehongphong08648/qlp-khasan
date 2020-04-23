package com.example.projectandroid.ui.checkInOut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.BookingStatus;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.QuocTich;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.BookingStatusRepo;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.repository.UserRepo;
import com.example.projectandroid.ui.Login;
import com.example.projectandroid.ui.bookingRoom.FragmentAddBooing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CheckInActivity extends AppCompatActivity {

AppCompatSpinner spClient;

Button btn_checkIn, btn_huy_checkIn;
List<Client> listQuocTich;
ClientRepo clientRepo;
Booking booking;
BookingRepo bookingRepo;

Rooms rooms;
RoomRepo roomRepo;

    Date dateNgayDen;
    Date dateNgayDi;

EditText tv_ngayDen_checkIn, tv_ngayDi_checkIn, edt_idBooking, edt_tienCoc;
ImageView img_ngayDen_checkIn, img_ngayDi_checkIn;

List<User> users;
UserRepo userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        users = new ArrayList<>();
        userRepo = new UserRepo(CheckInActivity.this);
        users = userRepo.getAll();

        edt_tienCoc = findViewById(R.id.edt_tienCoc);
        tv_ngayDen_checkIn = findViewById(R.id.tv_ngayDen_checkIn);
        tv_ngayDi_checkIn = findViewById(R.id.tv_ngayDi_checkIn);
        img_ngayDen_checkIn = findViewById(R.id.img_ngayDen_checkIn);
        img_ngayDi_checkIn = findViewById(R.id.img_ngayDi_checkIn);

        img_ngayDen_checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(tv_ngayDen_checkIn);
            }
        });

        img_ngayDi_checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(tv_ngayDi_checkIn);
            }
        });

        btn_checkIn = findViewById(R.id.btn_checkIn);
        btn_huy_checkIn = findViewById(R.id.btn_cancel_checkIn);
        spClient = findViewById(R.id.sp_client);
        showQuocTich();
        btn_checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                String idKor = bundle.getString("idKor");
                String IdRooms =  bundle.getString("Id");
                String Floor =  bundle.getString("Floor");
                String Service =  bundle.getString("Service");
                String Describe = bundle.getString("Describe");

                String ngayDen_checkInt = tv_ngayDen_checkIn.getText().toString();
                String ngayDi_checkInt = tv_ngayDi_checkIn.getText().toString();
                String tienCoc = edt_tienCoc.getText().toString();

                try {
                     dateNgayDen = simpleDateFormat1.parse(ngayDen_checkInt);
                     dateNgayDi = simpleDateFormat1.parse(ngayDi_checkInt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Client client = (Client) spClient.getSelectedItem();
                int idClient = client.getId();
                bookingRepo = new BookingRepo(CheckInActivity.this);
                booking = new Booking(IdRooms,idClient,Login.user.getIdUser(),dateNgayDen,dateNgayDi,Float.parseFloat(tienCoc));
                bookingRepo.insert(booking);
                tv_ngayDen_checkIn.setText("");
                tv_ngayDi_checkIn.setText("");
                edt_idBooking.setText("");
                edt_tienCoc.setText("");


            }
        });


    }

    public void showQuocTich(){
        //set spiner quốc tịch
        listQuocTich = new ArrayList<>();
        clientRepo = new ClientRepo(CheckInActivity.this);
        listQuocTich = clientRepo.getAll();

        ArrayAdapter<Client> kindOfRoomArrayAdapter = new ArrayAdapter<>(CheckInActivity.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClient.setAdapter(kindOfRoomArrayAdapter);
    }

    private void showDateTimeDialog(final TextView tv_dateTime){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        tv_dateTime.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(CheckInActivity.this,onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(CheckInActivity.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }
}
