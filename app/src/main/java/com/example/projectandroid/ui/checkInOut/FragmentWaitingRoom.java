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
import com.example.projectandroid.adapter.AdapterWaitingRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.RoomRepo;

import java.util.ArrayList;
import java.util.List;

public class FragmentWaitingRoom extends Fragment {

    GridView gv_waitingRoom;
    RoomRepo roomRepo;
    List<Rooms> rooms;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waiting_room,container,false);

        gv_waitingRoom = view.findViewById(R.id.gv_waitingRoom);
        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(getContext());
        rooms = roomRepo.getAllBookingRoom();
        AdapterWaitingRoom adapterWaitingRoom = new AdapterWaitingRoom(getContext(),rooms);
        gv_waitingRoom.setAdapter(adapterWaitingRoom);
        return view;
    }
}
