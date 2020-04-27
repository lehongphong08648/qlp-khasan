package com.example.projectandroid.ui.systemManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.UserRepo;

public class FixInvoicesActivity extends AppCompatActivity {
EditText edt_tenPhong_ivoi, edt_tenKh_ivoi, edt_tenND_ivoi, edt_ngayDen_ivoi, edt_ngayDi_ivoi, edt_tienCoc_ivoi, edt_discount_ivoi, edt_total_ivoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_invoices);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
         String tenPhong = bundle.getString("idRoom");
        String idClient = bundle.getString("idClient");
        String idUser = bundle.getString("idUser");
        String ngayDen = bundle.getString("ngayDen");
        String ngayDi = bundle.getString("ngayDi");
        String tienCoc = bundle.getString("tienCoc");
        String disCount = bundle.getString("disCount");
        String tolTal = bundle.getString("tolTal");

        ClientRepo clientRepo = new ClientRepo(this);
        UserRepo userRepo = new UserRepo(this);
        Client client = clientRepo.getClientById(Integer.parseInt(idClient));
        String tenKh = client.getFullName();
        User user = userRepo.getUserByUserName(idUser);
        String tenND = user.getFullName();

        edt_tenPhong_ivoi.setText(tenPhong);
        edt_tenKh_ivoi.setText(tenKh);
        edt_tenND_ivoi.setText(tenND);
        edt_ngayDen_ivoi.setText(ngayDen);
        edt_ngayDi_ivoi.setText(ngayDi);
        edt_tienCoc_ivoi.setText(tienCoc);
        edt_discount_ivoi.setText(disCount);
        edt_total_ivoi.setText(tolTal);
    }
    public void init(){
        edt_tenPhong_ivoi = findViewById(R.id.edt_tenPhong_ivoi);
        edt_tenKh_ivoi = findViewById(R.id.edt_tenKh_ivoi);
        edt_tenND_ivoi = findViewById(R.id.edt_tenND_ivoi);
        edt_ngayDen_ivoi = findViewById(R.id.edt_ngayDen_ivoi);
        edt_ngayDi_ivoi = findViewById(R.id.edt_ngayDi_ivoi);
        edt_tienCoc_ivoi = findViewById(R.id.edt_tienCoc_ivoi);
        edt_discount_ivoi = findViewById(R.id.edt_discount_ivoi);
        edt_total_ivoi = findViewById(R.id.edt_total_ivoi);
    }
}
