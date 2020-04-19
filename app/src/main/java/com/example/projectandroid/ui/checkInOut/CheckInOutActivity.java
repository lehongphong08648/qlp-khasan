package com.example.projectandroid.ui.checkInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.repository.RoomRepo;
import com.example.projectandroid.ui.FragmentHome;
import com.example.projectandroid.ui.bookingRoom.BookingRoomActivity;
import com.example.projectandroid.ui.bookingRoom.FragmentBookingRoom;
import com.example.projectandroid.ui.systemManager.FragmentSystemManager;
import com.example.projectandroid.ui.systemManager.SystemManagerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class CheckInOutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    PagerAdapter adapter;

    ViewPager viewPager;
    TabLayout mtableLayout;
    TabItem waitingItem, rentectItem, cleanItem;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_out);

        toolbar = findViewById(R.id.toolbar_check_in_out);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerCheckinout);
        navigationView = findViewById(R.id.nagationView);

        viewPager = findViewById(R.id.viewpager);
        mtableLayout = findViewById(R.id.tablayout);
        waitingItem = findViewById(R.id.waitingitem);
        rentectItem = findViewById(R.id.rentectitem);
        cleanItem = findViewById(R.id.cleanitem);

        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        adapter = new com.example.projectandroid.adapter.PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
                , mtableLayout.getTabCount());
        viewPager.setAdapter(adapter);

        mtableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtableLayout));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.home1) {
            startActivity(new Intent(CheckInOutActivity.this, MainActivity.class));
        }

        if (item.getItemId() == R.id.checkinout) {
            startActivity(new Intent(CheckInOutActivity.this, CheckInOutActivity.class));
        }
        if (item.getItemId() == R.id.bookingroom) {
            startActivity(new Intent(CheckInOutActivity.this, BookingRoomActivity.class));
        }

        if (item.getItemId() == R.id.systemmanager) {
            startActivity(new Intent(CheckInOutActivity.this, SystemManagerActivity.class));
        }

        return true;
    }

}
