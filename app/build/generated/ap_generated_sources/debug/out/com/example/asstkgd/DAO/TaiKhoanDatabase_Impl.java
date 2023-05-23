package com.example.asstkgd.DAO;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaiKhoanDatabase_Impl extends TaiKhoanDatabase {
  private volatile TaiKhoanDAO _taiKhoanDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TaiKhoan` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `m_TK` TEXT, `m_Matkhau` TEXT, `m_Ten` TEXT, `m_Diachi` TEXT, `m_Sdt` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '50554b6de3acacaaa6f29650601a633f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TaiKhoan`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTaiKhoan = new HashMap<String, TableInfo.Column>(6);
        _columnsTaiKhoan.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaiKhoan.put("m_TK", new TableInfo.Column("m_TK", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaiKhoan.put("m_Matkhau", new TableInfo.Column("m_Matkhau", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaiKhoan.put("m_Ten", new TableInfo.Column("m_Ten", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaiKhoan.put("m_Diachi", new TableInfo.Column("m_Diachi", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaiKhoan.put("m_Sdt", new TableInfo.Column("m_Sdt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTaiKhoan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTaiKhoan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTaiKhoan = new TableInfo("TaiKhoan", _columnsTaiKhoan, _foreignKeysTaiKhoan, _indicesTaiKhoan);
        final TableInfo _existingTaiKhoan = TableInfo.read(_db, "TaiKhoan");
        if (! _infoTaiKhoan.equals(_existingTaiKhoan)) {
          return new RoomOpenHelper.ValidationResult(false, "TaiKhoan(com.example.asstkgd.Database.TaiKhoan).\n"
                  + " Expected:\n" + _infoTaiKhoan + "\n"
                  + " Found:\n" + _existingTaiKhoan);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "50554b6de3acacaaa6f29650601a633f", "9f280840cf8cf2fd48dcbd75f6108da8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "TaiKhoan");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `TaiKhoan`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TaiKhoanDAO.class, TaiKhoanDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public TaiKhoanDAO taiKhoanDAO() {
    if (_taiKhoanDAO != null) {
      return _taiKhoanDAO;
    } else {
      synchronized(this) {
        if(_taiKhoanDAO == null) {
          _taiKhoanDAO = new TaiKhoanDAO_Impl(this);
        }
        return _taiKhoanDAO;
      }
    }
  }
}
