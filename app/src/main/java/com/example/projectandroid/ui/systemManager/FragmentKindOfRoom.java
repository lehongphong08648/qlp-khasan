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

public class FragmentKindOfRoom extends Fragment {

    FloatingActionButton btn_frm_kindofroom;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    RecyclerView lv_kindOfRoom;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind_of_room,container,false);

        btn_frm_kindofroom = view.findViewById(R.id.btn_frm_kindOfRoom);
        lv_kindOfRoom = view.findViewById(R.id.lv_kindofroom);

        btn_frm_kindofroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentAddKinOfRoom());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
