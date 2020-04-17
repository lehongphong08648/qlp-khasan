package com.example.projectandroid.ui.bookingRoom;

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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.projectandroid.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentAddBooing extends Fragment {
    EditText edt_nameClient, edt_idClient, edt_locationClient, edt_sdt, edt_ngaySinh, edt_vip, edt_email;
    EditText edt_giaCb, edt_datCoc;
    TextView tv_ngayDen, tv_ngayDi;
    ImageView img_ngayDen, img_ngayDi;

    AppCompatSpinner sp_quocTich, sp_maPhong, sp_maND, sp_thangThaiPhong;

    Button btn_add_booking, btn_cancel_booking;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_booing_fragment, container, false);


        edt_nameClient = view.findViewById(R.id.edt_nameClient);
        edt_idClient = view.findViewById(R.id.edt_idCard);
        edt_locationClient = view.findViewById(R.id.edt_location);
        edt_sdt = view.findViewById(R.id.edt_sdt);
        edt_ngaySinh = view.findViewById(R.id.edt_ngaySinh);
        edt_vip = view.findViewById(R.id.edt_vip);
        edt_email = view.findViewById(R.id.edt_email);
        tv_ngayDen = view.findViewById(R.id.tv_ngayDen);
        tv_ngayDi = view.findViewById(R.id.tv_ngayDi);
        edt_giaCb = view.findViewById(R.id.edt_giaCB);
        edt_datCoc = view.findViewById(R.id.edt_datCoc);


        img_ngayDen = view.findViewById(R.id.img_ngayDen);
        img_ngayDi = view.findViewById(R.id.img_ngayDi);

        edt_ngaySinh.setInputType(InputType.TYPE_NULL);

        sp_quocTich = view.findViewById(R.id.sp_quocTich);
        sp_maPhong = view.findViewById(R.id.sp_maPhong);
        sp_maND = view.findViewById(R.id.sp_maND);
        sp_thangThaiPhong = view.findViewById(R.id.sp_trangThaiPhong);

        btn_add_booking = view.findViewById(R.id.btn_booking);
        btn_cancel_booking = view.findViewById(R.id.btn_cancel_booking);

        mCreateEvent();
        return view;
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
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm");
                        tv_dateTime.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(getContext(),onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(getContext(),onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

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

        new DatePickerDialog(getContext(),onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}
