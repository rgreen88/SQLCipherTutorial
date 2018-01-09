package com.example.ryne.sqlcipherexample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


    }
}
