package com.example.projectandroid.ui.checkInOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Invoice;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.InvoiceRepo;
import com.example.projectandroid.repository.RoomRepo;

public class CheckOutActivity extends AppCompatActivity {
EditText edt_tenKh_CheckOut, edt_idCard_checkOut, edt_quocTich_CheckOut, edt_ngaySinh_checkOut
        , edt_sdt_CheckOut, edt_location_checkOut, edt_vip_CheckOut, edt_email_checkOut
        , edt_tenPhong_checkOut, tv_ngayDen_checkOut, tv_ngayDen, edt_phiDv_checkOut
        , edt_tienCoc_checkOut, edt_tongTen_checkOut;

Button btn_checkOut, btn_cancel_checkOut;

Invoice invoice;
InvoiceRepo invoiceRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        edt_tenKh_CheckOut.setText(bundle.getString("hoTenKhacHang"));
        edt_idCard_checkOut.setText(bundle.getString("cmnn"));
        edt_quocTich_CheckOut.setText(bundle.getString("quocTich"));
        edt_ngaySinh_checkOut.setText(bundle.getString("ngaySinh"));
        edt_sdt_CheckOut.setText(bundle.getString("sdt"));
        edt_location_checkOut.setText(bundle.getString("diaChi"));
        edt_vip_CheckOut.setText(bundle.getString("vip"));
        edt_email_checkOut.setText(bundle.getString("email"));
        edt_tenPhong_checkOut.setText(bundle.getString("tenPhong"));
        tv_ngayDen_checkOut.setText(bundle.getString("ngayDen"));
        tv_ngayDen.setText(bundle.getString("ngayDi"));
        edt_tienCoc_checkOut.setText(bundle.getString("tienCoc"));

        Float Ftongtien = Float.parseFloat(bundle.getString("tongTien"));

        if (Ftongtien >= 0){
            edt_tongTen_checkOut.setText(String.valueOf(Ftongtien));
            edt_phiDv_checkOut.setText("0");
        }else {
            edt_phiDv_checkOut.setText(String.valueOf(Ftongtien));
            edt_tongTen_checkOut.setText("0");
        }


        btn_checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomRepo roomRepo = new RoomRepo(CheckOutActivity.this);
                Rooms rooms = roomRepo.getRoomById(bundle.getString("tenPhong"));
                rooms.setStatus("Busy");
                roomRepo.update(rooms);

                Float discount = (Ftongtien / 100) * 10;
                invoiceRepo = new InvoiceRepo(CheckOutActivity.this);
                invoice = new Invoice(bundle.getString("idBooking"),0,discount,Ftongtien);
                invoiceRepo.insert(invoice);
                Toast.makeText(CheckOutActivity.this,"Trả phòng thành công",Toast.LENGTH_SHORT).show();
            }
        });
btn_cancel_checkOut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(CheckOutActivity.this,CheckInOutActivity.class));
    }
});
    }
    public void init(){
        edt_tenKh_CheckOut = findViewById(R.id.edt_tenKh_CheckOut);
        edt_idCard_checkOut = findViewById(R.id.edt_idCard_checkOut);
        edt_quocTich_CheckOut = findViewById(R.id.edt_quocTich_CheckOut);
        edt_ngaySinh_checkOut = findViewById(R.id.edt_ngaySinh_checkOut);
        edt_sdt_CheckOut = findViewById(R.id.edt_sdt_CheckOut);
        edt_location_checkOut = findViewById(R.id.edt_location_checkOut);
        edt_vip_CheckOut = findViewById(R.id.edt_vip_CheckOut);
        edt_email_checkOut = findViewById(R.id.edt_email_checkOut);
        edt_tenPhong_checkOut = findViewById(R.id.edt_tenPhong_checkOut);
        tv_ngayDen_checkOut = findViewById(R.id.tv_ngayDen_checkOut);
        tv_ngayDen = findViewById(R.id.tv_ngayDen);
        edt_phiDv_checkOut = findViewById(R.id.edt_phiDv_checkOut);
        edt_tienCoc_checkOut = findViewById(R.id.edt_tienCoc_checkOut);
        edt_tongTen_checkOut = findViewById(R.id.edt_tongTen_checkOut);

        btn_checkOut = findViewById(R.id.btn_checkOut);
        btn_cancel_checkOut = findViewById(R.id.btn_cancel_checkOut);
    }
}
