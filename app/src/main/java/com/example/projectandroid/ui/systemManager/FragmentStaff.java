package com.example.projectandroid.ui.systemManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentStaff extends AppCompatActivity {
RecyclerView lv_user;
FloatingActionButton btn_ftm_add_user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_staff);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv_user = findViewById(R.id.lv_nguoiDung);
        btn_ftm_add_user = findViewById(R.id.btn_frm_them_nguoiDung);

        btn_ftm_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentStaff.this,Fragment_Add_User.class));
            }
        });
    }

}
