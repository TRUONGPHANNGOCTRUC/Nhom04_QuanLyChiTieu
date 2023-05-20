package com.example.asstkgd.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class KhoanChi {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tenLoai;
    private String tenKhoanChi;
    private String ngayThu;
    private String soTien;
    private String note;

    public KhoanChi(String tenLoai, String tenKhoanChi, String ngayThu, String soTien, String note, String tenNguoiChi) {
        this.tenLoai = tenLoai;
        this.tenKhoanChi = tenKhoanChi;
        this.ngayThu = ngayThu;
        this.soTien = soTien;
        this.note = note;
        this.tenNguoiChi = tenNguoiChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }


    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
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
