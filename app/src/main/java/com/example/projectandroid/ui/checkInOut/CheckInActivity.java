package com.example.projectandroid.ui.checkInOut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectandroid.R;

public class CheckInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
