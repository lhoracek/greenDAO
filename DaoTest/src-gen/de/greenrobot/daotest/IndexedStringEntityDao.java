package de.greenrobot.daotest;

import android.database.Cursor;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.database.Database;
import de.greenrobot.dao.database.DatabaseStatement;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daotest.IndexedStringEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "INDEXED_STRING_ENTITY".
*/
public class IndexedStringEntityDao extends AbstractDao<IndexedStringEntity, Long> {

    public static final String TABLENAME = "INDEXED_STRING_ENTITY";

    /**
     * Properties of entity IndexedStringEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IndexedString = new Property(1, String.class, "indexedString", false, "INDEXED_STRING");
    };


    public IndexedStringEntityDao(DaoConfig config) {
        super(config);
    }
    
    public IndexedStringEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"INDEXED_STRING_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"INDEXED_STRING\" TEXT);"); // 1: indexedString
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_INDEXED_STRING_ENTITY_INDEXED_STRING ON INDEXED_STRING_ENTITY" +
                " (\"INDEXED_STRING\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INDEXED_STRING_ENTITY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(DatabaseStatement stmt, IndexedStringEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String indexedString = entity.getIndexedString();
        if (indexedString != null) {
            stmt.bindString(2, indexedString);
        }
    }

    /** @inheritdoc */

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */

    public IndexedStringEntity readEntity(Cursor cursor, int offset) {
        IndexedStringEntity entity = new IndexedStringEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // indexedString
        );
        return entity;
    }
     
    /** @inheritdoc */

    public void readEntity(Cursor cursor, IndexedStringEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIndexedString(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(IndexedStringEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(IndexedStringEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
