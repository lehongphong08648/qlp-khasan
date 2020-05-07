package com.example.projectandroid.ui.systemManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.adapter.AdapterHistory;
import com.example.projectandroid.model.Invoice;
import com.example.projectandroid.repository.InvoiceRepo;

import java.util.ArrayList;
import java.util.List;

public class FragmentHistory extends AppCompatActivity {
RecyclerView lv_history;
AdapterHistory adapterHistory;
InvoiceRepo invoiceRepo;
List<Invoice> invoices;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_history);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        invoiceRepo = new InvoiceRepo(this);
        invoices = new ArrayList<>();
        invoices = invoiceRepo.getAll();

        lv_history = findViewById(R.id.lv_history);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        adapterHistory = new AdapterHistory(invoices,this);
        lv_history.setAdapter(adapterHistory);
        lv_history.setLayoutManager(mLayoutManager);
    }

}
