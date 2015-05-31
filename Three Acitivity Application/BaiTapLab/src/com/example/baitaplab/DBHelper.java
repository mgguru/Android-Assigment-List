package com.example.baitaplab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	public static String DB_PATH = "/data/data/com.example.baitaplab/databases/";
	public static String DB_NAME = "Student.sqlite";
	public static final int DB_VERSION = 2;	
	public static final String TB_USER = "Student";
	
	private SQLiteDatabase myDB;
	private Context context;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);	
		this.context = context;
	}
	
	@Override
	public synchronized void close(){
		if(myDB!=null){
			myDB.close();
		}
		super.close();
	}
	
	private boolean checkDataBase() {
		SQLiteDatabase tempDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			tempDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
		} catch (SQLiteException e) {
			Log.e("check", e.getMessage());
		}
		if (tempDB != null)
			tempDB.close();
		return tempDB != null ? true : false;
	}
	
	public void openDataBase() throws SQLException{
		String myPath = DB_PATH + DB_NAME;
		myDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
	}
	
	public void copyDataBase() throws IOException{
		try {
			InputStream myInput = context.getAssets().open(DB_NAME);
			String outputFileName = DB_PATH + DB_NAME;
			OutputStream myOutput = new FileOutputStream(outputFileName);

			byte[] buffer = new byte[1024];
			int length;

			while((length = myInput.read(buffer))>0){
				myOutput.write(buffer, 0, length);
			}

			myOutput.flush();
			myOutput.close();
			myInput.close();
		} catch (Exception e) {
			Log.e("copyDatabase", e.getMessage());
		}	
	}
	
	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();		
		
		if (dbExist) {

		} else {
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				Log.e("create", e.getMessage());
			}
		}
}

	public ArrayList<String> getAllUsers(){
		ArrayList<String> listUsers = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c;		
		try {
			c = db.rawQuery("SELECT * FROM " + TB_USER , null);
			if(c == null) return null;			
			c.moveToFirst();
			do {		
				Student std = new Student();
				std.setMSSV(c.getString(0));
				std.setHoTen(c.getString(1));
				std.setDiem(c.getInt(2));				
				listUsers.add(std.toString());
			} while (c.moveToNext()); 
			c.close();
		} catch (Exception e) {
			Log.e("", e.getMessage());
		}	
		
		db.close();		
		
		return listUsers;
	}
	
	public void insert(Student s) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("MSSV", s.getMSSV());
		values.put("HoTen", s.getHoTen());
		values.put("Diem", s.getDiem());
		db.insert("Student", null, values);
		db.close();
	}
	
	public int delete(String MSSV) {
		int result = 0;
		SQLiteDatabase db = getWritableDatabase();
		result = db.delete("Student", "MSSV=?", new String[] { MSSV });
		db.close();
		return result;
	}
	
	public Student getStudentByID(String id) {
		SQLiteDatabase db = getWritableDatabase();
		Cursor cur = db.query("Student",
				new String[] { "MSSV", "HoTen", "Diem" }, "MSSV=?",
				new String[] { id }, null, null, null);
		if (cur.moveToNext()) {
			Student std = new Student();
			std.setMSSV(cur.getString(0));
			std.setHoTen(cur.getString(1));
			std.setDiem(cur.getInt(2));
			return std;
		}else{
			
			return null;
		}
	}
	
	public int update(Student std) {
		int result = 0;
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("HoTen", std.getHoTen());
		values.put("Diem", std.getDiem());
		result = db.update("Student", values, "MSSV=?",
				new String[] { std.getMSSV() });
		db.close();
		return result;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
