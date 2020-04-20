package com.example.projectandroid.ui.systemManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterUser;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.UserRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentStaff extends AppCompatActivity {
RecyclerView lv_user;
FloatingActionButton btn_ftm_add_user;
AdapterUser adapterUser;
UserRepo userRepo;
List<User> users;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_staff);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv_user = findViewById(R.id.lv_nguoiDung);
        users = new ArrayList<>();
        userRepo = new UserRepo(FragmentStaff.this);
        users = userRepo.getAll();
        adapterUser = new AdapterUser(FragmentStaff.this,users);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FragmentStaff.this);
        lv_user.setAdapter(adapterUser);
        lv_user.setLayoutManager(layoutManager);

        btn_ftm_add_user = findViewById(R.id.btn_frm_them_nguoiDung);
        btn_ftm_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentStaff.this,Fragment_Add_User.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.note){
            getDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void getDialog(){
        Dialog dialog = new Dialog(FragmentStaff.this);
        dialog.setTitle("Ghí chú");
        dialog.setContentView(R.layout.item_row_user);
        dialog.show();

    }
}
