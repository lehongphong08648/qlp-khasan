package com.example.projectandroid.ui.bookingRoom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.ui.systemManager.FragmentRoom;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentBookingRoom extends Fragment {

    FloatingActionButton btn_frm_add_booking;
    RecyclerView lv_booking;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_rom,container,false);


        btn_frm_add_booking = view.findViewById(R.id.btn_frm_add_booking);
        btn_frm_add_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentAddBooing());
                fragmentTransaction.commit();
            }
        });

        lv_booking = view.findViewById(R.id.lv_bookingRoom);

        return view;
    }

}
