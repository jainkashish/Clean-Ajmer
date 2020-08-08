package com.example.projecttester;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		Thread t=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				try {
					sleep(2000);
					Intent i=new Intent(getApplicationContext(),TouchActivity.class);
					startActivity(i);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				super.run();
			}
			
			
		};
		t.start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
