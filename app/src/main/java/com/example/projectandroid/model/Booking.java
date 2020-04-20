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
    private int idClient;
    private int idUser;

    private Date dayCome;
    private Date dayGo;
    private float deposit;

    public Booking(String idRoom, int idClient, int idUser, Date dayCome, Date dayGo, float deposit) {
        this.idRoom = idRoom;
        this.idClient = idClient;
        this.idUser = idUser;
        this.dayCome = dayCome;
        this.dayGo = dayGo;
        this.deposit = deposit;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDayCome() {
        return dayCome;
    }

    public void setDayCome(Date dayCome) {
        this.dayCome = dayCome;
    }

    public Date getDayGo() {
        return dayGo;
    }

    public void setDayGo(Date dayGo) {
        this.dayGo = dayGo;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

}
