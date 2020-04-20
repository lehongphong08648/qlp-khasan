package com.example.projectandroid.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

    private String idBooking;

    private float service;
    private float discount;

    private float total;

<<<<<<< HEAD
    public Invoice(String idBooking, float service, float discount, float total) {
=======
    public Invoice(int id, String idBooking, float service, float discount, float total) {
        this.id = id;
>>>>>>> ddab3151a97f631cabdd26fd2142afefecf68cd6
        this.idBooking = idBooking;
        this.service = service;
        this.discount = discount;
        this.total = total;
    }
<<<<<<< HEAD
=======

>>>>>>> ddab3151a97f631cabdd26fd2142afefecf68cd6

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
