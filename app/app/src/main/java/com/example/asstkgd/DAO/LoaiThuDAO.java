package com.example.asstkgd.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.asstkgd.Entity.LoaiThu;

import java.util.List;

@Dao
public interface LoaiThuDAO {
    @Insert
    void insertLoaiThu(LoaiThu loaiThu);

    @Query("SELECT * FROM LoaiThu")
    List<LoaiThu> getAllLoaiThu();

    @Update
    void updateLoaiThu(LoaiThu loaiThu);

    @Delete
    void deleteLoaiThu(LoaiThu loaiThu);
    
}
