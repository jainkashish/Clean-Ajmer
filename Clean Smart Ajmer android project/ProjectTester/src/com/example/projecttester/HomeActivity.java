package com.example.projecttester;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener {
	Button b1,b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
@Override
public boolean onMenuItemSelected(int featureId, MenuItem item) {
	// TODO Auto-generated method stub
	
	switch (item.getItemId()) {
	case R.id.m1:
		Intent ad=new Intent(this,AdminLoginActivity.class);
		startActivity(ad);
		
		break;

	default:
		break;
	}
	return super.onMenuItemSelected(featureId, item);
	
}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i1=new Intent(this,TabActivity.class);
			startActivity(i1);
			
			break;
		case R.id.button2:
			Intent i2=new Intent(this,LoginActivity.class);
			startActivity(i2);
			
			break;
			
		case R.id.button3:
			Intent i3=new Intent(this,RegisterActivity.class);
			startActivity(i3);
			

	
	break;


		default:
			break;
		}
		
	}

}
