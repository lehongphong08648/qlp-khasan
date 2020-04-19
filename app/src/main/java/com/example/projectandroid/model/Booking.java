package com.example.projectandroid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "booking",
        foreignKeys = {@ForeignKey(
                entity = Rooms.class,
                parentColumns = "idRoom",
                childColumns = "idRoom",
                onUpdate = ForeignKey.CASCADE
        ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "idUser",
                        childColumns = "idUser",
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Client.class,
                        parentColumns = "idClient",
                        childColumns = "idClient",
                        onUpdate = ForeignKey.CASCADE
                )
        },
        indices = {@Index(name = "idRoom_index", value = "idRoom"), @Index(name = "idUser_index", value = "idUser"), @Index(name = "idClient_index", value = "idClient")}
)
public class Booking {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idBooking")
    private String id;

    private String idRoom;
    private String idClient;
    private String idUser;

    private Date dayCome;
    private Date dayGo;
    private float deposit;
    private String status;

    @Ignore
    private Rooms room;

    @Ignore
    private Client client;

    @Ignore
    private User user;

    public Booking(String id, String idRoom, String idClient, String idUser, Date dayCome, Date dayGo, float deposit, String status) {
        this.id = id;
        this.idRoom = idRoom;
        this.idClient = idClient;
        this.idUser = idUser;
        this.dayCome = dayCome;
        this.dayGo = dayGo;
        this.deposit = deposit;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getIdUser() {
        return idUser;
    }

    public Date getDayCome() {
        return dayCome;
    }

    public Date getDayGo() {
        return dayGo;
    }

    public float getDeposit() {
        return deposit;
    }

    public String getStatus() {
        return status;
    }

    public Rooms getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }

    public User getUser() {
        return user;
    }
}
