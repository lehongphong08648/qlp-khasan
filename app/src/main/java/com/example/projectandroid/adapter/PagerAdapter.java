package com.example.projectandroid.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectandroid.ui.checkInOut.FragmentCleanRoom;
import com.example.projectandroid.ui.checkInOut.FragmentRentectRoom;
import com.example.projectandroid.ui.checkInOut.FragmentWaitingRoom;

public class PagerAdapter extends FragmentPagerAdapter {

    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentWaitingRoom();
            case 1:
                return new FragmentRentectRoom();
            case 2:
                return new FragmentCleanRoom();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
