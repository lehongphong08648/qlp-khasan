package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectandroid.R;

public class FragmentSystemManager extends Fragment {

    LinearLayout price, kindofroom, room, statistical, history, staff;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system_manager,container,false);



        price = view.findViewById(R.id.price);
        kindofroom = view.findViewById(R.id.kindofRoom);
        room = view.findViewById(R.id.room);
        statistical = view.findViewById(R.id.statistical);
        history = view.findViewById(R.id.history);
        staff = view.findViewById(R.id.staff);

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentPrice());
            }
        });

        kindofroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentKindOfRoom());
            }
        });

        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentRoom());
            }
        });

        statistical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentStatistical());
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentHistory());
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new FragmentStaff());
            }
        });


        return view;
    }

    public void getFragment(Fragment fragment){
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,fragment);
        fragmentTransaction.commit();
    }

}
