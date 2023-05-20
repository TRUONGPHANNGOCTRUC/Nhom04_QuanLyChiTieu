package com.example.asstkgd.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.asstkgd.Entity.LoaiChi;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LoaiChiDAO_Impl implements LoaiChiDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoaiChi> __insertionAdapterOfLoaiChi;

  private final EntityDeletionOrUpdateAdapter<LoaiChi> __deletionAdapterOfLoaiChi;

  private final EntityDeletionOrUpdateAdapter<LoaiChi> __updateAdapterOfLoaiChi;

  public LoaiChiDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoaiChi = new EntityInsertionAdapter<LoaiChi>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LoaiChi` (`maLoai`,`tenLoai`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiChi value) {
        stmt.bindLong(1, value.getMaLoai());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
      }
    };
    this.__deletionAdapterOfLoaiChi = new EntityDeletionOrUpdateAdapter<LoaiChi>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LoaiChi` WHERE `maLoai` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiChi value) {
        stmt.bindLong(1, value.getMaLoai());
      }
    };
    this.__updateAdapterOfLoaiChi = new EntityDeletionOrUpdateAdapter<LoaiChi>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LoaiChi` SET `maLoai` = ?,`tenLoai` = ? WHERE `maLoai` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiChi value) {
        stmt.bindLong(1, value.getMaLoai());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
        stmt.bindLong(3, value.getMaLoai());
      }
    };
  }

  @Override
  public void insertLoaiChi(final LoaiChi loaiChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoaiChi.insert(loaiChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLoaiChi(final LoaiChi loaiChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfLoaiChi.handle(loaiChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateLoaiChi(final LoaiChi loaiChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLoaiChi.handle(loaiChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<LoaiChi> getAllLoaiChi() {
    final String _sql = "SELECT * FROM LoaiChi";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMaLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "maLoai");
      final int _cursorIndexOfTenLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "tenLoai");
      final List<LoaiChi> _result = new ArrayList<LoaiChi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LoaiChi _item;
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        _item = new LoaiChi(_tmpTenLoai);
        final int _tmpMaLoai;
        _tmpMaLoai = _cursor.getInt(_cursorIndexOfMaLoai);
        _item.setMaLoai(_tmpMaLoai);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
