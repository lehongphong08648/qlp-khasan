package com.example.projectandroid.ui.systemManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterClient;
import com.example.projectandroid.model.Client;
import com.example.projectandroid.repository.ClientRepo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {
RecyclerView lv_client;
FloatingActionButton btn_frm_client;
AdapterClient adapterClient;
List<Client> clients;
ClientRepo clientRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_frm_client = findViewById(R.id.btn_frm_client);
        lv_client = findViewById(R.id.lv_client);

        clients = new ArrayList<>();
        clientRepo = new ClientRepo(ClientActivity.this);
        clients = clientRepo.getAll();

        adapterClient = new AdapterClient(clients,ClientActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        lv_client.setAdapter(adapterClient);
        lv_client.setLayoutManager(layoutManager);

        btn_frm_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClientActivity.this,AddClientActivity.class));
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
        Dialog dialog = new Dialog(ClientActivity.this);
        dialog.setTitle("Ghí chú");
        dialog.setContentView(R.layout.row_item_client);
        dialog.show();

    }


}
