package com.example.projectandroid.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "client",
        indices = {@Index(value = "identityCard", unique = true)}
)
public class Client {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idClient")
    private int id;

    private String fullName;
    private String identityCard;

    private String nation;
    private String address;
    private int phoneNumber;
    private int vip;
    private Date birthOfDate;
    private String email;

    public Client(String fullName, String identityCard, String nation, String address, int phoneNumber, int vip, Date birthOfDate, String email) {
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.nation = nation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vip = vip;
        this.birthOfDate = birthOfDate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public String getNation() {
        return nation;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getVip() {
        return vip;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {

        return fullName + " | " + identityCard;
    }
}
