package com.example.projectandroid.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.ui.checkInOut.CheckInActivity;
import com.example.projectandroid.ui.checkInOut.CheckInOutActivity;
import com.example.projectandroid.ui.systemManager.FragmentKindOfRoom;

import java.util.List;


public class AdapterWaitingRoom extends BaseAdapter{


    Context context;
    LayoutInflater layoutInflater;
    List<Rooms> rooms;

    public AdapterWaitingRoom(Context context, List<Rooms> rooms) {
        this.context = context;
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.row_item_waiting_room,null);
        }


        final ImageView img = convertView.findViewById(R.id.img_status_waitingRoom);
        TextView tv = convertView.findViewById(R.id.tv_status_waitingRoom);
        TextView tvTenPhong_phongCho = convertView.findViewById(R.id.tv_tenPhong_phongCho);

        tvTenPhong_phongCho.setText(rooms.get(position).getId());

        /*Chỗ này để có thể click nhận phòng,  rọn phòng cho phòng chờ
        * giống như option menu trên toolbar
        * */
        final TextView tvOptionDigit = convertView.findViewById(R.id.tvOptionDigit);

        tvOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,tvOptionDigit);
                popupMenu.inflate(R.menu.waiting_room);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.checkIn_waitingRoom:
                                //chuyển trạng thái phòng từ phòng chờ nhận phòng
                                Toast.makeText(context,"nhận phòng",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context,CheckInActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("idKor",String.valueOf(rooms.get(position).getIdKOR()));
                                bundle.putString("Id",rooms.get(position).getId());
                                bundle.putString("Floor",String.valueOf(rooms.get(position).getFloor()));
                                bundle.putString("Service",rooms.get(position).getService());
                                bundle.putString("Describe",rooms.get(position).getDescribe());
                                intent.putExtras(bundle);
                        context.startActivity(intent);

                                break;
                            case R.id.clean_waitingRoom:
                                //dọn phòng khi trả phòng
                                Toast.makeText(context,"rọn phòng",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;

                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        //nếu như mà phòng được trả mà chưa dọn dẹp thì sẽ hiển thị ở cả phần clean room mà waiting room
        //nhưng sẽ hiển tị là " Not cleaned yet " còn nếu rọn rẹp rồi thì tv sẽ chuyển thành " Tidied up "

        return convertView;
    }
}
