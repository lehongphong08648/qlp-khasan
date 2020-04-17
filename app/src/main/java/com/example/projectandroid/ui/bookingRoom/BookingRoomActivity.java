package com.example.projectandroid.ui.bookingRoom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
        fragmentTransaction.replace(R.id.container_fragment,new FragmentBookingRoom());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_view){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
