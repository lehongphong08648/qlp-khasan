package com.example.projectandroid.ui.systemManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterLoaiPhong;
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.repository.KorRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentKindOfRoom extends AppCompatActivity {

    FloatingActionButton btn_frm_kindofroom;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    RecyclerView lv_kindOfRoom;
    AdapterLoaiPhong adapterLoaiPhong;
    List<KindOfRoom> kindOfRooms;
    KorRepo korRepo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_kind_of_room);

        btn_frm_kindofroom = findViewById(R.id.btn_frm_kindOfRoom);
        lv_kindOfRoom = findViewById(R.id.lv_kindofroom);
        KindOfRoom kindOfRoom = new KindOfRoom("phong",123,456,789,"sieu sang");
        kindOfRooms = new ArrayList<>();
        korRepo = new KorRepo(this);
        kindOfRooms = korRepo.getAll();
        adapterLoaiPhong = new AdapterLoaiPhong(this,kindOfRooms);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        lv_kindOfRoom.setAdapter(adapterLoaiPhong);
        lv_kindOfRoom.setLayoutManager(mLayoutManager);

        btn_frm_kindofroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentKindOfRoom.this,FragmentAddKinOfRoom.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.note){
            getDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void getDialog(){
        Dialog dialog = new Dialog(FragmentKindOfRoom.this);
        dialog.setTitle("Ghí chú");
        dialog.setContentView(R.layout.item_row_loai_phong);
        dialog.show();

    }
}
