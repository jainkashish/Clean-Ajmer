package com.example.projecttester;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMyProfileActivity extends Activity implements OnClickListener {
	EditText et1,et2,et3,et4;
	Button b;
	String contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_my_profile);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		b=(Button) findViewById(R.id.button1);
		
		et4=(EditText) findViewById(R.id.editText4);
		Intent i=getIntent();
		contact=i.getStringExtra("contact");
		b.setOnClickListener(this);
		DataBaseHelper dh = new DataBaseHelper(this);
		SQLiteDatabase db = dh.getReadableDatabase();

		String q = "select * from  data2  where contact=?";
		Cursor cursor = db.rawQuery(q, new String[] { contact });
		
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				et1.setText(cursor.getString(1));
				et2.setText(cursor.getString(2));
				et3.setText(cursor.getString(4));
				et4.setText(cursor.getString(5));
				
			} while (cursor.moveToNext());
		}

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_my_profile, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DataBaseHelper dh1=new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1=dh1.getReadableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("name", et1.getText().toString());
		cv.put("address", et2.getText().toString());
		cv.put("email", et3.getText().toString());
		
		cv.put("password", et4.getText().toString());
		
		int ans=db1.update("data2", cv, "contact=?", new String[]{contact});
		if(ans==1)
		{

			Toast.makeText(this, "Record Updated", 2000).show();
		
			
		}
		else
		{
			

			Toast.makeText(this, "Record Not Updated", 2000).show();
		
		}

		
	}

}
