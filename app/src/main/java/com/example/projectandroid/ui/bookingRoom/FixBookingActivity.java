package com.example.projectandroid.ui.bookingRoom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.BookingStatus;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.BookingStatusRepo;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.Login;
import com.example.projectandroid.ui.checkInOut.CheckInOutActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FixBookingActivity extends AppCompatActivity {
AppCompatSpinner sp_nameClient_booking, sp_nameRoom_booking;
EditText edt_dayCome, edt_dayGO, edt_tienCoc_fixBooking;
Button btn_chinhSua, btn_fix;

List<Rooms> rooms;
RoomRepo roomRepo;
List<Client> clients;
ClientRepo clientRepo;

private Client client;
private Rooms mRooms;

private Date mNgayDen;
private Date mNgayDi;

 private String datCoc,ngayDen,ngayDi, idRoom, idUser;
    int idBooking, idClien;
private ImageView img_ngayDen,img_ngayDi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_booking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sp_nameClient_booking = findViewById(R.id.sp_fix_client_booking);
        sp_nameRoom_booking = findViewById(R.id.sp_maPhong_booking);
        edt_dayCome = findViewById(R.id.tv_ngayDen_booking);
        edt_dayGO = findViewById(R.id.tv_ngayDi_fixBooing);
        edt_tienCoc_fixBooking = findViewById(R.id.edt_datCoc_fixbooking);
        btn_chinhSua = findViewById(R.id.btn_fix_booking);
        img_ngayDen = findViewById(R.id.img_ngayDen_fixBooking);
        img_ngayDi = findViewById(R.id.img_ngayDi_fixBooking);
        btn_fix = findViewById(R.id.btn_fix_fix);

        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(FixBookingActivity.this);
        rooms = roomRepo.getAll();
        ArrayAdapter<Rooms> roomsArrayAdapter = new ArrayAdapter<>(FixBookingActivity.this,android.R.layout.simple_spinner_item,rooms);
        roomsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_nameRoom_booking.setAdapter(roomsArrayAdapter);

        //đổ khách hàng ra sp
        clients = new ArrayList<>();
        clientRepo = new ClientRepo(this);
        clients = clientRepo.getAll();
        ArrayAdapter<Client> clientArrayAdapter = new ArrayAdapter<>(FixBookingActivity.this,android.R.layout.simple_spinner_item,clients);
        roomsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_nameClient_booking.setAdapter(clientArrayAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idBooking = Integer.parseInt(bundle.getString("idBooking"));
        edt_dayCome.setText(bundle.getString("dayCome"));
        edt_dayGO.setText(bundle.getString("dayGo"));
        edt_tienCoc_fixBooking.setText(bundle.getString("tienCoc"));


        btn_chinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRooms = (Rooms) sp_nameRoom_booking.getSelectedItem();
                String maPhong = mRooms.getId();
                client = (Client) sp_nameClient_booking.getSelectedItem();
                int idKhachHang = client.getId();

                ngayDen = edt_dayCome.getText().toString();
                ngayDi = edt_dayGO.getText().toString();
                datCoc = edt_tienCoc_fixBooking.getText().toString();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");


                if (ngayDen.isEmpty()){
                    edt_dayCome.setError("Vui lòng nhập tên khách hàng");
                }if (ngayDi.isEmpty()){
                    edt_dayGO.setError("Vui lòng nhập tên khách hàng");
                }if (datCoc.isEmpty()){
                    edt_tienCoc_fixBooking.setError("Vui lòng nhập tên khách hàng");
                }
                else {
                    try {
                        mNgayDen =simpleDateFormat.parse(ngayDen);
                        mNgayDi = simpleDateFormat.parse(ngayDi);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Booking booking =new Booking(idBooking,maPhong,idKhachHang, Login.user.getIdUser(),mNgayDen,mNgayDi,Float.parseFloat(datCoc));
                    BookingRepo bookingRepo = new BookingRepo(FixBookingActivity.this);
                    bookingRepo.update(booking);
                    edt_dayCome.setText("");
                    edt_dayGO.setText("");
                    edt_tienCoc_fixBooking.setText("");
                }
            }
        });

        btn_fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookingStatusRepo statusRepo = new BookingStatusRepo(FixBookingActivity.this);
                BookingStatus bookingStatus =statusRepo.getBookingStatusById(idBooking);
                bookingStatus.setStatus("Online");
                statusRepo.update(bookingStatus);
                startActivity(new Intent(FixBookingActivity.this, CheckInOutActivity.class));
            }
        });

        img_ngayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(edt_dayGO);
            }
        });
        img_ngayDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(edt_dayCome);
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
                new TimePickerDialog(FixBookingActivity.this,onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(FixBookingActivity.this,onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

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
            BookingStatusRepo statusRepo = new BookingStatusRepo(FixBookingActivity.this);
            BookingRepo bookingRepo = new BookingRepo(FixBookingActivity.this);

//            BookingStatus bookingStatus = statusRepo.getBookingStatusById(idBooking);
//            statusRepo.delete(bookingStatus);


            Booking bookingdelete = bookingRepo.getBookingById(idBooking);
            bookingRepo.delete(bookingdelete);
            startActivity(new Intent(FixBookingActivity.this,FragmentBookingRoom.class));
        }
        return super.onOptionsItemSelected(item);
    }
}