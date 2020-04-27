package com.example.projectandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.bookingRoom.FixBookingActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder>{

List<Booking> bookings;
Context context;
    public AdapterBooking(List<Booking> bookings, Context context) {
        this.bookings = bookings;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_price,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClientRepo clientRepo = new ClientRepo(context);
        int idClient = bookings.get(position).getIdClient();
        String idRoom = bookings.get(position).getIdRoom();
        Client client = clientRepo.getClientById(idClient);
        String clientName = client.getFullName();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String ngayDen = simpleDateFormat.format(bookings.get(position).getDayCome());
        String ngayDi = simpleDateFormat.format(bookings.get(position).getDayGo());
                holder.tv_ngayDenItem.setText(ngayDen);
                holder.tv_nameClientItem.setText(clientName);
                holder.tv_stt_booking.setText(String.valueOf(position +1));
                holder.tv_ngayDiItem.setText(ngayDi);
                holder.tv_tienConItem.setText(String.valueOf(bookings.get(position).getDeposit()));
                holder.tv_nameRoomItem.setText(bookings.get(position).getIdRoom());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, FixBookingActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("idClien",String.valueOf(idClient));
                        bundle.putString("idRoom",idRoom);
                        bundle.putString("dayCome",String.valueOf(bookings.get(position).getDayCome()));
                        bundle.putString("dayGo",String.valueOf(bookings.get(position).getDayGo()));
                        bundle.putString("tienCoc",String.valueOf(bookings.get(position).getDeposit()));
                        bundle.putString("idBooking",String.valueOf(bookings.get(position).getIdBooking()));
                        bundle.putString("idUser",bookings.get(position).getIdUser());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
        }

    @Override
    public int getItemCount() {
        return bookings.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_ngayDenItem, tv_ngayDiItem, tv_nameClientItem, tv_nameRoomItem, tv_tienConItem,tv_stt_booking;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ngayDenItem = itemView.findViewById(R.id.tv_ngayDen_item);
            tv_ngayDiItem = itemView.findViewById(R.id.tv_ngayDi_item);
            tv_nameClientItem = itemView.findViewById(R.id.tv_nameClientItem);
            tv_nameRoomItem = itemView.findViewById(R.id.tv_nameRoomItem);
            tv_tienConItem = itemView.findViewById(R.id.tv_tienConItem);
            tv_stt_booking = itemView.findViewById(R.id.tv_stt_booking);
        }
    }
}
