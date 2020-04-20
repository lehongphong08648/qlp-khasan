package com.example.projectandroid.model;

import androidx.annotation.NonNull;

public class QuocTich {
    String quocTich;

    public QuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @NonNull
    @Override
    public String toString() {
        return quocTich;
    }
}
