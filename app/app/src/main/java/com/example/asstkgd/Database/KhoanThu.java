package com.example.asstkgd.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class KhoanThu {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int maLoai;
    private String tenKhoanThu;
    private Date ngayThu;
    private float soTien;
    private String note;
    private String tenNguoiThu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public float getSoTien() {
        return soTien;
    }

    public void setSoTien(float soTien) {
        this.soTien = soTien;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTenNguoiThu() {
        return tenNguoiThu;
    }

    public void setTenNguoiThu(String tenNguoiThu) {
        this.tenNguoiThu = tenNguoiThu;
    }
}
