package com.example.asstkgd.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asstkgd.Entity.KhoanThu;

import java.util.List;

@Dao
public interface KhoanThuDAA {
    @Insert
    void insertKhoanThu(KhoanThu khoanThu);

    @Query("SELECT * FROM KhoanThu")
    List<KhoanThu> getAll();
    @Update
    void updateKhoanThu(KhoanThu khoanThu);

    @Delete
    void delete(KhoanThu khoanThu);

    @Query("SELECT * FROM KhoanThu where ngayThu between :star and :end")
    List<KhoanThu> getThongKe(String star, String end);

    @Query("SELECT sum(soTien) from KhoanThu")
    Double tongTienThu();
}
