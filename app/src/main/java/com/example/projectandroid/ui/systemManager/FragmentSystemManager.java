package com.example.projectandroid.ui.systemManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.ui.Login;

public class FragmentSystemManager extends Fragment {

    LinearLayout price, kindofroom, room, statistical, history, staff,client;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    TextView tv_userName, tv_userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system_manager,container,false);


        kindofroom = view.findViewById(R.id.kindofRoom);
        room = view.findViewById(R.id.room);
        statistical = view.findViewById(R.id.statistical);
        history = view.findViewById(R.id.history);
        staff = view.findViewById(R.id.user);
        client = view.findViewById(R.id.client);

        tv_userName = view.findViewById(R.id.tv_userName);
        tv_userId = view.findViewById(R.id.tv_userId);

        tv_userName.setText(Login.user.getFullName());
        tv_userId.setText(Login.user.getIdUser());



        kindofroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FragmentKindOfRoom.class));
            }
        });

        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FragmentRoom.class));
            }
        });

        statistical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FragmentStatistical.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FragmentHistory.class));
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),FragmentStaff.class));
            }
        });

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ClientActivity.class));
            }
        });


        return view;
    }

}
