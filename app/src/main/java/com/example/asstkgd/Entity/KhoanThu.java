package com.example.asstkgd.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class KhoanThu {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tenLoai;
    private String tenKhoanThu;
    private String ngayThu;
    private String soTien;
    private String note;
    private String tenNguoiThu;

    public KhoanThu() {
    }

    public KhoanThu( String tenLoai, String tenKhoanThu, String ngayThu, String soTien, String note, String tenNguoiThu) {
        this.tenLoai = tenLoai;
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.soTien = soTien;
        this.note = note;
        this.tenNguoiThu = tenNguoiThu;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
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

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
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
