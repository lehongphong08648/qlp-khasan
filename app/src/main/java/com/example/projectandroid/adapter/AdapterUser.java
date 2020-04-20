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
import com.example.projectandroid.model.User;
import com.example.projectandroid.ui.systemManager.FixUserActivity;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder>{

    Context mContext;
    List<User> users;

    public AdapterUser(Context mContext, List<User> users) {
        this.mContext = mContext;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_row_user,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tv_maND_user.setText(String.valueOf(users.get(position).getIdUser()));
        holder.tv_chucVu_user.setText(users.get(position).getPosition());
        holder.tv_hoTen_user.setText(users.get(position).getFullName());
        holder.tv_matKhau_user.setText(users.get(position).getPassword());
        holder.tv_stt_user.setText(String.valueOf(position+1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maND_user = String.valueOf(users.get(position).getIdUser());
                String chucVu_user = String.valueOf(users.get(position).getPosition());
                String hoTen_user = String.valueOf(users.get(position).getFullName());
                String matKhau_user = String.valueOf(users.get(position).getPassword());
                Intent intent = new Intent(mContext,FixUserActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maND_user",maND_user);
                bundle.putString("hoTen_user",hoTen_user);
                bundle.putString("matKhau_user",matKhau_user);
                bundle.putString("chucVu_user",chucVu_user);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView tv_maND_user, tv_chucVu_user, tv_hoTen_user, tv_matKhau_user,tv_stt_user;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_maND_user = itemView.findViewById(R.id.tv_maND_user);
            tv_chucVu_user = itemView.findViewById(R.id.tv_chucVu_user);
            tv_hoTen_user = itemView.findViewById(R.id.tv_hoTen_user);
            tv_matKhau_user = itemView.findViewById(R.id.tv_matKhau_user);
            tv_stt_user = itemView.findViewById(R.id.tv_stt_user);
        }
    }
}
