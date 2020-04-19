package com.example.projectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.projectandroid.model.Client;
import com.example.projectandroid.model.User;
import com.example.projectandroid.repository.ClientRepo;
import com.example.projectandroid.repository.UserRepo;
import com.example.projectandroid.ui.bookingRoom.BookingRoomActivity;
import com.example.projectandroid.ui.bookingRoom.FragmentBookingRoom;
import com.example.projectandroid.ui.checkInOut.CheckInOutActivity;
import com.example.projectandroid.ui.FragmentHome;
import com.example.projectandroid.ui.systemManager.FragmentSystemManager;
import com.example.projectandroid.ui.systemManager.SystemManagerActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nagationView);
        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new FragmentHome());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.home1) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }

        if (item.getItemId() == R.id.checkinout) {
            startActivity(new Intent(MainActivity.this, CheckInOutActivity.class));
        }
        if (item.getItemId() == R.id.bookingroom) {
            startActivity(new Intent(MainActivity.this, BookingRoomActivity.class));
        }

        if (item.getItemId() == R.id.systemmanager) {
            startActivity(new Intent(MainActivity.this, SystemManagerActivity.class));
        }

        return true;
    }

}
