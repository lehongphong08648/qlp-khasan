package com.example.projectandroid.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectandroid.R;

public class FragmentHome extends Fragment {

    TextView tv_home_hireOfDay, tv_home_waitingRoom, tv_home_rectectRoom, tv_home_cleanRoom;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tv_home_hireOfDay = view.findViewById(R.id.tv_home_hireForDay);
        tv_home_waitingRoom = view.findViewById(R.id.tv_home_waitingRoom);
        tv_home_rectectRoom = view.findViewById(R.id.tv_home_rentectRoom);
        tv_home_cleanRoom = view.findViewById(R.id.tv_home_cleanRoom);

        return view;
    }
}
