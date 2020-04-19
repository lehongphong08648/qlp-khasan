package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder>{

    Context mContext;

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
    }

    @Override
    public int getItemCount() {
        return 0;
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
