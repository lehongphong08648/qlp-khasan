package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.model.KindOfRoom;

import java.util.List;

public class AdapterLoaiPhong extends RecyclerView.Adapter<AdapterLoaiPhong.ViewHolder> {
Context context;
List<KindOfRoom> kindOfRooms;

    public AdapterLoaiPhong(Context context, List<KindOfRoom> kindOfRooms) {
        this.context = context;
        this.kindOfRooms = kindOfRooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_loai_phong,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //chưa hiểu database lên em chưa ghép đc
        holder.tv_tenTheLoaiPhong.setText(kindOfRooms.get(position).getName());
        holder.tv_maTheLoaiPhong.setText(kindOfRooms.get(position).getId());
        holder.tv_gia2hDau.setText(String.valueOf(kindOfRooms.get(position).getPriceTwoHourFirst()));
        holder.tv_gia1Ngay.setText(String.valueOf(kindOfRooms.get(position).getPriceOneDay()));
        holder.tv_gia1hTiep.setText(String.valueOf(kindOfRooms.get(position).getPriceOneHour()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang thông tin chi tiết, cần kết hợp cả bundle để chuyền dữ liệu
            }
        });

    }

    @Override
    public int getItemCount() {
        return kindOfRooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenTheLoaiPhong, tv_maTheLoaiPhong, tv_gia2hDau, tv_gia1Ngay, tv_gia1hTiep;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenTheLoaiPhong = itemView.findViewById(R.id.tv_tenTheLoaiPhong);
            tv_maTheLoaiPhong = itemView.findViewById(R.id.tv_maTheLoaiPhong);
            tv_gia2hDau = itemView.findViewById(R.id.tv_gia2hDau);
            tv_gia1Ngay = itemView.findViewById(R.id.tv_gia1Ngay);
            tv_gia1hTiep = itemView.findViewById(R.id.tv_gia1hTiep);
        }
    }
}
