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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentRentectRoom extends Fragment {

    GridView gv_rentectRoom;
    AdapterRentectRoom adapterRentectRoom;
    Date date;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rectect_room,container,false);
        String s = "24-10-2000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
             date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        gv_rentectRoom.setAdapter(adapterRentectRoom);
        return view;
    }
}
