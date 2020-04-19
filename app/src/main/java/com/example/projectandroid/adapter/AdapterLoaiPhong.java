package com.example.projectandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.model.KindOfRoom;
import com.example.projectandroid.ui.systemManager.FixKindOfRoomActivity;

import java.util.List;

public class AdapterLoaiPhong extends RecyclerView.Adapter<AdapterLoaiPhong.ViewHolder> {
List<KindOfRoom> kindOfRooms;
Context context;

    public AdapterLoaiPhong(Context context, List<KindOfRoom> kindOfRooms) {
        this.kindOfRooms = kindOfRooms;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_loai_phong,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_tenTheLoaiPhong.setText(kindOfRooms.get(position).getName());
        holder.tv_maTheLoaiPhong.setText(String.valueOf(kindOfRooms.get(position).getId()));
        holder.tv_gia2hDau.setText(String.valueOf(kindOfRooms.get(position).getPriceTwoHourFirst()));
        holder.tv_gia1Ngay.setText(String.valueOf(kindOfRooms.get(position).getPriceOneDay()));
        holder.tv_gia1hTiep.setText(String.valueOf(kindOfRooms.get(position).getPriceOneHour()));
        holder.tv_stt.setText(String.valueOf(position+ 1));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, FixKindOfRoomActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("tenTheLoaiPhong",kindOfRooms.get(position).getName());
                bundle.putString("maTheLoaiPhong",String.valueOf(kindOfRooms.get(position).getId()));
                bundle.putString("gia2hDau",String.valueOf(kindOfRooms.get(position).getPriceTwoHourFirst()));
                bundle.putString("gia1Ngay",String.valueOf(kindOfRooms.get(position).getPriceOneDay()));
                bundle.putString("gia1hTiep",String.valueOf(kindOfRooms.get(position).getPriceOneHour()));
                bundle.putString("moTa",String.valueOf(kindOfRooms.get(position).getDescribe()));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kindOfRooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenTheLoaiPhong, tv_maTheLoaiPhong, tv_gia2hDau, tv_gia1Ngay, tv_gia1hTiep,tv_stt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenTheLoaiPhong = itemView.findViewById(R.id.tv_tenTheLoaiPhong);
            tv_maTheLoaiPhong = itemView.findViewById(R.id.tv_maTheLoaiPhong);
            tv_gia2hDau = itemView.findViewById(R.id.tv_gia2hDau);
            tv_gia1Ngay = itemView.findViewById(R.id.tv_gia1Ngay);
            tv_gia1hTiep = itemView.findViewById(R.id.tv_gia1hTiep);
            tv_stt = itemView.findViewById(R.id.tv_stt);
        }
    }
}
