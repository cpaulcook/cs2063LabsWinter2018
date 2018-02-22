package mobiledev.unb.ca.trydb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "mytable";
    final static String _ID = "_id";
    public static final String ITEM = "item";
    public static final String NUM = "number";
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ITEM + " TEXT, " +
                    NUM + " INT);";
    private static final String TAG = "DBHelper";
    private static final String DATABASE_NAME = "mydb";
    final static String[] COLUMNS = { _ID, ITEM, NUM };

    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade");
    }


}
