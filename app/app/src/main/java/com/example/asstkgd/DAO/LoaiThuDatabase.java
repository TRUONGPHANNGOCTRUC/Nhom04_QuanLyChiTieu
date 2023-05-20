package com.example.asstkgd.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asstkgd.Entity.LoaiThu;

@Database(entities = {LoaiThu.class},version = 1)
public abstract class LoaiThuDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "loaithu.db";
    private static LoaiThuDatabase instance;
    public static synchronized LoaiThuDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),LoaiThuDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract LoaiThuDAO loaiThuDAO();
}
