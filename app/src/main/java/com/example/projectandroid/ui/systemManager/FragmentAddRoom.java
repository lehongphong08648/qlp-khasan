package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterBooking;
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.KorRepo;
import com.example.projectandroid.repository.RoomRepo;

import java.util.ArrayList;
import java.util.List;

public class FragmentAddRoom extends Fragment {
EditText edt_maPhong, edt_tang, edt_dvKhac, edt_moTaPhong;
AppCompatSpinner sp_maTlp;
Button btn_add_room, btn_cancel_room;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Rooms rooms;
    RoomRepo roomRepo;
    List<KindOfRoom> kindOfRooms;
    KorRepo korRepo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_add_room, container, false);

        edt_maPhong = view.findViewById(R.id.edt_maPhong);
        edt_tang = view.findViewById(R.id.edt_tang);
        edt_dvKhac = view.findViewById(R.id.edt_dvKhac);
        edt_moTaPhong = view.findViewById(R.id.edt_moTaPhong);

      btn_add_room = view.findViewById(R.id.btn_add_Room);
      btn_cancel_room = view.findViewById(R.id.btn_cancel_Room);

        sp_maTlp = view.findViewById(R.id.spMaTlp);
        kindOfRooms = new ArrayList<>();
        korRepo = new KorRepo(getContext());
        kindOfRooms = korRepo.getAll();
        ArrayAdapter<KindOfRoom> kindOfRoomArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,kindOfRooms);
        kindOfRoomArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_maTlp.setAdapter(kindOfRoomArrayAdapter);

        sp_maTlp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                KindOfRoom kindOfRoom = (KindOfRoom) parent.getSelectedItem();
                dislayKindOfRoomData(kindOfRoom);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      btn_add_room.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String maPhong = edt_maPhong.getText().toString();
              String tang = edt_tang.getText().toString();
              String dvKhach = edt_dvKhac.getText().toString();
              String moTa = edt_moTaPhong.getText().toString();
              roomRepo = new RoomRepo(getContext());
              if (maPhong.isEmpty()){
                  edt_maPhong.setError("Vui lòng nhập mã phòng");
              }
              else if (moTa.isEmpty()){
                  edt_maPhong.setError("Vui lòng nhập mô tả");
              }
              else if (tang.isEmpty()){
                  edt_maPhong.setError("Vui lòng nhập tầng");
              }
              else {
                  KindOfRoom kindOfRoom = (KindOfRoom) sp_maTlp.getSelectedItem();
                  int idKindOfRoom = kindOfRoom.getId();
                  rooms = new Rooms(maPhong,String.valueOf(idKindOfRoom),Integer.parseInt(tang),dvKhach,moTa);
                  roomRepo.insert(rooms);
                  Toast.makeText(getContext(),"Thêm phòng thành công",Toast.LENGTH_SHORT).show();

                  edt_maPhong.setText("");
                  edt_tang.setText("");
                  edt_dvKhac.setText("");
                  edt_moTaPhong.setText("");
              }
          }
      });


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

    private void dislayKindOfRoomData(KindOfRoom kindOfRoom){
        String name = kindOfRoom.getName();
        int id = kindOfRoom.getId();
        String Ddscribe = kindOfRoom.getDescribe();
        float price2HourFirt = kindOfRoom.getPriceTwoHourFirst();
        float price1Hour = kindOfRoom.getPriceOneHour();
        float price1Day = kindOfRoom.getPriceOneDay();
    }

}
