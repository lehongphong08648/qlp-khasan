package com.example.projectandroid.adapter;

import android.content.Context;
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

import java.util.List;

public class AdapterRentectRoom extends BaseAdapter {

    LayoutInflater mLayoutInflater;
    List<String> nameClient;
    List<Booking> bookingList;
    Context context;

    public AdapterRentectRoom(Context context,List<String> nameClient, List<Booking> bookingList) {
        this.nameClient = nameClient;
        this.bookingList = bookingList;
        this.context = context;
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

        TextView tv_tenPhongThue = convertView.findViewById(R.id.tv_tenPhong_rentect);
        TextView tvOptionDigitRentect = convertView.findViewById(R.id.tvOptionDigitRentect);
        TextView edt_nameClientRentect = convertView.findViewById(R.id.tv_nameClientRentect);
        TextView tv_tienCocRentect = convertView.findViewById(R.id.tv_tienCocRentect);
        TextView tv_timeRentect = convertView.findViewById(R.id.tv_timeRentect);
        TextView tv_tienPhaiTraRentect = convertView.findViewById(R.id.tv_tienPhaiTraRentect);

        tv_tenPhongThue.setText(bookingList.get(position).getRoom().getId());
        edt_nameClientRentect.setText(nameClient.get(position));
        tv_tienCocRentect.setText(String.valueOf(bookingList.get(position).getDeposit()));
//        tv_timeRentect.setText(chưa biết làm);
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
                                Toast.makeText(parent.getContext(),"Chỉnh sửa",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.doiPhong:
                                Toast.makeText(parent.getContext(),"Chỉnh sửa",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.donVeSinh:
                                Toast.makeText(parent.getContext(),"Chỉnh sửa",Toast.LENGTH_SHORT).show();
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
