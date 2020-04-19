package com.example.projectandroid.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

    private String idBooking;

    private float service;
    private float discount;

    private float total;

    public Invoice(int id, String idBooking, float service, float discount, float total) {
        this.id = id;
        this.idBooking = idBooking;
        this.service = service;
        this.discount = discount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
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
}
