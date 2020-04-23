package com.example.projectandroid.ui.bookingRoom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;

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
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.QuocTich;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.Login;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentAddBooing extends AppCompatActivity {
    EditText edt_ngaySinh;
    EditText edt_datCoc;
    EditText tv_ngayDen, tv_ngayDi;
    ImageView img_ngayDen, img_ngayDi;

    AppCompatSpinner sp_client, sp_maPhong;

    Button btn_add_booking, btn_cancel_booking;

    List<QuocTich> listQuocTich;
    List<Rooms> rooms;
    RoomRepo roomRepo;

    Booking booking;
    BookingRepo bookingRepo;

    Client client;
    ClientRepo clientRepo;
    List<Client> clients;

    Date mNgayDen;
    Date mNgayDi;
    Date mNgaySinh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_booing_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_ngayDen = findViewById(R.id.tv_ngayDen);
        tv_ngayDi = findViewById(R.id.tv_ngayDi_fixBooing);
        edt_datCoc = findViewById(R.id.edt_datCoc);

        img_ngayDen = findViewById(R.id.img_ngayDen);
        img_ngayDi = findViewById(R.id.img_ngayDi);

        sp_maPhong = findViewById(R.id.sp_maPhong);
        sp_client = findViewById(R.id.sp_client_booking);

        btn_add_booking = findViewById(R.id.btn_booking);
        mCreateEvent();

        //đổ phòng ra sp
        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(FragmentAddBooing.this);
        rooms = roomRepo.getAll();
        ArrayAdapter<Rooms> roomsArrayAdapter = new ArrayAdapter<>(FragmentAddBooing.this,android.R.layout.simple_spinner_item,rooms);
        roomsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_maPhong.setAdapter(roomsArrayAdapter);

        //đổ khách hàng ra sp
        clients = new ArrayList<>();
        clientRepo = new ClientRepo(this);
        clients = clientRepo.getAll();
        ArrayAdapter<Client> clientArrayAdapter = new ArrayAdapter<>(FragmentAddBooing.this,android.R.layout.simple_spinner_item,clients);
        roomsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_client.setAdapter(clientArrayAdapter);
    }



    public void mCreateEvent(){

        img_ngayDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(tv_ngayDen);
            }
        });

        img_ngayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(tv_ngayDi);
            }
        });


        btn_add_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rooms mRooms = (Rooms) sp_maPhong.getSelectedItem();
                String maPhong = mRooms.getId();
                client = (Client) sp_client.getSelectedItem();
                int idKhachHang = client.getId();

                String ngayDen = tv_ngayDen.getText().toString();
                String ngayDi = tv_ngayDi.getText().toString();
                String datCoc = edt_datCoc.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");


                if (ngayDen.isEmpty()){
                    tv_ngayDen.setError("Vui lòng nhập tên khách hàng");
                }if (ngayDi.isEmpty()){
                    tv_ngayDi.setError("Vui lòng nhập tên khách hàng");
                }if (datCoc.isEmpty()){
                    edt_datCoc.setError("Vui lòng nhập tên khách hàng");
                }
                else {
                    try {
                         mNgayDen =simpleDateFormat.parse(ngayDen);
                        mNgayDi = simpleDateFormat.parse(ngayDi);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    booking =new Booking(maPhong,idKhachHang, Login.user.getIdUser(),mNgayDen,mNgayDi,Float.parseFloat(datCoc));
                    tv_ngayDen.setText("");
                    tv_ngayDi.setText("");
                    edt_datCoc.setText("");
                }
            }
        });

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
                new TimePickerDialog(FragmentAddBooing.this,onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(FragmentAddBooing.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

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

        new DatePickerDialog(FragmentAddBooing.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}

