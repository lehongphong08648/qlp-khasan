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
import androidx.room.Room;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.ui.systemManager.FixRoomActivity;

import java.util.List;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder> {

    List<Rooms> rooms;
    Context context;
    public AdapterRoom( List<Rooms> rooms, Context context) {
        this.rooms = rooms;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row_room,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_sttRoom.setText(String.valueOf(position + 1));
        holder.tv_maPhong.setText(String.valueOf(rooms.get(position).getId()));
        holder.tv_tenTlp_phong.setText(String.valueOf(rooms.get(position).getIdKOR()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maPhong = String.valueOf(rooms.get(position).getId());
                String idKor = String.valueOf(rooms.get(position).getIdKOR());
                String tang = String.valueOf(rooms.get(position).getFloor());
                String dvKhac = String.valueOf(rooms.get(position).getService());
                String moTa = String.valueOf(rooms.get(position).getDescribe());

                Intent intent = new Intent(context, FixRoomActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("maPhong",maPhong);
                bundle.putString("idKor",idKor);
                bundle.putString("tang",tang);
                bundle.putString("dvKhac",dvKhac);
                bundle.putString("moTa",moTa);

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_sttRoom, tv_maPhong, tv_tenTlp_phong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sttRoom = itemView.findViewById(R.id.tv_sttRoom);
            tv_maPhong = itemView.findViewById(R.id.tv_maPhong);
            tv_tenTlp_phong = itemView.findViewById(R.id.tv_tenLp_phong);
        }
    }
}
