package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Rooms;

import java.util.List;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder> {

    List<Rooms> rooms;

    public AdapterRoom( List<Rooms> rooms) {
        this.rooms = rooms;
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
        holder.tv_maPhong.setText(String.valueOf(rooms.get(position).getIdKOR()));
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
