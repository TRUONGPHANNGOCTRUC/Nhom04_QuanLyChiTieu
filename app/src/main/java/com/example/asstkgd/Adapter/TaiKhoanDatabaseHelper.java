package com.example.asstkgd.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public static final String TABLE_CREATE = "create table DuLieuTaiKhoan ( id text primary key not null," +  " pass text not null,name text not null, ip text not null,nphone text );";
    SQLiteDatabase db;



    public TaiKhoanDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL((TABLE_CREATE));
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
    public boolean searchTK(String id) {
        db = this.getWritableDatabase();
        String query = "select * from DuLieuTaiKhoan where id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{id});
        if(cursor.getCount()>0) {
            return true;
        }else{
            return false;
        }
    }
    public boolean KiemTraDangNhap(String id, String pass) {
        db = this.getWritableDatabase();
        String query = "select * from DuLieuTaiKhoan where id = ? and pass = ?";
        Cursor cursor = db.rawQuery(query, new String[]{id, pass});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
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


