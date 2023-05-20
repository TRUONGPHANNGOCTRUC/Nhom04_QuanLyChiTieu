package com.example.asstkgd.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiChi {
    @PrimaryKey(autoGenerate = true)
    private int maLoai;
    private String tenLoai;

    public LoaiChi(String tenLoai) {
        this.tenLoai = tenLoai;
    }

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
