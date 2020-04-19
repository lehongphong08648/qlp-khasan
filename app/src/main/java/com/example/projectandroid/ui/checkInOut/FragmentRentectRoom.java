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
        Client client = new Client("le hong phong","122377709","Vietnames","dao luoi",03,1,date,"idtmnam@gmail.com");
        User user = new User("phmg123","123","le hong phong");
        KindOfRoom kindOfRoom = new KindOfRoom("phonghihi",200,70,500,"sieu me");
        Rooms room = new Rooms("123","massage",1,"ffff","ertyui");
        Booking booking = new Booking("uio123","zxc456","890bnm","jkl567",date,date,741,"hihi");
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        List<String> list = new ArrayList<>();
        list.add("anh phong hello may cung");

        gv_rentectRoom = view.findViewById(R.id.gv_rentectRoom);
        adapterRentectRoom = new AdapterRentectRoom(getContext(),list,bookings);
        gv_rentectRoom.setAdapter(adapterRentectRoom);
        return view;
    }
}
