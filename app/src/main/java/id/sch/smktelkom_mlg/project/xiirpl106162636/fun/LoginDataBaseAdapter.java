package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

/**
 * Created by Fadwa on 11/8/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_NAME = "DB_Fun";
    static final int DATABASE_VERSION = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table " + "User" +
            "( " + "ID" + " integer primary key autoincrement," + "Username string,Password text); ";
    // Context of the application using the database.
    private final Context context;
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public LoginDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String username, String password) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("Username", username);
        newValues.put("Password", password);

        // Insert the row into your table
        db.insert("User", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }


    int deleteEntry(String Username) {
        //String id=String.valueOf(ID);
        String where = "Username=?";

        int numberOFEntriesDeleted = db.delete("User", where, new String[]{Username});
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public void delete() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + "User");
    }

    public String getSinlgeEntry(String username) {
        Cursor cursor = db.query("User", null, " Username=?", new String[]{username}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "Not Exist";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("Password"));
        cursor.close();
        return password;
    }

    public void updateEntry(String username, String password) {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("Username", username);
        updatedValues.put("Password", password);

        String where = "Username = ?";
        db.update("User", updatedValues, where, new String[]{username});
    }

}
