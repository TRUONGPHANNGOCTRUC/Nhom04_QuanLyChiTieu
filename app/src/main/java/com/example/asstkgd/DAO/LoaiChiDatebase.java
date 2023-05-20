package com.example.asstkgd.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asstkgd.Entity.LoaiChi;

@Database(entities = {LoaiChi.class}, version = 1)
public abstract class LoaiChiDatebase extends RoomDatabase {
    private static final String DATABASE_NAME = "loaiChi.db";
    private static LoaiChiDatebase instance;
    public static synchronized LoaiChiDatebase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),LoaiChiDatebase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract LoaiChiDAO loaiChiDAO();

}
