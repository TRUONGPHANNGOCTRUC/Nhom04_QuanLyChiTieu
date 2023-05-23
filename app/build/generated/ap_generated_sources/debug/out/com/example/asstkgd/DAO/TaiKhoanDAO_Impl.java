package com.example.asstkgd.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.asstkgd.Database.TaiKhoan;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaiKhoanDAO_Impl implements TaiKhoanDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TaiKhoan> __insertionAdapterOfTaiKhoan;

  private final EntityDeletionOrUpdateAdapter<TaiKhoan> __deletionAdapterOfTaiKhoan;

  private final EntityDeletionOrUpdateAdapter<TaiKhoan> __updateAdapterOfTaiKhoan;

  public TaiKhoanDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaiKhoan = new EntityInsertionAdapter<TaiKhoan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TaiKhoan` (`id`,`m_TK`,`m_Matkhau`,`m_Ten`,`m_Diachi`,`m_Sdt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaiKhoan value) {
        stmt.bindLong(1, value.getId());
        if (value.getM_TK() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getM_TK());
        }
        if (value.getM_Matkhau() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getM_Matkhau());
        }
        if (value.getM_Ten() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getM_Ten());
        }
        if (value.getM_Diachi() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getM_Diachi());
        }
        if (value.getM_Sdt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getM_Sdt());
        }
      }
    };
    this.__deletionAdapterOfTaiKhoan = new EntityDeletionOrUpdateAdapter<TaiKhoan>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TaiKhoan` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaiKhoan value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTaiKhoan = new EntityDeletionOrUpdateAdapter<TaiKhoan>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TaiKhoan` SET `id` = ?,`m_TK` = ?,`m_Matkhau` = ?,`m_Ten` = ?,`m_Diachi` = ?,`m_Sdt` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaiKhoan value) {
        stmt.bindLong(1, value.getId());
        if (value.getM_TK() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getM_TK());
        }
        if (value.getM_Matkhau() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getM_Matkhau());
        }
        if (value.getM_Ten() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getM_Ten());
        }
        if (value.getM_Diachi() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getM_Diachi());
        }
        if (value.getM_Sdt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getM_Sdt());
        }
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public void insert(final TaiKhoan taiKhoan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTaiKhoan.insert(taiKhoan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TaiKhoan taiKhoan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaiKhoan.handle(taiKhoan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TaiKhoan taiKhoan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTaiKhoan.handle(taiKhoan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TaiKhoan> getAll() {
    final String _sql = "SELECT * FROM Taikhoan";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMTK = CursorUtil.getColumnIndexOrThrow(_cursor, "m_TK");
      final int _cursorIndexOfMMatkhau = CursorUtil.getColumnIndexOrThrow(_cursor, "m_Matkhau");
      final int _cursorIndexOfMTen = CursorUtil.getColumnIndexOrThrow(_cursor, "m_Ten");
      final int _cursorIndexOfMDiachi = CursorUtil.getColumnIndexOrThrow(_cursor, "m_Diachi");
      final int _cursorIndexOfMSdt = CursorUtil.getColumnIndexOrThrow(_cursor, "m_Sdt");
      final List<TaiKhoan> _result = new ArrayList<TaiKhoan>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaiKhoan _item;
        _item = new TaiKhoan();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpM_TK;
        if (_cursor.isNull(_cursorIndexOfMTK)) {
          _tmpM_TK = null;
        } else {
          _tmpM_TK = _cursor.getString(_cursorIndexOfMTK);
        }
        _item.setM_TK(_tmpM_TK);
        final String _tmpM_Matkhau;
        if (_cursor.isNull(_cursorIndexOfMMatkhau)) {
          _tmpM_Matkhau = null;
        } else {
          _tmpM_Matkhau = _cursor.getString(_cursorIndexOfMMatkhau);
        }
        _item.setM_Matkhau(_tmpM_Matkhau);
        final String _tmpM_Ten;
        if (_cursor.isNull(_cursorIndexOfMTen)) {
          _tmpM_Ten = null;
        } else {
          _tmpM_Ten = _cursor.getString(_cursorIndexOfMTen);
        }
        _item.setM_Ten(_tmpM_Ten);
        final String _tmpM_Diachi;
        if (_cursor.isNull(_cursorIndexOfMDiachi)) {
          _tmpM_Diachi = null;
        } else {
          _tmpM_Diachi = _cursor.getString(_cursorIndexOfMDiachi);
        }
        _item.setM_Diachi(_tmpM_Diachi);
        final String _tmpM_Sdt;
        if (_cursor.isNull(_cursorIndexOfMSdt)) {
          _tmpM_Sdt = null;
        } else {
          _tmpM_Sdt = _cursor.getString(_cursorIndexOfMSdt);
        }
        _item.setM_Sdt(_tmpM_Sdt);
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
