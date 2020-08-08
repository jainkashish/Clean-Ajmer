package com.example.projecttester;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminPageActivity extends Activity implements OnClickListener {
	Button b1, b2, b3,b4,b5,b6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_page);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
		b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(this);
		b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(this);
		b5 = (Button) findViewById(R.id.button5);
		b5.setOnClickListener(this);
		b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_page, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i = new Intent(this, AddCategoryActivity.class);
			startActivity(i);

			break;

		case R.id.button2:
			Intent i2 = new Intent(this, ViewAllComplainsActivity.class);
			startActivity(i2);

			break;
		case R.id.button3:
			Intent i3 = new Intent(this, DeleteComplainActivity.class);
			startActivity(i3);

			break;
		case R.id.button4:
			Intent i4 = new Intent(this, GetImageFromServer.class);
			startActivity(i4);

			break;

		case R.id.button5:
			Intent i5 = new Intent(this, ViewAllUser.class);
			startActivity(i5);

			break;
		case R.id.button6:
			Intent i6 = new Intent(this, DeleteUser.class);
			startActivity(i6);

			break;


		default:
			break;
		}
	}

}
