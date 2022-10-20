package com.example.moviegetter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {

    DBHelper helper;
    SQLiteDatabase db;
    List<Movies> movieList = new ArrayList<>();

    public DBAdapter(Context ctx) {
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public List<Movies> getAllMovies(){
        String columns[] = {DBHelper.KEY_ROWID, DBHelper.KEY_YEAR, DBHelper.KEY_TITLE, DBHelper.KEY_DESCRIPTION};
        Cursor cursor = db.query(DBHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        while(cursor.moveToNext()){
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ROWID);
            int rowID = cursor.getInt(idIndex);

            int yearIndex = cursor.getColumnIndex(DBHelper.KEY_YEAR);
            int year = cursor.getInt(yearIndex);

            int titleIndex = cursor.getColumnIndex(DBHelper.KEY_TITLE);
            String title = cursor.getString(titleIndex);

            int descriptionIndex = cursor.getColumnIndex(DBHelper.KEY_DESCRIPTION);
            String description = cursor.getString(descriptionIndex);

            Movies movie = new Movies(rowID, year, title, description);
            movieList.add(movie);
        }
        return movieList;
    }

    private static class DBHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "movies.db";
        private static final String TABLE_NAME = "movies";
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_ROWID = "id";
        private static final String KEY_TITLE="title";
        private static final String KEY_YEAR = "year";
        private static final String KEY_DESCRIPTION = "description";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+ " ("+ KEY_ROWID+" integer primary key, "+ KEY_YEAR + " year, "+ KEY_TITLE + " title, "+ KEY_DESCRIPTION+ " desription)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try{
                sqLiteDatabase.execSQL(CREATE_TABLE);
                Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try{
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
                Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

