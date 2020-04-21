package com.example.projectandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.KorRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.checkInOut.CheckInOutActivity;
import com.example.projectandroid.ui.checkInOut.CheckOutActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterRentectRoom extends BaseAdapter {

    LayoutInflater mLayoutInflater;
    List<Booking> bookingList;
    Context context;
    List<Rooms> rooms;
    BookingRepo bookingRepo;
    RoomRepo roomRepo;
    ClientRepo clientRepo;
    List<Client> clients;

    KorRepo korRepo;
    List<KindOfRoom> kindOfRooms;


    public AdapterRentectRoom(Context context, List<Booking> bookingList) {
        this.context = context;
        this.bookingList = bookingList;
    }

    @Override
    public int getCount() {
        return bookingList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mLayoutInflater == null){
            mLayoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.row_item_rentect_room,null);
        }



        roomRepo = new RoomRepo(context);
        rooms = new ArrayList<>();
        bookingRepo = new BookingRepo(context);
        String idRoom = bookingList.get(position).getIdRoom();
        rooms = (List<Rooms>) roomRepo.getRoomById(idRoom);
        clients = new ArrayList<>();
        clientRepo = new ClientRepo(context);
        int idClient = bookingList.get(position).getIdClient();
        clients = (List<Client>) clientRepo.getClientById(idClient);
        korRepo = new KorRepo(context);
        kindOfRooms = new ArrayList<>();
        //todo làm cho e getID kindOfRoom nhé
//        kindOfRooms = korRepo.get



        TextView tv_ngayDen_Rentect = convertView.findViewById(R.id.tv_ngayDen_Rentect);
        TextView tv_tenPhongThue = convertView.findViewById(R.id.tv_tenPhong_rentect);
        TextView tvOptionDigitRentect = convertView.findViewById(R.id.tvOptionDigitRentect);
        TextView edt_nameClientRentect = convertView.findViewById(R.id.tv_nameClientRentect);
        TextView tv_tienCocRentect = convertView.findViewById(R.id.tv_tienCocRentect);
        TextView tv_timeRentect = convertView.findViewById(R.id.tv_timeRentect);
        TextView tv_tienPhaiTraRentect = convertView.findViewById(R.id.tv_tienPhaiTraRentect);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat getNgay = new SimpleDateFormat("dd");
        SimpleDateFormat getGio = new SimpleDateFormat("HH");
        SimpleDateFormat getThang = new SimpleDateFormat("MM");
        SimpleDateFormat getNam = new SimpleDateFormat("yy");
        Date dateNgayDen = bookingList.get(position).getDayCome();
        Date dateNgayDi = bookingList.get(position).getDayGo();
        int ngayDi = Integer.parseInt(getNgay.format(dateNgayDi));
        int thangDi = Integer.parseInt(getThang.format(dateNgayDi));
        int gioDi = Integer.parseInt(getGio.format(dateNgayDi));
        int namDi = Integer.parseInt(getNam.format(dateNgayDi));
        int mGioDi = (namDi*365) +(thangDi * 30) + (ngayDi * 24) + gioDi;

        int ngayDen = Integer.parseInt(getNgay.format(dateNgayDen));
        int thangDen = Integer.parseInt(getThang.format(dateNgayDen));
        int gioDen = Integer.parseInt(getGio.format(dateNgayDen));
        int namDen = Integer.parseInt(getNam.format(dateNgayDen));
        int mGioDen = (namDen*365) +(thangDen * 30) + (ngayDen * 24) + gioDen;

        int thoiGianThue = mGioDen - mGioDi;

        String mNgayDen = simpleDateFormat.format(dateNgayDen);

        tv_tienCocRentect.setText(String.valueOf(bookingList.get(position).getDeposit()));

        Float tienPhong ;

        tv_ngayDen_Rentect.setText(mNgayDen);
        tv_tenPhongThue.setText(rooms.get(position).getId());
        edt_nameClientRentect.setText(clients.get(position).getFullName());
        tv_timeRentect.setText(String.valueOf(thoiGianThue));
//        tv_tienPhaiTraRentect.setText(cũng thế);
        tvOptionDigitRentect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(parent.getContext(),tvOptionDigitRentect);
                popupMenu.inflate(R.menu.rentect_room);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.chinhSua:
                                Toast.makeText(parent.getContext(),"Chỉnh sửa",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.traPhong:
                                Intent intent = new Intent(context, CheckOutActivity.class);
                                Bundle bundle = new Bundle();

                                //to be khong tinh yeu :.

                                intent.putExtras(bundle);
                                context.startActivity(intent);
                                Toast.makeText(parent.getContext(),"Trả phòng",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.doiPhong:
                                Toast.makeText(parent.getContext(),"Đổi phòng",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.donVeSinh:
                                Toast.makeText(parent.getContext(),"Dọn vệ sinh",Toast.LENGTH_SHORT).show();
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

        // to be continued
        return convertView;
    }
}
