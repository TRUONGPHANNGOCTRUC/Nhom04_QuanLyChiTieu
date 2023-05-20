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
public final class KhoanThuDatabase_Impl extends KhoanThuDatabase {
  private volatile KhoanThuDAA _khoanThuDAA;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KhoanThu` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tenLoai` TEXT, `tenKhoanThu` TEXT, `ngayThu` TEXT, `soTien` TEXT, `note` TEXT, `tenNguoiThu` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4fbb7da03ee0ae0019f3af8d9cc1f585')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `KhoanThu`");
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
        final HashMap<String, TableInfo.Column> _columnsKhoanThu = new HashMap<String, TableInfo.Column>(7);
        _columnsKhoanThu.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("tenLoai", new TableInfo.Column("tenLoai", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("tenKhoanThu", new TableInfo.Column("tenKhoanThu", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("ngayThu", new TableInfo.Column("ngayThu", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("soTien", new TableInfo.Column("soTien", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKhoanThu.put("tenNguoiThu", new TableInfo.Column("tenNguoiThu", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKhoanThu = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKhoanThu = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKhoanThu = new TableInfo("KhoanThu", _columnsKhoanThu, _foreignKeysKhoanThu, _indicesKhoanThu);
        final TableInfo _existingKhoanThu = TableInfo.read(_db, "KhoanThu");
        if (! _infoKhoanThu.equals(_existingKhoanThu)) {
          return new RoomOpenHelper.ValidationResult(false, "KhoanThu(com.example.asstkgd.Entity.KhoanThu).\n"
                  + " Expected:\n" + _infoKhoanThu + "\n"
                  + " Found:\n" + _existingKhoanThu);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4fbb7da03ee0ae0019f3af8d9cc1f585", "e1b57a34344cbe522a3b77eeb260a18d");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "KhoanThu");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `KhoanThu`");
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
    _typeConvertersMap.put(KhoanThuDAA.class, KhoanThuDAA_Impl.getRequiredConverters());
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
  public KhoanThuDAA khoanThuDAA() {
    if (_khoanThuDAA != null) {
      return _khoanThuDAA;
    } else {
      synchronized(this) {
        if(_khoanThuDAA == null) {
          _khoanThuDAA = new KhoanThuDAA_Impl(this);
        }
        return _khoanThuDAA;
      }
    }
  }
}
