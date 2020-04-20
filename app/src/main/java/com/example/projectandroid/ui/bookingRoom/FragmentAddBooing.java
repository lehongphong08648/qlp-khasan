package com.example.projectandroid.ui.bookingRoom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.model.QuocTich;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.systemManager.FragmentAddRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FragmentAddBooing extends AppCompatActivity {
    EditText edt_nameClient, edt_idCard, edt_locationClient, edt_sdt, edt_ngaySinh, edt_vip, edt_email;
    EditText edt_giaCb, edt_datCoc;
    EditText tv_ngayDen, tv_ngayDi;
    ImageView img_ngayDen, img_ngayDi;

    AppCompatSpinner sp_quocTich, sp_maPhong;

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

        edt_nameClient = findViewById(R.id.edt_nameClient);
        edt_idCard = findViewById(R.id.edt_idCard);
        edt_locationClient = findViewById(R.id.edt_location);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_ngaySinh = findViewById(R.id.edt_ngaySinh);
        edt_vip = findViewById(R.id.edt_vip);
        edt_email = findViewById(R.id.edt_email);
        tv_ngayDen = findViewById(R.id.tv_ngayDen);
        tv_ngayDi = findViewById(R.id.tv_ngayDi);
        edt_giaCb = findViewById(R.id.edt_giaCB);
        edt_datCoc = findViewById(R.id.edt_datCoc);


        img_ngayDen = findViewById(R.id.img_ngayDen);
        img_ngayDi = findViewById(R.id.img_ngayDi);

        edt_ngaySinh.setInputType(InputType.TYPE_NULL);

        sp_quocTich = findViewById(R.id.sp_quocTich);
        sp_maPhong = findViewById(R.id.sp_maPhong);

        btn_add_booking = findViewById(R.id.btn_booking);
        btn_cancel_booking = findViewById(R.id.btn_cancel_booking);

        mCreateEvent();

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
        ArrayAdapter<QuocTich> kindOfRoomArrayAdapter = new ArrayAdapter<>(FragmentAddBooing.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_quocTich.setAdapter(kindOfRoomArrayAdapter);

        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(FragmentAddBooing.this);
        rooms = roomRepo.getAll();
        ArrayAdapter<Rooms> roomsArrayAdapter = new ArrayAdapter<>(FragmentAddBooing.this,android.R.layout.simple_spinner_item,rooms);
        roomsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_maPhong.setAdapter(roomsArrayAdapter);
    }



    public void mCreateEvent(){
        edt_ngaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edt_ngaySinh);
            }
        });

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
                QuocTich mQuocTich = (QuocTich) sp_quocTich.getSelectedItem();
                String quocTich = mQuocTich.getQuocTich();
                Rooms mRooms = (Rooms) sp_maPhong.getSelectedItem();
                String maPhong = mRooms.getId();

                String nameClient = edt_nameClient.getText().toString();
                String idCard = edt_idCard.getText().toString();
                String locationClient = edt_locationClient.getText().toString();
                String sdt = edt_sdt.getText().toString();
                String ngaySinh = edt_ngaySinh.getText().toString();
                String vip = edt_vip.getText().toString();
                String email = edt_email.getText().toString();
                String ngayDen = tv_ngayDen.getText().toString();
                String ngayDi = tv_ngayDi.getText().toString();
                String giaCb = edt_giaCb.getText().toString();
                String datCoc = edt_datCoc.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                if (nameClient.isEmpty()){
                    edt_nameClient.setError("Vui lòng nhập tên khách hàng");
                }
                if (idCard.isEmpty()){
                    edt_idCard.setError("Vui lòng nhập tên khách hàng");
                }
                if (locationClient.isEmpty()){
                    edt_locationClient.setError("Vui lòng nhập tên khách hàng");
                }
                if (sdt.isEmpty()){
                    edt_sdt.setError("Vui lòng nhập tên khách hàng");
                }
                if (ngaySinh.isEmpty()){
                    edt_ngaySinh.setError("Vui lòng nhập tên khách hàng");
                }if (vip.isEmpty()){
                    edt_vip.setError("Vui lòng nhập tên khách hàng");
                }if (email.isEmpty()){
                    edt_email.setError("Vui lòng nhập tên khách hàng");
                }if (ngayDen.isEmpty()){
                    tv_ngayDen.setError("Vui lòng nhập tên khách hàng");
                }if (ngayDi.isEmpty()){
                    tv_ngayDi.setError("Vui lòng nhập tên khách hàng");
                }if (giaCb.isEmpty()){
                    edt_giaCb.setError("Vui lòng nhập tên khách hàng");
                }if (datCoc.isEmpty()){
                    edt_datCoc.setError("Vui lòng nhập tên khách hàng");
                }
                else {
                    try {
                         mNgayDen =simpleDateFormat.parse(ngayDen);
                         mNgaySinh = simpleDateFormat.parse(ngaySinh);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    client = new Client(nameClient,idCard,quocTich,locationClient,Integer.parseInt(sdt),Integer.parseInt(vip)
                            ,mNgaySinh,email);
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

