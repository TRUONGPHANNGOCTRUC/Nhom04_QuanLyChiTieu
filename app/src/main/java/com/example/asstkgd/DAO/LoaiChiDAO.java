package com.example.asstkgd.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asstkgd.Entity.LoaiChi;

import java.util.List;

@Dao
public interface LoaiChiDAO {
    @Insert
    void insertLoaiChi(LoaiChi loaiChi);

    @Query("SELECT * FROM LoaiChi")
    List<LoaiChi> getAllLoaiChi();

    @Update
    void updateLoaiChi(LoaiChi loaiChi);

    @Delete
    void deleteLoaiChi(LoaiChi loaiChi);


}
