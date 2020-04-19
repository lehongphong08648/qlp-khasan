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

    @PrimaryKey
    @NonNull
    private String id;

    private String idBooking;

    private float service;
    private float discount;

    private float total;

    public Invoice(String id, String idBooking, float service, float discount, float total) {
        this.id = id;
        this.idBooking = idBooking;
        this.service = service;
        this.discount = discount;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public float getService() {
        return service;
    }

    public float getDiscount() {
        return discount;
    }

    public float getTotal() {
        return total;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public void setService(float service) {
        this.service = service;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
