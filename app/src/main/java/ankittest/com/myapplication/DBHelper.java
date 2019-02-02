package ankittest.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "temp.db";
    public static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FormTable.DB_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void insertDetails(FormPOJO formPOJO)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();

        contentValues.put(FormTable.COL_NAME,formPOJO.getCOL_NAME());
        contentValues.put(FormTable.COL_MAIl,formPOJO.getCOL_MAIl());
        contentValues.put(FormTable.COL_PWD,formPOJO.getCOL_PWD());
        contentValues.put(FormTable.COL_ABOUT,formPOJO.getCOL_ABOUT());
        contentValues.put(FormTable.COL_GENDER,formPOJO.getCOL_GENDER());

        long i = db.insert(FormTable.TABLE_FORM,null,contentValues);
        System.out.println(i);

    }


    public FormPOJO getData() {

        SQLiteDatabase db = this.getWritableDatabase();


        FormPOJO formPOJO = new FormPOJO();
        Cursor cursor = db.query(FormTable.TABLE_FORM,null,null,null,null,null,null);

        if(cursor != null )
        {
            while (cursor.moveToNext())
            {
                formPOJO.setCOL_NAME(cursor.getString(cursor.getColumnIndex(FormTable.COL_NAME)));
                formPOJO.setCOL_MAIl(cursor.getString(cursor.getColumnIndex(FormTable.COL_MAIl)));
                formPOJO.setCOL_PWD(cursor.getString(cursor.getColumnIndex(FormTable.COL_PWD)));
                formPOJO.setCOL_ABOUT(cursor.getString(cursor.getColumnIndex(FormTable.COL_ABOUT)));
                formPOJO.setCOL_GENDER(cursor.getString(cursor.getColumnIndex(FormTable.COL_GENDER)));
            }
        }


            return formPOJO;

    }
}
