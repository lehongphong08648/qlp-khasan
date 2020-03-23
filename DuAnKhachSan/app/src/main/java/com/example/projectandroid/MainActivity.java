package com.example.projectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
DrawerLayout drawerLayout;
Toolbar toolbar;
NavigationView navigationView;
ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweroOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_mainPage:
                Toast.makeText(this,"Main Page",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_checkInOut:
                Toast.makeText(this,"Check in - out",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_bookRoom:
                Toast.makeText(this,"Book Room",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_systemManager:
                Toast.makeText(this,"System Manager",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
