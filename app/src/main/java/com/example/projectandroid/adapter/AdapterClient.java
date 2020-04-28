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
import com.example.projectandroid.model.Client;
import com.example.projectandroid.ui.systemManager.FixClientActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterClient extends RecyclerView.Adapter<AdapterClient.ViewHolder>{

    List<Client> clients;
    Context context;

    public AdapterClient(List<Client> clients, Context context) {
        this.clients = clients;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item_client,parent,false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date BirthOfDate = clients.get(position).getBirthOfDate();
        String date = simpleDateFormat.format(BirthOfDate);

            holder.tv_idCard.setText(clients.get(position).getIdentityCard());
        holder.tv_nameClient.setText(clients.get(position).getFullName());
        holder.tv_vip.setText(String.valueOf(clients.get(position).getVip()));
        holder.tv_quocTich.setText(clients.get(position).getNation());
        holder.tv_stt_client.setText(String.valueOf(position+1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idCard = clients.get(position).getIdentityCard();
                String nameClient = clients.get(position).getFullName();
                String vip = String.valueOf(clients.get(position).getVip());
                String quocTich = clients.get(position).getNation();
                String Address = clients.get(position).getAddress();
                String Email = clients.get(position).getEmail();
                String Id = String.valueOf(clients.get(position).getId());

                String PhoneNumber = String.valueOf(clients.get(position).getPhoneNumber());

                Intent intent = new Intent(context, FixClientActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("idCard",idCard);
                bundle.putString("nameClient",nameClient);
                bundle.putString("vip",vip);
                bundle.putString("quocTich",quocTich);
                bundle.putString("Address",Address);
                bundle.putString("Email",Email);
                bundle.putString("Id",Id);

                bundle.putString("ns",date);
//                bundle.putString("BirthOfDate",date);
                bundle.putString("PhoneNumber",PhoneNumber);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nameClient, tv_vip, tv_idCard, tv_quocTich, tv_stt_client;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nameClient =  itemView.findViewById(R.id.tv_nameClient);
            tv_vip =  itemView.findViewById(R.id.tv_vip);
            tv_idCard =  itemView.findViewById(R.id.tv_idCard);
            tv_quocTich =  itemView.findViewById(R.id.tv_quocTich);
            tv_stt_client =  itemView.findViewById(R.id.tv_stt_client);
        }
    }
}
