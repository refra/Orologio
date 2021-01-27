package com.example.orologio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "Tempi Salvati";
    private static final String TABLE_TEMPI= "tempi";
    private static final String KEY_ID= "id";
    private static final String KEY_TEMPO= "tempo";
    private static final String[] COLUMNS={KEY_ID,KEY_TEMPO};
    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEMPI_TABLE = "CREATE TABLE tempi ( "+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "tempo TEXT )";
        db.execSQL(CREATE_TEMPI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tempi");
        this.onCreate(db);
    }

    public List<Tempi> getAllTempi(){
        List<Tempi> tempi= new LinkedList<Tempi>();
        String query= "SELECT * FROM " + TABLE_TEMPI;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query, null);

        Tempi temp=null;
        if(cursor.moveToFirst()){
            do{
                temp=new Tempi();
                temp.setId(Integer.parseInt(cursor.getString(0)));
                temp.setTempo(cursor.getString(1));
                tempi.add(temp);
            }while(cursor.moveToNext());
        }
        return tempi;
    }

    public void addTempo(String t){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEMPO, t);
        db.insert(TABLE_TEMPI, null, values);
        db.close();
    }

}
