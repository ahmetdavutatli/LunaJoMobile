package com.example.lunajomobile;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LunaJoDB";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE_USERS = "users";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USERTYPE = "usertype"; // "designer" or "manufacturer"

    // Table create statements
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + KEY_USERNAME + " TEXT,"
                    + KEY_PASSWORD + " TEXT,"
                    + KEY_USERTYPE + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create new tables
        onCreate(db);
    }

    // CRUD operations for users

    // Adding new user
    public long addUser(String username, String password, String userType) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_USERTYPE, userType);

        // Inserting Row
        long id = db.insert(TABLE_USERS, null, values);
        db.close();
        return id;
    }

    // Getting user by username and password
    @SuppressLint("Range")
    public User getUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS,
                new String[]{KEY_ID, KEY_USERNAME, KEY_PASSWORD, KEY_USERTYPE},
                KEY_USERNAME + "=? AND " + KEY_PASSWORD + "=?",
                new String[]{username, password}, null, null, null, null);

        User user = null;

        if (cursor != null && cursor.moveToFirst()) {
            user = new User(
                    cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(KEY_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)),
                    cursor.getString(cursor.getColumnIndex(KEY_USERTYPE))
            );
            cursor.close();
        }

        db.close();
        return user;
    }
}