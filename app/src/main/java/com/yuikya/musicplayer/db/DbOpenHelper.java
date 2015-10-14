package com.yuikya.musicplayer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fan on 2015/10/12.
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "player";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "tracks";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +" (id text," +
            "title text," +
            "path text," +
            "artist text," +
            "album_id text," +
            "album text," +
            "duration text," +
            "display_name text)";

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
