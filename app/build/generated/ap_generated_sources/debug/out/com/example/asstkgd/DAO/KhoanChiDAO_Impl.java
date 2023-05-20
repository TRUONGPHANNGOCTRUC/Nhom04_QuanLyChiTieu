package com.example.asstkgd.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.asstkgd.Entity.KhoanChi;
import java.lang.Class;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class KhoanChiDAO_Impl implements KhoanChiDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KhoanChi> __insertionAdapterOfKhoanChi;

  private final EntityDeletionOrUpdateAdapter<KhoanChi> __deletionAdapterOfKhoanChi;

  private final EntityDeletionOrUpdateAdapter<KhoanChi> __updateAdapterOfKhoanChi;

  public KhoanChiDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKhoanChi = new EntityInsertionAdapter<KhoanChi>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `KhoanChi` (`id`,`tenLoai`,`tenKhoanChi`,`ngayThu`,`soTien`,`note`,`tenNguoiChi`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanChi value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
        if (value.getTenKhoanChi() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTenKhoanChi());
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
        if (value.getTenNguoiChi() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenNguoiChi());
        }
      }
    };
    this.__deletionAdapterOfKhoanChi = new EntityDeletionOrUpdateAdapter<KhoanChi>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `KhoanChi` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanChi value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfKhoanChi = new EntityDeletionOrUpdateAdapter<KhoanChi>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `KhoanChi` SET `id` = ?,`tenLoai` = ?,`tenKhoanChi` = ?,`ngayThu` = ?,`soTien` = ?,`note` = ?,`tenNguoiChi` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KhoanChi value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenLoai() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenLoai());
        }
        if (value.getTenKhoanChi() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTenKhoanChi());
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
        if (value.getTenNguoiChi() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenNguoiChi());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insert(final KhoanChi khoanChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfKhoanChi.insert(khoanChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final KhoanChi khoanChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfKhoanChi.handle(khoanChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final KhoanChi khoanChi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfKhoanChi.handle(khoanChi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<KhoanChi> getAll() {
    final String _sql = "SELECT * FROM KhoanChi";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenLoai = CursorUtil.getColumnIndexOrThrow(_cursor, "tenLoai");
      final int _cursorIndexOfTenKhoanChi = CursorUtil.getColumnIndexOrThrow(_cursor, "tenKhoanChi");
      final int _cursorIndexOfNgayThu = CursorUtil.getColumnIndexOrThrow(_cursor, "ngayThu");
      final int _cursorIndexOfSoTien = CursorUtil.getColumnIndexOrThrow(_cursor, "soTien");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfTenNguoiChi = CursorUtil.getColumnIndexOrThrow(_cursor, "tenNguoiChi");
      final List<KhoanChi> _result = new ArrayList<KhoanChi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KhoanChi _item;
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        final String _tmpTenKhoanChi;
        if (_cursor.isNull(_cursorIndexOfTenKhoanChi)) {
          _tmpTenKhoanChi = null;
        } else {
          _tmpTenKhoanChi = _cursor.getString(_cursorIndexOfTenKhoanChi);
        }
        final String _tmpNgayThu;
        if (_cursor.isNull(_cursorIndexOfNgayThu)) {
          _tmpNgayThu = null;
        } else {
          _tmpNgayThu = _cursor.getString(_cursorIndexOfNgayThu);
        }
        final String _tmpSoTien;
        if (_cursor.isNull(_cursorIndexOfSoTien)) {
          _tmpSoTien = null;
        } else {
          _tmpSoTien = _cursor.getString(_cursorIndexOfSoTien);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpTenNguoiChi;
        if (_cursor.isNull(_cursorIndexOfTenNguoiChi)) {
          _tmpTenNguoiChi = null;
        } else {
          _tmpTenNguoiChi = _cursor.getString(_cursorIndexOfTenNguoiChi);
        }
        _item = new KhoanChi(_tmpTenLoai,_tmpTenKhoanChi,_tmpNgayThu,_tmpSoTien,_tmpNote,_tmpTenNguoiChi);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<KhoanChi> thongKe(final String star, final String end) {
    final String _sql = "SELECT * FROM khoanchi where ngayThu between ? AND ?";
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
      final int _cursorIndexOfTenKhoanChi = CursorUtil.getColumnIndexOrThrow(_cursor, "tenKhoanChi");
      final int _cursorIndexOfNgayThu = CursorUtil.getColumnIndexOrThrow(_cursor, "ngayThu");
      final int _cursorIndexOfSoTien = CursorUtil.getColumnIndexOrThrow(_cursor, "soTien");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final int _cursorIndexOfTenNguoiChi = CursorUtil.getColumnIndexOrThrow(_cursor, "tenNguoiChi");
      final List<KhoanChi> _result = new ArrayList<KhoanChi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KhoanChi _item;
        final String _tmpTenLoai;
        if (_cursor.isNull(_cursorIndexOfTenLoai)) {
          _tmpTenLoai = null;
        } else {
          _tmpTenLoai = _cursor.getString(_cursorIndexOfTenLoai);
        }
        final String _tmpTenKhoanChi;
        if (_cursor.isNull(_cursorIndexOfTenKhoanChi)) {
          _tmpTenKhoanChi = null;
        } else {
          _tmpTenKhoanChi = _cursor.getString(_cursorIndexOfTenKhoanChi);
        }
        final String _tmpNgayThu;
        if (_cursor.isNull(_cursorIndexOfNgayThu)) {
          _tmpNgayThu = null;
        } else {
          _tmpNgayThu = _cursor.getString(_cursorIndexOfNgayThu);
        }
        final String _tmpSoTien;
        if (_cursor.isNull(_cursorIndexOfSoTien)) {
          _tmpSoTien = null;
        } else {
          _tmpSoTien = _cursor.getString(_cursorIndexOfSoTien);
        }
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        final String _tmpTenNguoiChi;
        if (_cursor.isNull(_cursorIndexOfTenNguoiChi)) {
          _tmpTenNguoiChi = null;
        } else {
          _tmpTenNguoiChi = _cursor.getString(_cursorIndexOfTenNguoiChi);
        }
        _item = new KhoanChi(_tmpTenLoai,_tmpTenKhoanChi,_tmpNgayThu,_tmpSoTien,_tmpNote,_tmpTenNguoiChi);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Double tongTienChi() {
    final String _sql = "SELECT sum(soTien) from khoanchi";
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
