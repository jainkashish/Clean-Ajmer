package com.example.projecttester;

import java.util.ArrayList;

import com.example.projecttester.Adapters.CustomViewComplaintAdapter;
import com.example.projecttester.Adapters.CustomViewUserAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ListView;

public class ViewAllUser extends Activity {
	ListView lv;
	ArrayList<String> id, name, address, contact, email, password;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_all_user);id = new ArrayList<String>();
		name = new ArrayList<String>();
		address = new ArrayList<String>();
		contact = new ArrayList<String>();
		email = new ArrayList<String>();
		password = new ArrayList<String>();
		lv = (ListView) findViewById(R.id.listView1);
		DataBaseHelper dh = new DataBaseHelper(this);
		SQLiteDatabase db = dh.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from  data2 ", null);
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				id.add(cursor.getString(0));
				name.add(cursor.getString(1));
				address.add(cursor.getString(2));
				contact.add(cursor.getString(3));
				email.add(cursor.getString(4));
				password.add(cursor.getString(5));
				
			} while (cursor.moveToNext());
		}
		
		CustomViewUserAdapter c = new CustomViewUserAdapter(this,
				R.layout.view_all_users, id, name, address, contact, email,password);
		lv.setAdapter(c);
		

	}

}
