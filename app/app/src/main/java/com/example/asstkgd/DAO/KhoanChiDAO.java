package com.example.asstkgd.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.asstkgd.Entity.KhoanChi;

import java.util.List;

@Dao
public interface KhoanChiDAO {
    @Insert
    void insert(KhoanChi khoanChi);

    @Query("SELECT * FROM KhoanChi")
    List<KhoanChi> getAll();

    @Update
    void update(KhoanChi khoanChi);

    @Delete
    void delete(KhoanChi khoanChi);

    @Query("SELECT * FROM khoanchi where ngayThu between :star AND :end")
    List<KhoanChi> thongKe(String star , String end);

    @Query("SELECT sum(soTien) from khoanchi")
    Double tongTienChi();
}
