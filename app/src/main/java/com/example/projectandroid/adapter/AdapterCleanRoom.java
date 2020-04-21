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

public class AdapterCleanRoom extends BaseAdapter {

    LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return 0;
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
            layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } if (convertView != null){
            layoutInflater.inflate(R.layout.row_item_clean_room,null);

        }

        TextView tv_tenPhong_clean = convertView.findViewById(R.id.tv_tenPhong_clean);
        TextView tvOptionDigitClean = convertView.findViewById(R.id.tvOptionDigitClean);
        TextView img_tinhTrangPhong = convertView.findViewById(R.id.img_tinhTrangPhong);
        TextView tv_tinhTrangPhong = convertView.findViewById(R.id.tv_tinhTrangPhong);

        tvOptionDigitClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(parent.getContext(),tvOptionDigitClean);
                popupMenu.inflate(R.menu.clean_room);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.donDep){
                            Toast.makeText(parent.getContext(),"Ok e! đã dọn dẹp",Toast.LENGTH_SHORT).show();
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
