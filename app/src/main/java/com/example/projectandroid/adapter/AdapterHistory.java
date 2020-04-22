package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.Invoice;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder>{

    Context mContext;
String ngayDen;
String ngayDi;
String tenPhong;
Float tienPhong;
Client client;
List<Invoice>invoices;

    public AdapterHistory(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_item_history,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_stt_history.setText(String.valueOf(position+1));
        holder.tv_ngayThue_history.setText(invoices.get(position).getId());
        holder.tv_ngayTra_history.setText(invoices.get(position).getIdBooking());
        holder.tv_tenPhong_history.setText(String.valueOf(invoices.get(position).getDiscount()));
        holder.tv_tienPhong_history.setText(String.valueOf(invoices.get(position).getTotal()));
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
