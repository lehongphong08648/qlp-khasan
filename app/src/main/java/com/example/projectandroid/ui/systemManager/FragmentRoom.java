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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.RoomRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentRoom extends AppCompatActivity {

    FloatingActionButton btn_frm_addRoom;
    RecyclerView lv_room;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    AdapterRoom adapterRoom;
    List<Rooms> rooms;
    RoomRepo roomRepo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_room);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv_room =findViewById(R.id.lv_room);
        btn_frm_addRoom = findViewById(R.id.btn_frm_add_room);

        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(FragmentRoom.this);
        rooms = roomRepo.getAll();
        adapterRoom = new AdapterRoom(rooms,FragmentRoom.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FragmentRoom.this);
        lv_room.setAdapter(adapterRoom);
        lv_room.setLayoutManager(layoutManager);


        btn_frm_addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(FragmentRoom.this,FragmentAddRoom.class));
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
        Dialog dialog = new Dialog(FragmentRoom.this);
        dialog.setTitle("Ghí chú");
        dialog.setContentView(R.layout.item_row_room);
        dialog.show();

    }
}
