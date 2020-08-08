package com.example.projecttester;

import java.util.ArrayList;

import com.example.projecttester.Adapters.DataEntity;
import com.example.projecttester.Adapters.DataEntity2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class DataBaseHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = Environment
			.getExternalStorageDirectory() + "/CleanAjmer/db_ajmer.db";
	public static final String TABLE_ADMIN = "admin";
	public static final String TABLE_CATEGORY = "category";
	public static final String TABLE_DATA = "data2";
	public static final String TABLE_Clean_Ajmer1 = "clean_ajmer4";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 9); // TODO Auto-generated
												// constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL("create table "
				+ TABLE_ADMIN
				+ " (id integer primary key AUTOINCREMENT NOT NULL, name text, password text)");
		db.execSQL("create table "
				+ TABLE_CATEGORY
				+ " (id integer primary key AUTOINCREMENT NOT NULL, categoryname text)");
		db.execSQL("create table "
				+ TABLE_DATA
				+ " (id integer primary key AUTOINCREMENT NOT NULL,name text, address text, contact text, email text,  password text )");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("create table "
				+ TABLE_Clean_Ajmer1
				+ " (id integer primary key AUTOINCREMENT NOT NULL,name text, address text, contact text, email text,  ward text,  complaint text,image text)");

	}

	public boolean insertAdmin() {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("name", "admin");
		values.put("password", "password");

		Cursor cursor = db.rawQuery("select * from " + TABLE_ADMIN, null);
		if (cursor != null)
			cursor.moveToFirst();
		if (!cursor.moveToFirst()) {
			db.insert(TABLE_ADMIN, null, values);
		}
		return true;
	}

	public boolean insertCategory(String category) {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("categoryname", category);

			db.insert(TABLE_CATEGORY, null, values);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertData(DataEntity de) {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", de.getName());
			values.put("address", de.getAddress());
			values.put("contact", de.getContact());
			values.put("email", de.getEmail());
			values.put("password", de.getPassword());
			db.insert(TABLE_DATA, null, values);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertComplaint(DataEntity2 de) {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", de.getName());
			values.put("address", de.getAddress());
			values.put("contact", de.getContact());
			values.put("email", de.getEmail());
			values.put("ward", de.getWard());
			values.put("complaint", de.getComplaint());
			values.put("image", de.getImagePath());

			db.insert(TABLE_Clean_Ajmer1, null, values);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean getUserPassword(String username, String password) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(
				"select * from data2 where contact=? and password=?",
				new String[] { username, password });
		if (c.moveToFirst()) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean getAdminPassword(String username, String password) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(
				"select * from admin where name=? and password=?",
				new String[] { username, password });
		if (c.moveToFirst()) {
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<String> getAllCategory() {
		ArrayList<String> category_list = new ArrayList<String>();

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from " + TABLE_CATEGORY, null);
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				category_list.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}
		return category_list;
	}

	public String getAllResult(String id) {
		String image = null;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from " + TABLE_Clean_Ajmer1
				+ " where id=?", new String[] { id });
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				image = cursor.getString(7);
			} while (cursor.moveToNext());
		}
		return image;
	}

	public ArrayList<String> getSearchResult(String id) {
		ArrayList<String> data = null;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from " + TABLE_Clean_Ajmer1
				+ " where id=?", new String[] { id });
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				data.add(cursor.getString(0));
				data.add(cursor.getString(1));
				data.add(cursor.getString(2));
				data.add(cursor.getString(3));
				data.add(cursor.getString(4));
				data.add(cursor.getString(5));
				data.add(cursor.getString(6));
				data.add(cursor.getString(7));
				
			} while (cursor.moveToNext());
		}
		return data;
	}

}