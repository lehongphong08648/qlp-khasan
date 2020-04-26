package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.BookingStatus;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.BookingStatusRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.checkInOut.CheckInActivity;

import java.util.List;

public class AdapterCleanRoom extends BaseAdapter {


    //BAse adapter nó notify kiểu khác
    //e lên mạng search xem
    //
    LayoutInflater layoutInflater;
    List<Rooms> rooms;
    RoomRepo roomRepo;
    Rooms roomsModel;

    public AdapterCleanRoom(List<Rooms> rooms) {
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
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_item_clean_room, null);

        }

        TextView tv_tenPhong_clean = convertView.findViewById(R.id.tvtenPhongclean);
        TextView tvOptionDigitClean = convertView.findViewById(R.id.tvOptionDigitClean);
        TextView tv_tinhTrangPhong = convertView.findViewById(R.id.tv_tinhTrangPhong);

        tv_tenPhong_clean.setText(rooms.get(position).getId());
        tv_tinhTrangPhong.setText("cần dọn dẹp");


        tvOptionDigitClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(parent.getContext(), tvOptionDigitClean);
                popupMenu.inflate(R.menu.clean_room);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.donDep) {
                            roomRepo = new RoomRepo(parent.getContext());
                            BookingStatusRepo statusRepo = new BookingStatusRepo(parent.getContext());
                            int idbooking = statusRepo.getIdBookingStatusByIdRoomBusy(rooms.get(position).getId());

                            BookingRepo bookingRepo = new BookingRepo(parent.getContext());
                            Booking booking = bookingRepo.getBookingByIdRoom(rooms.get(position).getId(), "Busy");

                            //vcl
                            //dm e viết thiếu chữ f
                            BookingStatus bookingStatus = new BookingStatus(booking.getIdBooking(), "Offline");//ofline e viết thiếu chữ f
//chạy lại đi               ook anh được rồi, nhưng có làm cách nào cho nó mất luôn được không !!
                            //đâu tiên là
                            //đm e
                            //viết cũng thiếu
                            //a ạ m
                            //mất luôn thì notify

                            bookingStatus.setId(statusRepo.getBookingStatusById(idbooking).getId());//đây này

                            BookingStatusRepo bookingStatusRepo = new BookingStatusRepo(parent.getContext());
                            bookingStatusRepo.update(bookingStatus);
                            //đấy anh nhưng nó không được nhỉ
                            notifyDataSetChanged();
                            Toast.makeText(parent.getContext(), "Ok e! đã dọn dẹp", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }

        });

        return convertView;
    }
}
