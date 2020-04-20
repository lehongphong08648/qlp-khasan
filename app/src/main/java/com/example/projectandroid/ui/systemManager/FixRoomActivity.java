package com.example.projectandroid.ui.systemManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.dao.RoomDAO;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.KorRepo;
import com.example.projectandroid.repository.RoomRepo;

public class FixRoomActivity extends AppCompatActivity {
    EditText edt_fix_maPhong, edt_fix_tang, edt_fix_dvKhac, edt_fix_moTaPhong, edt_fix_idKor;
    Button btn_fix_room, btn_cancel_fix_room;

    Rooms rooms;
    RoomRepo roomRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_room);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        roomRepo = new RoomRepo(this);

        edt_fix_maPhong = findViewById(R.id.edt_fix_maPhong);
        edt_fix_idKor = findViewById(R.id.edt_fix_idKor);
        edt_fix_tang = findViewById(R.id.edt_fix_tang);
        edt_fix_dvKhac = findViewById(R.id.edt_fix_dvKhac);
        edt_fix_moTaPhong = findViewById(R.id.edt_fix_moTaPhong);

        btn_fix_room = findViewById(R.id.btn_fix_Room);
        btn_cancel_fix_room = findViewById(R.id.btn_cancel_fix_Room);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        edt_fix_maPhong.setText(bundle.getString("maPhong"));
        edt_fix_idKor.setText(bundle.getString("idKor"));
        edt_fix_tang.setText(bundle.getString("tang"));
        edt_fix_dvKhac.setText(bundle.getString("dvKhac"));
        edt_fix_moTaPhong.setText(bundle.getString("moTa"));


        btn_fix_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maPhong = edt_fix_maPhong.getText().toString();
                String idKor = edt_fix_maPhong.getText().toString();
                String tang = edt_fix_maPhong.getText().toString();
                String dvKhac = edt_fix_maPhong.getText().toString();
                String moTaPhong = edt_fix_maPhong.getText().toString();
                rooms = new Rooms(maPhong, Integer.parseInt(idKor), Integer.parseInt(tang), dvKhac, moTaPhong);


                Toast.makeText(FixRoomActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete) {
            roomRepo.delete(rooms);
            if (id == R.id.delete) {
                String maPhong = edt_fix_maPhong.getText().toString();
                String idKor = edt_fix_maPhong.getText().toString();
                String tang = edt_fix_maPhong.getText().toString();
                String dvKhac = edt_fix_maPhong.getText().toString();
                String moTaPhong = edt_fix_maPhong.getText().toString();

                roomRepo = new RoomRepo(FixRoomActivity.this);
                rooms = new Rooms(maPhong, Integer.parseInt(idKor), Integer.parseInt(tang), dvKhac, moTaPhong);
                roomRepo.delete(rooms);
                startActivity(new Intent(FixRoomActivity.this, FragmentRoom.class));
                Toast.makeText(FixRoomActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
            }

            return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}