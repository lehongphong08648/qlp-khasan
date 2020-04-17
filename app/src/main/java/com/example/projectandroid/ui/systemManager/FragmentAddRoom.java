package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.projectandroid.R;

public class FragmentAddRoom extends Fragment {
EditText edt_maPhong, edt_tang, edt_dvKhac, edt_moTaPhong;
AppCompatSpinner sp_maTlp;
Button btn_add_room, btn_cancel_room;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_add_room, container, false);

        edt_maPhong = view.findViewById(R.id.edt_maPhong);
        edt_tang = view.findViewById(R.id.edt_tang);
        edt_dvKhac = view.findViewById(R.id.edt_dvKhac);
        edt_moTaPhong = view.findViewById(R.id.edt_moTaPhong);

        sp_maTlp = view.findViewById(R.id.spMaTlp);

      btn_add_room = view.findViewById(R.id.btn_add_Room);
      btn_cancel_room = view.findViewById(R.id.btn_cancel_Room);


        btn_cancel_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentRoom());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
