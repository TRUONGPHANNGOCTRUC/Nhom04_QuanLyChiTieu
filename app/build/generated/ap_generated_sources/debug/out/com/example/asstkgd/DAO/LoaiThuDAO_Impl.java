package com.example.asstkgd.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.asstkgd.Entity.LoaiThu;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LoaiThuDAO_Impl implements LoaiThuDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoaiThu> __insertionAdapterOfLoaiThu;

  private final EntityDeletionOrUpdateAdapter<LoaiThu> __deletionAdapterOfLoaiThu;

  private final EntityDeletionOrUpdateAdapter<LoaiThu> __updateAdapterOfLoaiThu;

  public LoaiThuDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoaiThu = new EntityInsertionAdapter<LoaiThu>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LoaiThu` (`maLoai`,`tenLoai`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiThu value) {
        stmt.bindLong(1, value.getMaLoai());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
      }
    };
    this.__deletionAdapterOfLoaiThu = new EntityDeletionOrUpdateAdapter<LoaiThu>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LoaiThu` WHERE `maLoai` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiThu value) {
        stmt.bindLong(1, value.getMaLoai());
      }
    };
    this.__updateAdapterOfLoaiThu = new EntityDeletionOrUpdateAdapter<LoaiThu>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LoaiThu` SET `maLoai` = ?,`tenLoai` = ? WHERE `maLoai` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiThu value) {
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
  public void insertLoaiThu(final LoaiThu loaiThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoaiThu.insert(loaiThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLoaiThu(final LoaiThu loaiThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfLoaiThu.handle(loaiThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateLoaiThu(final LoaiThu loaiThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLoaiThu.handle(loaiThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<LoaiThu> getAllLoaiThu() {
    final String _sql = "SELECT * FROM LoaiThu";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMaLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "maLoai");
      final int _cursorIndexOfTenLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "tenLoai");
      final List<LoaiThu> _result = new ArrayList<LoaiThu>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LoaiThu _item;
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        _item = new LoaiThu(_tmpTenLoai);
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
