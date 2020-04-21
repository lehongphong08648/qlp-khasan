package com.example.projectandroid.ui.checkInOut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterCleanRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.RoomRepo;

import java.util.ArrayList;
import java.util.List;

public class FragmentCleanRoom extends Fragment {
    GridView gv_cleanRoom;
    List<Rooms> rooms;
    RoomRepo roomRepo;
    AdapterCleanRoom adapterCleanRoom;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clean_room,container,false);

        gv_cleanRoom = view.findViewById(R.id.gv_cleanRoom);
        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(getContext());
        rooms = roomRepo.getAllBusyRoom();
        adapterCleanRoom = new AdapterCleanRoom(rooms);
        gv_cleanRoom.setAdapter(adapterCleanRoom);

        return view;
    }
}
