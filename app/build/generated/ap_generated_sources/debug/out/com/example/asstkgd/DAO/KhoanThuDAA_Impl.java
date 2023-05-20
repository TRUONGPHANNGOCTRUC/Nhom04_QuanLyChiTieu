package com.example.asstkgd.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.asstkgd.Entity.KhoanThu;
import java.lang.Class;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class KhoanThuDAA_Impl implements KhoanThuDAA {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KhoanThu> __insertionAdapterOfKhoanThu;

  private final EntityDeletionOrUpdateAdapter<KhoanThu> __deletionAdapterOfKhoanThu;

  private final EntityDeletionOrUpdateAdapter<KhoanThu> __updateAdapterOfKhoanThu;

  public KhoanThuDAA_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKhoanThu = new EntityInsertionAdapter<KhoanThu>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `KhoanThu` (`id`,`tenLoai`,`tenKhoanThu`,`ngayThu`,`soTien`,`note`,`tenNguoiThu`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanThu value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
        if (value.getTenKhoanThu() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTenKhoanThu());
        }
        if (value.getNgayThu() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNgayThu());
        }
        if (value.getSoTien() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSoTien());
        }
        if (value.getNote() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNote());
        }
        if (value.getTenNguoiThu() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenNguoiThu());
        }
      }
    };
    this.__deletionAdapterOfKhoanThu = new EntityDeletionOrUpdateAdapter<KhoanThu>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `KhoanThu` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanThu value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfKhoanThu = new EntityDeletionOrUpdateAdapter<KhoanThu>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `KhoanThu` SET `id` = ?,`tenLoai` = ?,`tenKhoanThu` = ?,`ngayThu` = ?,`soTien` = ?,`note` = ?,`tenNguoiThu` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanThu value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
        if (value.getTenKhoanThu() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTenKhoanThu());
        }
        if (value.getNgayThu() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNgayThu());
        }
        if (value.getSoTien() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSoTien());
        }
        if (value.getNote() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNote());
        }
        if (value.getTenNguoiThu() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenNguoiThu());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insertKhoanThu(final KhoanThu khoanThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfKhoanThu.insert(khoanThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final KhoanThu khoanThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfKhoanThu.handle(khoanThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateKhoanThu(final KhoanThu khoanThu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfKhoanThu.handle(khoanThu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<KhoanThu> getAll() {
    final String _sql = "SELECT * FROM KhoanThu";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "tenLoai");
      final int _cursorIndexOfTenKhoanThu = CursorUtil.getColumnIndexOrThrow(_cursor, "tenKhoanThu");
      final int _cursorIndexOfNgayThu = CursorUtil.getColumnIndexOrThrow(_cursor, "ngayThu");
      final int _cursorIndexOfSoTien = CursorUtil.getColumnIndexOrThrow(_cursor, "soTien");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfTenNguoiThu = CursorUtil.getColumnIndexOrThrow(_cursor, "tenNguoiThu");
      final List<KhoanThu> _result = new ArrayList<KhoanThu>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KhoanThu _item;
        _item = new KhoanThu();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        _item.setTenLoai(_tmpTenLoai);
        final String _tmpTenKhoanThu;
        if (_cursor.isNull(_cursorIndexOfTenKhoanThu)) {
          _tmpTenKhoanThu = null;
        } else {
          _tmpTenKhoanThu = _cursor.getString(_cursorIndexOfTenKhoanThu);
        }
        _item.setTenKhoanThu(_tmpTenKhoanThu);
        final String _tmpNgayThu;
        if (_cursor.isNull(_cursorIndexOfNgayThu)) {
          _tmpNgayThu = null;
        } else {
          _tmpNgayThu = _cursor.getString(_cursorIndexOfNgayThu);
        }
        _item.setNgayThu(_tmpNgayThu);
        final String _tmpSoTien;
        if (_cursor.isNull(_cursorIndexOfSoTien)) {
          _tmpSoTien = null;
        } else {
          _tmpSoTien = _cursor.getString(_cursorIndexOfSoTien);
        }
        _item.setSoTien(_tmpSoTien);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item.setNote(_tmpNote);
        final String _tmpTenNguoiThu;
        if (_cursor.isNull(_cursorIndexOfTenNguoiThu)) {
          _tmpTenNguoiThu = null;
        } else {
          _tmpTenNguoiThu = _cursor.getString(_cursorIndexOfTenNguoiThu);
        }
        _item.setTenNguoiThu(_tmpTenNguoiThu);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<KhoanThu> getThongKe(final String star, final String end) {
    final String _sql = "SELECT * FROM KhoanThu where ngayThu between ? and ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (star == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, star);
    }
    _argIndex = 2;
    if (end == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, end);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "tenLoai");
      final int _cursorIndexOfTenKhoanThu = CursorUtil.getColumnIndexOrThrow(_cursor, "tenKhoanThu");
      final int _cursorIndexOfNgayThu = CursorUtil.getColumnIndexOrThrow(_cursor, "ngayThu");
      final int _cursorIndexOfSoTien = CursorUtil.getColumnIndexOrThrow(_cursor, "soTien");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfTenNguoiThu = CursorUtil.getColumnIndexOrThrow(_cursor, "tenNguoiThu");
      final List<KhoanThu> _result = new ArrayList<KhoanThu>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KhoanThu _item;
        _item = new KhoanThu();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        _item.setTenLoai(_tmpTenLoai);
        final String _tmpTenKhoanThu;
        if (_cursor.isNull(_cursorIndexOfTenKhoanThu)) {
          _tmpTenKhoanThu = null;
        } else {
          _tmpTenKhoanThu = _cursor.getString(_cursorIndexOfTenKhoanThu);
        }
        _item.setTenKhoanThu(_tmpTenKhoanThu);
        final String _tmpNgayThu;
        if (_cursor.isNull(_cursorIndexOfNgayThu)) {
          _tmpNgayThu = null;
        } else {
          _tmpNgayThu = _cursor.getString(_cursorIndexOfNgayThu);
        }
        _item.setNgayThu(_tmpNgayThu);
        final String _tmpSoTien;
        if (_cursor.isNull(_cursorIndexOfSoTien)) {
          _tmpSoTien = null;
        } else {
          _tmpSoTien = _cursor.getString(_cursorIndexOfSoTien);
        }
        _item.setSoTien(_tmpSoTien);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item.setNote(_tmpNote);
        final String _tmpTenNguoiThu;
        if (_cursor.isNull(_cursorIndexOfTenNguoiThu)) {
          _tmpTenNguoiThu = null;
        } else {
          _tmpTenNguoiThu = _cursor.getString(_cursorIndexOfTenNguoiThu);
        }
        _item.setTenNguoiThu(_tmpTenNguoiThu);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Double tongTienThu() {
    final String _sql = "SELECT sum(soTien) from KhoanThu";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Double _result;
      if(_cursor.moveToFirst()) {
        final Double _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getDouble(0);
        }
        _result = _tmp;
      } else {
        _result = null;
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
