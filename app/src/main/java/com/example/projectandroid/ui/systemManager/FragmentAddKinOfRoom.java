package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectandroid.R;

public class FragmentAddKinOfRoom extends Fragment {

    EditText edt_nameKindOfRoom, edt_describe;
    Button btn_add_kindOfRoom, btn_cancel_kindOfRoom;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_kind_of_room,container,false);

        edt_nameKindOfRoom = view.findViewById(R.id.edt_nameKindOfRoom);
        edt_describe = view.findViewById(R.id.edt_describe_kindOfRoom);
        btn_add_kindOfRoom = view.findViewById(R.id.btn_add_kindOfRoom);
        btn_cancel_kindOfRoom = view.findViewById(R.id.btn_cancel_KindOfRom);

        //thêm thể loại phòng vào database
        btn_add_kindOfRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameKindOfRoom = edt_nameKindOfRoom.getText().toString();
                String describeKindOfRoom = edt_describe.getText().toString();

                Toast.makeText(getContext(),nameKindOfRoom + " | " + describeKindOfRoom,Toast.LENGTH_SHORT).show();
            }
        });

        //hủy công việc thêm loại phòng trở về fragment loại phòng
        btn_cancel_kindOfRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentKindOfRoom());
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}
