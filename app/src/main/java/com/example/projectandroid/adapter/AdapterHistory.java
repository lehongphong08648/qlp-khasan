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
import com.example.projectandroid.model.Booking;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.Invoice;
import com.example.projectandroid.repository.BookingRepo;
import com.example.projectandroid.ui.systemManager.FixInvoicesActivity;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder>{

    Context mContext;
List<Invoice>invoices;
Booking booking;
BookingRepo bookingRepo;
Context context;

    public AdapterHistory(List<Invoice> invoices,Context context) {
        this.invoices = invoices;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_item_history,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_stt_history.setText(String.valueOf(position+1));
        holder.tv_ngayThue_history.setText(String.valueOf(invoices.get(position).getId()));
        holder.tv_ngayTra_history.setText(String.valueOf(invoices.get(position).getIdBooking()));
        holder.tv_tenPhong_history.setText(String.valueOf(invoices.get(position).getDiscount()));
        holder.tv_tienPhong_history.setText(String.valueOf(invoices.get(position).getTotal()));

        bookingRepo = new BookingRepo(context);
        //TODO: sao ở bảng Booking id là int và trong bảng Invoices idBooking lại là String ????;
        booking = bookingRepo.getBookingById(Integer.parseInt(invoices.get(position).getIdBooking()));
        String idBooking = String.valueOf(booking.getId());
        String idRoom = String.valueOf(booking.getIdRoom());
        String idClient = String.valueOf(booking.getIdClient());
        String idUser = String.valueOf(booking.getIdUser());
        String ngayDen = String.valueOf(booking.getDayCome());
        String ngayDi = String.valueOf(booking.getDayGo());
        String tienCoc = String.valueOf(booking.getDeposit());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, FixInvoicesActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString("idBooking",idBooking);
               bundle.putString("idRoom",idRoom);
               bundle.putString("idClient",idClient);
               bundle.putString("idUser",idUser);
               bundle.putString("ngayDen",ngayDen);
               bundle.putString("ngayDi",ngayDi);
               bundle.putString("tienCoc",tienCoc);

               bundle.putString("idInvoices",String.valueOf(invoices.get(position).getId()));
               bundle.putString("disCount",String.valueOf(invoices.get(position).getDiscount()));
               bundle.putString("tolTal",String.valueOf(invoices.get(position).getTotal()));
               intent.putExtras(bundle);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return invoices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_ngayThue_history, tv_ngayTra_history, tv_tenPhong_history, tv_tienPhong_history,tv_stt_history;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ngayThue_history = itemView.findViewById(R.id.tv_ngayThue_history);
            tv_ngayTra_history = itemView.findViewById(R.id.tv_ngayTra_history);
            tv_tenPhong_history = itemView.findViewById(R.id.tv_tenPhong_history);
            tv_tienPhong_history = itemView.findViewById(R.id.tv_tienPhong_history);
            tv_stt_history = itemView.findViewById(R.id.tv_stt_history);

        }
    }
}
