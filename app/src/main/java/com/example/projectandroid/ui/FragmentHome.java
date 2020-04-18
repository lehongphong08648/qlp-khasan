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

import com.example.projectandroid.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    TextView tv_home_hireOfDay, tv_home_waitingRoom, tv_home_rectectRoom, tv_home_cleanRoom;
    private LineChart mLineChart;
    private static final String TAG = "home";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        tv_home_hireOfDay = view.findViewById(R.id.tv_home_hireForDay);
        tv_home_waitingRoom = view.findViewById(R.id.tv_home_waitingRoom);
        tv_home_rectectRoom = view.findViewById(R.id.tv_home_rentectRoom);
        tv_home_cleanRoom = view.findViewById(R.id.tv_home_cleanRoom);

        mLineChart =(LineChart) view.findViewById(R.id.lineChart);
//        mLineChart.setOnChartGestureListener((OnChartGestureListener) getContext());
//        mLineChart.setOnChartValueSelectedListener((OnChartValueSelectedListener) getContext());
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(false);

        ArrayList<Entry> yValue = new ArrayList<>();
        yValue.add(new Entry(0,60f));
        yValue.add(new Entry(1,20f));
        yValue.add(new Entry(2,50f));
        yValue.add(new Entry(3,90f));
        yValue.add(new Entry(4,10f));
        yValue.add(new Entry(5,40f));
        yValue.add(new Entry(6,30f));

        ArrayList<Entry> xValue = new ArrayList<>();
        xValue.add(new Entry(0,600));
        xValue.add(new Entry(1,200));
        xValue.add(new Entry(2,500));
        xValue.add(new Entry(3,900));
        xValue.add(new Entry(4,100));
        xValue.add(new Entry(5,400));
        xValue.add(new Entry(6,300));

        LineDataSet set1 = new LineDataSet(yValue,"Số lượng phòng thuê");
        set1.setFillAlpha(110);
        set1.setColor(Color.RED);
        LineDataSet set2 = new LineDataSet(xValue,"Tổng tiền thuê phòng");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);

        LineData data = new LineData(dataSets);
        mLineChart.setData(data);

        return view;
    }
}
