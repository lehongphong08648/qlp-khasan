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
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentRoom extends Fragment {

    FloatingActionButton btn_frm_addRoom;
    RecyclerView lv_room;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room,container,false);

        lv_room = view.findViewById(R.id.lv_room);
        btn_frm_addRoom = view.findViewById(R.id.btn_frm_add_room);

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
