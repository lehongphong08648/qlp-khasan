package com.example.projectandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kindOfRoom")
public class KindOfRoom {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idKOR")
    private String id;

    @ColumnInfo(name = "nameKOR")
    private String name;

    @ColumnInfo(name = "priceTwoHourFirst")
    private float priceTwoHourFirst;

    @ColumnInfo(name = "priceOneHour")
    private float priceOneHour;

    @ColumnInfo(name = "priceOneDay")
    private float priceOneDay;

    @ColumnInfo(name = "des")
    private String describe;

    public KindOfRoom( String name, float priceTwoHourFirst, float priceOneHour, float priceOneDay, String describe) {
        this.name = name;
        this.priceTwoHourFirst = priceTwoHourFirst;
        this.priceOneHour = priceOneHour;
        this.priceOneDay = priceOneDay;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPriceTwoHourFirst() {
        return priceTwoHourFirst;
    }

    public float getPriceOneHour() {
        return priceOneHour;
    }

    public float getPriceOneDay() {
        return priceOneDay;
    }

    public String getDescribe() {
        return describe;
    }
}
