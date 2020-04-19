package com.example.projectandroid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "room",
        foreignKeys = {@ForeignKey(
                entity = KindOfRoom.class,
                parentColumns = "idKOR",
                childColumns = "idKOR"
        )},
        indices = {@Index(name = "idKOR_index", value = "idKOR")}
)
public class Rooms {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idRoom")
    private String id;

    private String idKOR;

    private int floor;

    private String service;

    private String describe;

    public Rooms(String id, String idKOR, int floor, String service, String describe) {
        this.id = id;
        this.idKOR = idKOR;
        this.floor = floor;
        this.service = service;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKOR() {
        return idKOR;
    }

    public void setIdKOR(String idKOR) {
        this.idKOR = idKOR;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
