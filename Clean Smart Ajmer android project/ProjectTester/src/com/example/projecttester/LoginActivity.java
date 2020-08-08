package com.example.projecttester;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	UserSessionManager session;

	Button b1;
	EditText user_et, pass_et;
	private DataBaseHelper sql = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		  session = new UserSessionManager(getApplicationContext());                
		  Toast.makeText(getApplicationContext(), 
	        		"User Login Status: " + session.isUserLoggedIn(), 
	        		Toast.LENGTH_LONG).show();
	        
	        

		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		user_et = (EditText) findViewById(R.id.editText1);
		pass_et = (EditText) findViewById(R.id.editText2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		sql = new DataBaseHelper(getApplicationContext());
		if (user_et.getText().toString().equals("")) {
			user_et.setError("Please Enter username");
		} else if (pass_et.getText().toString().equals("")) {
			pass_et.setError("Please Enter password");
		} else if (sql.getUserPassword(user_et.getText().toString(), pass_et
				.getText().toString())) {
			DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db = dh.getReadableDatabase();
			String q = "select * from  data2  where contact=?";
			Cursor c = db.rawQuery(q, new String[] { user_et.getText()
					.toString() });
			if (c.moveToFirst()) {

				String a = c.getString(1);
				String b = c.getString(2);
				String c1 = c.getString(3);
				String d = c.getString(4);
				Toast.makeText(getApplicationContext(), a+"  " + b+"  " +c1+"  "+ d +" ", 5000).show();
			
				Toast.makeText(getApplicationContext(), "your are Logged in",
						2000).show();
				session.createUserLoginSession(a, b ,c1,d);
				
				Intent i1 = new Intent(this, TabActivity.class);
				i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

				// Add new Flag to start new Activity
				i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				startActivity(i1);
			} else {
				Toast.makeText(getApplicationContext(), "Incorrect details",
						2000).show();
			}

		}

	}
}
