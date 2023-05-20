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
public final class KhoanChiDatabase_Impl extends KhoanChiDatabase {
  private volatile KhoanChiDAO _khoanChiDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KhoanChi` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tenLoai` TEXT, `tenKhoanChi` TEXT, `ngayThu` TEXT, `soTien` TEXT, `note` TEXT, `tenNguoiChi` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c2c0498240c1a65c2e6863e852115655')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `KhoanChi`");
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
        final HashMap<String, TableInfo.Column> _columnsKhoanChi = new HashMap<String, TableInfo.Column>(7);
        _columnsKhoanChi.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("tenLoai", new TableInfo.Column("tenLoai", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("tenKhoanChi", new TableInfo.Column("tenKhoanChi", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("ngayThu", new TableInfo.Column("ngayThu", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("soTien", new TableInfo.Column("soTien", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanChi.put("tenNguoiChi", new TableInfo.Column("tenNguoiChi", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKhoanChi = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKhoanChi = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKhoanChi = new TableInfo("KhoanChi", _columnsKhoanChi, _foreignKeysKhoanChi, _indicesKhoanChi);
        final TableInfo _existingKhoanChi = TableInfo.read(_db, "KhoanChi");
        if (! _infoKhoanChi.equals(_existingKhoanChi)) {
          return new RoomOpenHelper.ValidationResult(false, "KhoanChi(com.example.asstkgd.Entity.KhoanChi).\n"
                  + " Expected:\n" + _infoKhoanChi + "\n"
                  + " Found:\n" + _existingKhoanChi);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c2c0498240c1a65c2e6863e852115655", "b095eb7631d1bf685aaabcdd5b3e7b00");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "KhoanChi");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `KhoanChi`");
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
    _typeConvertersMap.put(KhoanChiDAO.class, KhoanChiDAO_Impl.getRequiredConverters());
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
  public KhoanChiDAO khoanChiDAO() {
    if (_khoanChiDAO != null) {
      return _khoanChiDAO;
    } else {
      synchronized(this) {
        if(_khoanChiDAO == null) {
          _khoanChiDAO = new KhoanChiDAO_Impl(this);
        }
        return _khoanChiDAO;
      }
    }
  }
}
