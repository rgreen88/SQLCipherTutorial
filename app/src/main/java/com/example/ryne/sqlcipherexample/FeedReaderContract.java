package com.example.ryne.sqlcipherexample;

import android.provider.BaseColumns;

/**
 * Created by Ryne on 1/9/2018.
 */

public final class FeedReaderContract {

    public FeedReaderContract(){} //empty construct

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_NAME_ENTRY_ID = "news_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
