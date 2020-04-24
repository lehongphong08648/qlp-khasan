package com.example.projectandroid.ui.checkInOut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterRentectRoom;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.RoomRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentRentectRoom extends Fragment {

    GridView gv_rentectRoom;
    AdapterRentectRoom adapterRentectRoom;
    List<Rooms> rooms;
    RoomRepo roomRepo;
    List<Booking> bookingList;
    BookingRepo bookingRepo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rectect_room,container,false);

        rooms = new ArrayList<>();
        roomRepo = new RoomRepo(getContext());
        rooms = roomRepo.getAllOnlineRoom();

        bookingList = new ArrayList<>();
        bookingRepo = new BookingRepo(getContext());
        bookingList = bookingRepo.getAll();

        adapterRentectRoom = new AdapterRentectRoom(getContext(),bookingList);
        gv_rentectRoom = view.findViewById(R.id.gv_rentectRoom);
        gv_rentectRoom.setAdapter(adapterRentectRoom);
        return view;
    }
}
