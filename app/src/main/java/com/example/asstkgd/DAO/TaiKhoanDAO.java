package com.example.asstkgd.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asstkgd.Database.TaiKhoan;
import com.example.asstkgd.Entity.KhoanChi;

import java.util.List;
@Dao
public interface TaiKhoanDAO {
    @Insert
    void insert(TaiKhoan taiKhoan);

    @Query("SELECT * FROM Taikhoan")
    List<TaiKhoan> getAll();

    @Update
    void update(TaiKhoan taiKhoan);

    @Delete
    void delete(TaiKhoan taiKhoan);
}
