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
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.KorRepo;
import com.example.projectandroid.repository.RoomRepo;

public class FragmentAddKinOfRoom extends Fragment {

    EditText edt_maTlp, edt_tentlp, edt_gia2hDau,edt_gia1Nay,edt_gia1gioTiep,edt_moTa;
    Button btn_add_kindOfRoom, btn_cancel_kindOfRoom;

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_kind_of_room,container,false);

        edt_maTlp = view.findViewById(R.id.edt_maTlp);
        edt_tentlp = view.findViewById(R.id.edt_tenTlp);
        edt_gia2hDau = view.findViewById(R.id.edt_gia2hDau);
        edt_gia1Nay = view.findViewById(R.id.edt_gia1Ngay);
        edt_gia1gioTiep = view.findViewById(R.id.edt_gia1hTiep);
        edt_moTa = view.findViewById(R.id.edt_moTa);

        btn_add_kindOfRoom = view.findViewById(R.id.btn_add_kindOfRoom);
        btn_cancel_kindOfRoom = view.findViewById(R.id.btn_cancel_KindOfRom);

        //thêm thể loại phòng vào database
        btn_add_kindOfRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maTlp = edt_maTlp.getText().toString();
                String tenTlp = edt_tentlp.getText().toString();
                String gia2hDau = edt_gia2hDau.getText().toString();
                String gia1Ngay = edt_gia1Nay.getText().toString();
                String gia1gioTiep = edt_gia1gioTiep.getText().toString();
                String moTa = edt_moTa.getText().toString();

                if (!tenTlp.isEmpty() & !gia2hDau.isEmpty() & !gia1Ngay.isEmpty() & !gia1gioTiep.isEmpty() & !moTa.isEmpty()){
                    KorRepo korRepo = new KorRepo(getContext());
                    korRepo.insert(new KindOfRoom(tenTlp,Float.parseFloat(gia2hDau),Float.parseFloat(gia1gioTiep),Float.parseFloat(gia1Ngay),moTa));
                    Toast.makeText(getContext(),"Thêm thể loại phòng thành công",Toast.LENGTH_SHORT).show();

                    edt_maTlp.setText("");
                    edt_tentlp.setText("");
                    edt_gia2hDau.setText("");
                    edt_gia1Nay.setText("");
                    edt_gia1gioTiep.setText("");
                    edt_moTa.setText("");
                }



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
