package com.example.projectandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kindOfRoom")
public class KindOfRoom {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idKOR")
    private int id;

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

    public KindOfRoom(String name, float priceTwoHourFirst, float priceOneHour, float priceOneDay, String describe) {
        this.name = name;
        this.priceTwoHourFirst = priceTwoHourFirst;
        this.priceOneHour = priceOneHour;
        this.priceOneDay = priceOneDay;
        this.describe = describe;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceTwoHourFirst(float priceTwoHourFirst) {
        this.priceTwoHourFirst = priceTwoHourFirst;
    }

    public void setPriceOneHour(float priceOneHour) {
        this.priceOneHour = priceOneHour;
    }

    public void setPriceOneDay(float priceOneDay) {
        this.priceOneDay = priceOneDay;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String toString(){
        return name;
    }
}
