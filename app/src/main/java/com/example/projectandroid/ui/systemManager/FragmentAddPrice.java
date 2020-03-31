package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectandroid.R;

public class FragmentAddPrice extends Fragment {

    EditText edt_namePrice, edt_firtHour, edt_firtHourPrice, edt_laterHourPrice;
    Button btn_addPrice, btn_cancelPrice;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_price,container,false);
        //ánh xạ
        edt_namePrice = view.findViewById(R.id.edt_namePrice);
        edt_firtHour = view.findViewById(R.id.edt_firtHour);
        edt_firtHourPrice = view.findViewById(R.id.edt_firtHourPrice);
        edt_laterHourPrice = view.findViewById(R.id.edt_laterHourPrice);
        btn_addPrice = view.findViewById(R.id.btn_addPrice);
        btn_cancelPrice = view.findViewById(R.id.btn_cancel_price);

        //thêm cách tính tiền vào đatabase
        btn_addPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePrice = edt_namePrice.getText().toString();
                String firtHour = edt_firtHour.getText().toString();
                String firtHourPrice = edt_firtHourPrice.getText().toString();
                String laterHourPrice = edt_laterHourPrice.getText().toString();

                Toast.makeText(getContext(),namePrice + " | " + firtHour+ " | " + firtHourPrice + " | " + laterHourPrice,Toast.LENGTH_SHORT).show();
            }
        });

        //hủy thêm cách tính tiền và trở về
        btn_cancelPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new FragmentPrice());
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}
