package com.example.projectandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder> implements Filterable {
List<String> itemList;
List<String> itemListAll;

    public AdapterBooking(List<String> itemList) {
        this.itemList = itemList;
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
                holder.tv_ngayDenItem.setText(itemList.get(position));
                holder.tv_nameClientItem.setText(String.valueOf(position));
        }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();
            if (constraint.toString().isEmpty()){
                filteredList.addAll(itemListAll);
            }else {
                for (String item: itemListAll){
                    if (item.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemList.clear();
            itemList.addAll((Collection<? extends String>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_ngayDenItem, tv_ngayDiItem, tv_nameClientItem, tv_nameRoomItem, tv_tienConItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ngayDenItem = itemView.findViewById(R.id.tv_ngayDen_item);
            tv_ngayDiItem = itemView.findViewById(R.id.tv_ngayDen_item);
            tv_nameClientItem = itemView.findViewById(R.id.tv_nameClientItem);
            tv_nameRoomItem = itemView.findViewById(R.id.tv_nameRoomItem);
            tv_tienConItem = itemView.findViewById(R.id.tv_tienConItem);
        }
    }
}
