package com.example.projectandroid.ui.systemManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.repository.KorRepo;

public class FixKindOfRoomActivity extends AppCompatActivity {
    EditText edt_fix_maTlp, edt_fix_tentlp, edt_fix_gia2hDau,edt_fix_gia1Nay,edt_fix_gia1gioTiep,edt_fix_moTa;
    Button btn_fix_kindOfRoom, btn_cancel_fix_kindOfRoom;

    KorRepo korRepo;
    KindOfRoom kindOfRoom;

    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_kind_of_room);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_fix_maTlp = findViewById(R.id.edt_fix_maTlp);
        edt_fix_tentlp = findViewById(R.id.edt_fix_tenTlp);
        edt_fix_gia2hDau = findViewById(R.id.edt_fix_gia2hDau);
        edt_fix_gia1Nay = findViewById(R.id.edt_fix_gia1Ngay);
        edt_fix_gia1gioTiep = findViewById(R.id.edt_fix_gia1hTiep);
        edt_fix_moTa = findViewById(R.id.edt_fix_moTa);

        btn_fix_kindOfRoom = findViewById(R.id.btn_fix_kindOfRoom);
        btn_cancel_fix_kindOfRoom = findViewById(R.id.btn_cancel_fix_KindOfRom);

         intent = getIntent();
         bundle = intent.getExtras();
        edt_fix_maTlp.setText(bundle.getString("maTheLoaiPhong"));
        edt_fix_tentlp.setText(bundle.getString("tenTheLoaiPhong"));
        edt_fix_gia2hDau.setText(bundle.getString("gia2hDau"));
        edt_fix_gia1Nay.setText(bundle.getString("gia1Ngay"));
        edt_fix_gia1gioTiep.setText(bundle.getString("gia1hTiep"));
        edt_fix_moTa.setText(bundle.getString("moTa"));

        btn_fix_kindOfRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maTheLoaiPhong = bundle.getString("maTheLoaiPhong");
                String tenTheLoaiPhong = edt_fix_tentlp.getText().toString();
                String gia2hDau = edt_fix_gia2hDau.getText().toString();
                String gia1Ngay = edt_fix_gia1Nay.getText().toString();
                String gia1hTiep = edt_fix_gia1gioTiep.getText().toString();
                String moTa = edt_fix_moTa.getText().toString();
                if (tenTheLoaiPhong.isEmpty()){
                    edt_fix_tentlp.setError("Vui lòng nhập tên loại phòng");
                }
                else if (gia2hDau.isEmpty()){
                    edt_fix_gia2hDau.setError("Vui lòng nhập giá 2 giờ đầu");
                }
                else if (gia1Ngay.isEmpty()){
                    edt_fix_gia1Nay.setError("Vui lòng nhập giá 1 ngày");
                }
                else if (gia1hTiep.isEmpty()){
                    edt_fix_gia1gioTiep.setError("Vui lòng nhập giá 1 giờ tiếp");
                }else if (moTa.isEmpty()){
                    edt_fix_moTa.setError("Vui lòng nhập mô tả");
                }else {
                    korRepo = new KorRepo(FixKindOfRoomActivity.this);
                    kindOfRoom = new KindOfRoom(tenTheLoaiPhong,Float.parseFloat(gia2hDau),Float.parseFloat(gia1Ngay)
                            ,Float.parseFloat(gia1hTiep),moTa);
                    kindOfRoom.setId(Integer.parseInt(maTheLoaiPhong));
                    korRepo.update(kindOfRoom);
                    Toast.makeText(FixKindOfRoomActivity.this,"Chỉnh sửa thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
         btn_cancel_fix_kindOfRoom.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(FixKindOfRoomActivity.this,FragmentKindOfRoom.class));
             }
         });
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
            korRepo = new KorRepo(FixKindOfRoomActivity.this);
            String maTheLoaiPhong = bundle.getString("maTheLoaiPhong");
            String tenTheLoaiPhong = edt_fix_tentlp.getText().toString();
            String gia2hDau = edt_fix_gia2hDau.getText().toString();
            String gia1Ngay = edt_fix_gia1Nay.getText().toString();
            String gia1hTiep = edt_fix_gia1gioTiep.getText().toString();
            String moTa = edt_fix_moTa.getText().toString();

            kindOfRoom = new KindOfRoom(tenTheLoaiPhong,Float.parseFloat(gia2hDau),Float.parseFloat(gia1hTiep),Float.parseFloat(gia1Ngay),moTa);
            kindOfRoom.setId(Integer.parseInt(maTheLoaiPhong));
            korRepo.delete(kindOfRoom);
            startActivity(new Intent(FixKindOfRoomActivity.this,FragmentKindOfRoom.class));
            Toast.makeText(FixKindOfRoomActivity.this,"Đã xóa",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
