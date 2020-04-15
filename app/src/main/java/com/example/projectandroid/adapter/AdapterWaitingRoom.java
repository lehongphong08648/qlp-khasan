package com.example.projectandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectandroid.R;

public class AdapterWaitingRoom extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String [] numberWork;
    int [] numberimg;

    public AdapterWaitingRoom(Context context, String[] numberWork, int[] numberimg) {
        this.context = context;
        this.numberWork = numberWork;
        this.numberimg = numberimg;
    }

    @Override
    public int getCount() {
        return numberimg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.row_item_waiting_room,null);
        }


        ImageView img = convertView.findViewById(R.id.img_status_waitingRoom);
        TextView tv = convertView.findViewById(R.id.tv_status_waitingRoom);

        //nếu như mà phòng được trả mà chưa dọn dẹp thì sẽ hiển thị ở cả phần clean room mà waiting room
        //nhưng sẽ hiển tị là " Not cleaned yet " còn nếu rọn rẹp rồi thì tv sẽ chuyển thành " Tidied up "
        img.setImageResource(numberimg[position]);
        tv.setText(numberWork[position]);
        return convertView;
    }
}
