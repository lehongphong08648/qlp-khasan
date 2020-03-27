package com.example.projectandroid.ui.bookingRoom;

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
import android.view.MenuItem;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.ui.FragmentHome;
import com.example.projectandroid.ui.checkInOut.CheckInOutActivity;
import com.example.projectandroid.ui.systemManager.SystemManagerActivity;
import com.google.android.material.navigation.NavigationView;

public class BookingRoomActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_room);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerBookingRoom);
        navigationView = findViewById(R.id.nagationView);
        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        fragmentManager =getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new FragmentBookingRoom());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.home1){
            startActivity(new Intent(BookingRoomActivity.this, MainActivity.class));
        }

        if (item.getItemId() == R.id.checkinout){
            startActivity(new Intent(BookingRoomActivity.this, CheckInOutActivity.class));
        }
        if (item.getItemId() == R.id.bookingroom) {
            startActivity(new Intent(BookingRoomActivity.this, BookingRoomActivity.class));
        }

        if (item.getItemId() == R.id.systemmanager){
            startActivity(new Intent(BookingRoomActivity.this, SystemManagerActivity.class));
        }

        return true;
    }
}
