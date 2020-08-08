package com.example.projecttester;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewMyProfileActivity extends Activity implements OnClickListener {
	TextView t1, t2, t3, t4, t5, t6;
	String val1;
	Button b1;
	UserSessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_my_profile);
		session = new UserSessionManager(getApplicationContext());
		if (session.isUserLoggedIn()) {
			HashMap<String, String> user = session.getUserDetails();

			// get name
			val1 = user.get(UserSessionManager.KEY_CONTACT);
			b1 = (Button) findViewById(R.id.button1);
			t1 = (TextView) findViewById(R.id.textView1);
			t2 = (TextView) findViewById(R.id.textView2);
			t3 = (TextView) findViewById(R.id.textView3);
			t4 = (TextView) findViewById(R.id.textView4);
			t5 = (TextView) findViewById(R.id.textView5);
			t6 = (TextView) findViewById(R.id.textView6);
			b1.setOnClickListener(this);
			DataBaseHelper dh = new DataBaseHelper(this);
			SQLiteDatabase db = dh.getReadableDatabase();

			String q = "select * from  data2  where contact=?";
			Cursor cursor = db.rawQuery(q, new String[] { val1 });

			if (cursor != null)
				cursor.moveToFirst();
			if (cursor.moveToFirst()) {
				do {
					t1.setText(cursor.getString(0));
					t2.setText(cursor.getString(1));
					t3.setText(cursor.getString(2));
					t4.setText(cursor.getString(3));
					t5.setText(cursor.getString(4));
					t6.setText(cursor.getString(5));

				} while (cursor.moveToNext());
			}

		} else {
			Toast.makeText(getApplicationContext(), " Your are not Logged in",
					5000).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_my_profile, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, UpdateMyProfileActivity.class);
		i.putExtra("contact", val1);
		startActivity(i);

	}

}
