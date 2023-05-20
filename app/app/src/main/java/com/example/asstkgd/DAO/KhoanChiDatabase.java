package com.example.asstkgd.DAO;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asstkgd.Entity.KhoanChi;


@Database(entities = {KhoanChi.class}, version = 2)
public abstract class KhoanChiDatabase extends RoomDatabase  {
    private static final String DATABASE_NAME = "khoanChi.db";
    private static KhoanChiDatabase instance;
    public static synchronized KhoanChiDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),KhoanChiDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract KhoanChiDAO khoanChiDAO();
}
