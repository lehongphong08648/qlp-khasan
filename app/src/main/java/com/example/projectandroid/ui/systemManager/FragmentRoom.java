package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class FragmentRoom extends Fragment {

    FloatingActionButton btn_frm_addRoom;
    RecyclerView lv_room;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    AdapterRoom adapterRoom;
    List<Rooms> rooms;
    RoomRepo roomRepo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room,container,false);

        lv_room = view.findViewById(R.id.lv_room);
        btn_frm_addRoom = view.findViewById(R.id.btn_frm_add_room);

        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(getContext());
        rooms = roomRepo.getAll();
        adapterRoom = new AdapterRoom(rooms);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        lv_room.setAdapter(adapterRoom);
        lv_room.setLayoutManager(layoutManager);

        btn_frm_addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentAddRoom());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
