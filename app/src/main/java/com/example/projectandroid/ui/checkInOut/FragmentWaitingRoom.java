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

public class FragmentWaitingRoom extends Fragment {

    GridView gv_waitingRoom;
    String[] numberWork = {"one","two","three","four","five","six","seven","eight","night","ten"};
    int [] img={R.drawable.money,R.drawable.money,R.drawable.money,R.drawable.money,R.drawable.money,
            R.drawable.money,R.drawable.money,R.drawable.money,R.drawable.money,R.drawable.money};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waiting_room,container,false);

        gv_waitingRoom = view.findViewById(R.id.gv_waitingRoom);
        AdapterWaitingRoom adapterWaitingRoom = new AdapterWaitingRoom(getContext(),numberWork,img);
        gv_waitingRoom.setAdapter(adapterWaitingRoom);
        return view;
    }
}
