package com.example.projectandroid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "user"
)
public class User {

    @PrimaryKey
    @NonNull
    private String idUser;

    private String password;
    private String fullName;
    private String position;

    public User(String idUser, String password, String fullName, String position) {
        this.idUser = idUser;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
