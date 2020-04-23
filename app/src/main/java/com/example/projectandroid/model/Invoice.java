package com.example.projectandroid.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

import io.reactivex.annotations.NonNull;

@Entity(
        tableName = "invoice",
        foreignKeys = {@ForeignKey(
                entity = Booking.class,
                parentColumns = "idBooking",
                childColumns = "idBooking",
                onUpdate = ForeignKey.CASCADE
        )},
        indices = {@Index(name = "idBooking_index", value = "idBooking")}
)
public class Invoice {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private int idBooking;

    private float service;
    private float discount;

    private float total;
    private Date dayPay;

    public Invoice(int idBooking, float service, float discount, float total, Date dayPay) {
        this.idBooking = idBooking;
        this.service = service;
        this.discount = discount;
        this.total = total;
        this.dayPay = dayPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public float getService() {
        return service;
    }

    public void setService(float service) {
        this.service = service;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDayPay() {
        return dayPay;
    }

    public void setDayPay(Date dayPay) {
        this.dayPay = dayPay;
    }
}
