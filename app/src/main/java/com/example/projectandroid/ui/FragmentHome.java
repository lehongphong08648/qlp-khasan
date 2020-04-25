package com.example.projectandroid.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectandroid.MainActivity;
import com.example.projectandroid.R;
import com.example.projectandroid.model.Invoice;
import com.example.projectandroid.model.Rooms;
import com.example.projectandroid.repository.InvoiceRepo;
import com.example.projectandroid.repository.RoomRepo;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FragmentHome extends Fragment {

    TextView tv_home_hireOfDay, tv_home_waitingRoom, tv_home_rectectRoom, tv_home_cleanRoom;
    private LineChart mLineChart;
    private static final String TAG = "home";
    RoomRepo roomRepo;
    List<Rooms> rooms;
    List<Rooms> slRentectRooms;
    List<Rooms> slCleanRooms;
int ngay,ngay1,ngay2,ngay3,ngay4,ngay5,ngay6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        roomRepo = new RoomRepo(getContext());


        tv_home_hireOfDay = view.findViewById(R.id.tv_home_hireForDay);

        tv_home_waitingRoom = view.findViewById(R.id.tv_home_waitingRoom);
        rooms = new ArrayList<>();
        rooms = roomRepo.getAllOfflineRoom();
        int slWaiting = rooms.size();
        tv_home_waitingRoom.setText(String.valueOf(slWaiting));

        tv_home_rectectRoom = view.findViewById(R.id.tv_home_rentectRoom);
        slRentectRooms = new ArrayList<>();
        slRentectRooms = roomRepo.getAllOnlineRoom();
        int slRentectRoom = slRentectRooms.size();
        tv_home_rectectRoom.setText(String.valueOf(slRentectRoom));

        tv_home_cleanRoom = view.findViewById(R.id.tv_home_cleanRoom);
        slCleanRooms = new ArrayList<>();
        slCleanRooms = roomRepo.getAllBusyRoom();
        int slCleanRoom = slCleanRooms.size();
        tv_home_cleanRoom.setText(String.valueOf(slCleanRoom));

        mLineChart =(LineChart) view.findViewById(R.id.lineChart);
//        mLineChart.setOnChartGestureListener((OnChartGestureListener) getContext());
//        mLineChart.setOnChartValueSelectedListener((OnChartValueSelectedListener) getContext());
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(false);



        ArrayList<Entry> yValue = new ArrayList<>();
        yValue.add(new Entry(0,10f));
        yValue.add(new Entry(1,20f));
        yValue.add(new Entry(2,50f));
        yValue.add(new Entry(3,90f));
        yValue.add(new Entry(4,10f));
        yValue.add(new Entry(5,40f));
        yValue.add(new Entry(6,30f));


        LineDataSet set1 = new LineDataSet(yValue,"Doanh số phòng thuê phòng thuê");
        set1.setFillAlpha(110);
        set1.setColor(Color.RED);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        return view;
    }
}
