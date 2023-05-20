package com.example.asstkgd.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asstkgd.Entity.KhoanThu;


@Database(entities = {KhoanThu.class},version = 3)
public abstract class KhoannThuDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "khoanThu.db";
    private static KhoannThuDatabase instance;
    public static synchronized KhoannThuDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),KhoannThuDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract KhoanThuDAA khoanThuDAA();

}
