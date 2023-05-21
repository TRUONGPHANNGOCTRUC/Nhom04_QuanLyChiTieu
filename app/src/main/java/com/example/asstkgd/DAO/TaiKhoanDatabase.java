package com.example.asstkgd.DAO;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asstkgd.Database.TaiKhoan;
import com.example.asstkgd.Entity.KhoanChi;

@Database(entities = {TaiKhoan.class}, version = 2)
public abstract class TaiKhoanDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Taikhoan.db";

    //tao bang taikhoan
    private static TaiKhoanDatabase instance;
    public static synchronized TaiKhoanDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),TaiKhoanDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract TaiKhoanDAO taiKhoanDAO();
}
