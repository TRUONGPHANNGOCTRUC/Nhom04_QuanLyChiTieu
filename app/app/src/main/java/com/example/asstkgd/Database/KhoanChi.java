package com.example.asstkgd.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class KhoanChi {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int maLoai;
    private String tenKhoanChi;
    private Date ngayThu;
    private float soTien;
    private String note;

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

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
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

    public String getTenNguoiChi() {
        return tenNguoiChi;
    }

    public void setTenNguoiChi(String tenNguoiChi) {
        this.tenNguoiChi = tenNguoiChi;
    }

    private String tenNguoiChi;

}
