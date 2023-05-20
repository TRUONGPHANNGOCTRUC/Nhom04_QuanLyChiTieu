package com.example.asstkgd.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiThu {
    @PrimaryKey(autoGenerate = true)
    private int maLoai;
    private String tenLoai;

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
