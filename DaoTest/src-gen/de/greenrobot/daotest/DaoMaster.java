package de.greenrobot.daotest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.database.AndroidSQLiteDatabase;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import de.greenrobot.daotest.SimpleEntityDao;
import de.greenrobot.daotest.SimpleEntityNotNullDao;
import de.greenrobot.daotest.TestEntityDao;
import de.greenrobot.daotest.RelationEntityDao;
import de.greenrobot.daotest.DateEntityDao;
import de.greenrobot.daotest.SpecialNamesEntityDao;
import de.greenrobot.daotest.AbcdefEntityDao;
import de.greenrobot.daotest.ToManyTargetEntityDao;
import de.greenrobot.daotest.ToManyEntityDao;
import de.greenrobot.daotest.JoinManyToDateEntityDao;
import de.greenrobot.daotest.TreeEntityDao;
import de.greenrobot.daotest.AnActiveEntityDao;
import de.greenrobot.daotest.ExtendsImplementsEntityDao;
import de.greenrobot.daotest.StringKeyValueEntityDao;
import de.greenrobot.daotest.AutoincrementEntityDao;
import de.greenrobot.daotest.SqliteMasterDao;
import de.greenrobot.daotest.CustomTypeEntityDao;
import de.greenrobot.daotest.IndexedStringEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(Database db, boolean ifNotExists) {
        SimpleEntityDao.createTable(db, ifNotExists);
        SimpleEntityNotNullDao.createTable(db, ifNotExists);
        TestEntityDao.createTable(db, ifNotExists);
        RelationEntityDao.createTable(db, ifNotExists);
        DateEntityDao.createTable(db, ifNotExists);
        SpecialNamesEntityDao.createTable(db, ifNotExists);
        AbcdefEntityDao.createTable(db, ifNotExists);
        ToManyTargetEntityDao.createTable(db, ifNotExists);
        ToManyEntityDao.createTable(db, ifNotExists);
        JoinManyToDateEntityDao.createTable(db, ifNotExists);
        TreeEntityDao.createTable(db, ifNotExists);
        AnActiveEntityDao.createTable(db, ifNotExists);
        ExtendsImplementsEntityDao.createTable(db, ifNotExists);
        StringKeyValueEntityDao.createTable(db, ifNotExists);
        AutoincrementEntityDao.createTable(db, ifNotExists);
        CustomTypeEntityDao.createTable(db, ifNotExists);
        IndexedStringEntityDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(Database db, boolean ifExists) {
        SimpleEntityDao.dropTable(db, ifExists);
        SimpleEntityNotNullDao.dropTable(db, ifExists);
        TestEntityDao.dropTable(db, ifExists);
        RelationEntityDao.dropTable(db, ifExists);
        DateEntityDao.dropTable(db, ifExists);
        SpecialNamesEntityDao.dropTable(db, ifExists);
        AbcdefEntityDao.dropTable(db, ifExists);
        ToManyTargetEntityDao.dropTable(db, ifExists);
        ToManyEntityDao.dropTable(db, ifExists);
        JoinManyToDateEntityDao.dropTable(db, ifExists);
        TreeEntityDao.dropTable(db, ifExists);
        AnActiveEntityDao.dropTable(db, ifExists);
        ExtendsImplementsEntityDao.dropTable(db, ifExists);
        StringKeyValueEntityDao.dropTable(db, ifExists);
        AutoincrementEntityDao.dropTable(db, ifExists);
        CustomTypeEntityDao.dropTable(db, ifExists);
        IndexedStringEntityDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(new AndroidSQLiteDatabase(db), false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(new AndroidSQLiteDatabase(db), true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        this(new AndroidSQLiteDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(SimpleEntityDao.class);
        registerDaoClass(SimpleEntityNotNullDao.class);
        registerDaoClass(TestEntityDao.class);
        registerDaoClass(RelationEntityDao.class);
        registerDaoClass(DateEntityDao.class);
        registerDaoClass(SpecialNamesEntityDao.class);
        registerDaoClass(AbcdefEntityDao.class);
        registerDaoClass(ToManyTargetEntityDao.class);
        registerDaoClass(ToManyEntityDao.class);
        registerDaoClass(JoinManyToDateEntityDao.class);
        registerDaoClass(TreeEntityDao.class);
        registerDaoClass(AnActiveEntityDao.class);
        registerDaoClass(ExtendsImplementsEntityDao.class);
        registerDaoClass(StringKeyValueEntityDao.class);
        registerDaoClass(AutoincrementEntityDao.class);
        registerDaoClass(SqliteMasterDao.class);
        registerDaoClass(CustomTypeEntityDao.class);
        registerDaoClass(IndexedStringEntityDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
