package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.projectandroid.R;
import com.example.projectandroid.repository.InvoiceRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentStatistical extends AppCompatActivity {
InvoiceRepo invoiceRepo;
TextView tv_doanhSoNGay, tv_doanhSoThang,tv_doanhSoNam;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_statistical);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        invoiceRepo = new InvoiceRepo(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat getDay = new SimpleDateFormat("dd");
        SimpleDateFormat getThang = new SimpleDateFormat("MM");
        SimpleDateFormat getNam = new SimpleDateFormat("yyyy");

        String ngay = getDay.format(calendar.getTime());
        String thang = getThang.format(calendar.getTime());
        String nam = getNam.format(calendar.getTime());

        tv_doanhSoNGay = findViewById(R.id.tv_doanhSoNgay);
        tv_doanhSoThang = findViewById(R.id.tv_doanhSoThang);
        tv_doanhSoNam = findViewById(R.id.tv_doangSoNam);

int ngayI = Integer.parseInt(ngay);
        float doanhSoNgay = invoiceRepo.getInvoiceToday(calendar);
        float doanhSoThang = invoiceRepo.getInvoiceByMonth(Integer.parseInt(thang));
        float doanhSoNam = invoiceRepo.getInvoiceByYear(Integer.parseInt(nam));

        tv_doanhSoNGay.setText(String.valueOf(doanhSoNgay));
        tv_doanhSoThang.setText(String.valueOf(doanhSoThang));
        tv_doanhSoNam.setText(String.valueOf(doanhSoNam));
}
}
