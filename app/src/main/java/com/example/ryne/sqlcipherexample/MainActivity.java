package com.example.ryne.sqlcipherexample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertSthToDb();

    }

    private void insertSthToDb(){

        //loading before database creation
        SQLiteDatabase.loadLibs(this);

        //creating writable content to db and associating ContentValues values to populate
        //the SQLite database that was created
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(this).getWritableDatabase("somePass");

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, 1); //int parameter
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "Easter Bunny has escaped!");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE,
                "A thrilling story which proves how fragile our hearts are...");

        //inserting above values into db
        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

        //Selecting query using Cursor class and using log.d to check if access from query was made
        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.FeedEntry.TABLE_NAME + "';", null);
        Log.d(MainActivity.class.getSimpleName(), "Rows count: " + cursor.getCount());
        cursor.close();//to prevent mem leak since it isn't being used...likewise with db
        db.close();
    }
}
