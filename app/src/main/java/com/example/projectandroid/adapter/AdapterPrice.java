package com.example.projectandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.ui.systemManager.FragmentPrice;

import java.util.ArrayList;

public class AdapterPrice extends RecyclerView.Adapter<AdapterPrice.ViewHolder> {

//    ArrayList<Price> priceArrayList;
//    Context context;
//    Price price;

//    public AdapterPrice(ArrayList<Price> priceArrayList, Context context) {
//        this.priceArrayList = priceArrayList;
//        this.context = context;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_price,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        price =(Price) priceArrayList.get(position);
        //phải thêm cả tên cách tính tiền nữa(để dẽ nhận bết hơn
//            holder.tv_price_name.setText(price.getNamePrice);
//        holder.tv_price_firt_hour.setText(String.valueOf(price.getOneDay()));
//        holder.tv_price_later_hour.setText(String.valueOf(price.getTwoHourFirst()));
//        holder.tv_price_one_day.setText(String.valueOf(price.getOneDay()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
            }
        });
    }

    @Override
    public int getItemCount() {
//        return priceArrayList.size();
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_price_name, tv_price_firt_hour, tv_price_later_hour,tv_price_one_day;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//        tv_price_name = itemView.findViewById(R.id.tv_priceName);
//            tv_price_firt_hour = itemView.findViewById(R.id.tv_price_firt_hour);
//            tv_price_later_hour = itemView.findViewById(R.id.tv_price_later_hour);
//            tv_price_later_hour = itemView.findViewById(R.id.tv_price_one_day);
        }
    }
}
