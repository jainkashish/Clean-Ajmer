package com.example.projecttester;

import java.util.ArrayList;

import com.example.projecttester.Adapters.CustomViewComplaintAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ViewAllComplainsActivity extends Activity {
	ListView lv;
	ArrayList<String> id, name, address, contact, email, ward, complaint,
			image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_all_details);
		id = new ArrayList<String>();
		name = new ArrayList<String>();
		address = new ArrayList<String>();
		contact = new ArrayList<String>();
		email = new ArrayList<String>();
		ward = new ArrayList<String>();
		complaint = new ArrayList<String>();
		image = new ArrayList<String>();
		lv = (ListView) findViewById(R.id.listView1);
		DataBaseHelper dh = new DataBaseHelper(this);
		SQLiteDatabase db = dh.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from  clean_ajmer4 ", null);
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				id.add(cursor.getString(0));
				name.add(cursor.getString(1));
				address.add(cursor.getString(2));
				contact.add(cursor.getString(3));
				email.add(cursor.getString(4));
				ward.add(cursor.getString(5));
				complaint.add(cursor.getString(6));
				image.add(cursor.getString(7));

			} while (cursor.moveToNext());
		}
		CustomViewComplaintAdapter c = new CustomViewComplaintAdapter(this,
				R.layout.activity_view_all_complains, id, name, address, contact, email, ward, complaint,
				image);
		lv.setAdapter(c);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_all_complains, menu);
		return true;
	}

	

}
