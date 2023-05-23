package com.example.asstkgd.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asstkgd.DangKyActivity;
import com.example.asstkgd.Entity.TaiKhoan;

public class TaiKhoanDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DuLieuTaiKhoan.db";
    private static final String TABLE_NAME = "DuLieuTaiKhoan";
    private static final int VERSION = 1;
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PASSWORD = "pass";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_IP = "ip";
    private static final String COLUMN_NPHONE = "nphone";

    public static final String TABLE_CRETAE = "create table DuLieuTaiKhoan( id text primary key not null, " + "pass text not null, name text not null, ip text not null, nphone text );";
    SQLiteDatabase db;

    public TaiKhoanDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public TaiKhoanDatabaseHelper(Context context) {
        super(context, "QuanLyChiTieu", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL((TABLE_CRETAE));
        this.db = db;

    }

    //goi khi nang cap ung dung va thay doi gia tri csdl
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    // them tai khoan vao csdl
    public void insertTK(TaiKhoan kh) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, kh.getM_TK());
        values.put(COLUMN_PASSWORD, kh.getM_Matkhau());
        values.put(COLUMN_NAME, kh.getM_Ten());
        values.put(COLUMN_IP, kh.getM_Diachi());
        values.put(COLUMN_NPHONE, kh.getM_Sdt());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // cap nhat khi doi mat khau
    public void UpdateTK(String id, String pass) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD, pass);
        db.update(TABLE_NAME, values, COLUMN_ID + "= ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // tim kiem tai khoan nguoi dung theo id nguoi dung nhap vao
    public boolean searchTK(String TK) {
        db = this.getReadableDatabase();
        String query = "select id from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String username;
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                if (username.equals(TK)) {
                    db.close();
                    return true;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return false;
    }
    public String searchPass(String tk) {
        db = this.getReadableDatabase();
        String query = "select id, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String username;
        String pass = "Không tìm thấy";
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                if (username.equals(1)) {
                    pass = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return pass;
    }

    public void deleteAll() {
        db = this.getWritableDatabase();
        db.delete(this.TABLE_NAME, null, null);
        db.close();
    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}


