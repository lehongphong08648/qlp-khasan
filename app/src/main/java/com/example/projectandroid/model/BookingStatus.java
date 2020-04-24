package com.example.projectandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(
        tableName = "BookingStatus",
        foreignKeys = {@ForeignKey(
                entity = Booking.class,
                parentColumns = "idBooking",
                childColumns = "idBooking",
                onUpdate = ForeignKey.CASCADE
        )},
        indices = {@Index(name = "idBooking_Status_index", value = "idBooking")}
)
public class BookingStatus {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idBookingStatus")
    private int id;

    private int idBooking;
    private String status;

    public BookingStatus(int idBooking, String status) {
        this.idBooking = idBooking;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
