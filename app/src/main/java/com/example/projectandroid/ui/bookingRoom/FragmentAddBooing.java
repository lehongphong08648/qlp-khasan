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
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.ui.systemManager.FragmentAddRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentAddBooing extends AppCompatActivity {
    EditText edt_nameClient, edt_idClient, edt_locationClient, edt_sdt, edt_ngaySinh, edt_vip, edt_email;
    EditText edt_giaCb, edt_datCoc;
    EditText tv_ngayDen, tv_ngayDi;
    ImageView img_ngayDen, img_ngayDi;

    AppCompatSpinner sp_quocTich, sp_maPhong;

    Button btn_add_booking, btn_cancel_booking;

    List<String> listQuocTich;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_booing_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_nameClient = findViewById(R.id.edt_nameClient);
        edt_idClient = findViewById(R.id.edt_idCard);
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
        listQuocTich.add("Việt Nam");
        listQuocTich.add("Anh Quốc");
        listQuocTich.add("Mỹ");
        listQuocTich.add("Thái Lan");
        listQuocTich.add("Trung Quốc");
        listQuocTich.add("Nga");
        listQuocTich.add("Nhật Bản");
        listQuocTich.add("Hàn Quốc");
        listQuocTich.add("khác");
        ArrayAdapter<String> kindOfRoomArrayAdapter = new ArrayAdapter<>(FragmentAddBooing.this,android.R.layout.simple_spinner_item,listQuocTich);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_quocTich.setAdapter(kindOfRoomArrayAdapter);
        sp_quocTich.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

