package com.example.ryne.sqlcipherexample;

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


    }
}
