package com.example.projecttester;

import com.example.projecttester.Adapters.TabsPagerAdapter;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;

public class TabActivity extends FragmentActivity implements TabListener, OnPageChangeListener {
	ActionBar actionBar;
	ViewPager viewPager;
	UserSessionManager session;

	@Override
	protected void onCreate(Bundle arg0) {

		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_tab);
		session=new UserSessionManager(getApplicationContext());
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(this);
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText(" Clean Ajmer");
		tab1.setTabListener(this);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText( "Smart City Ajmer");
		tab2.setTabListener(this);

		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
	switch (item.getItemId()) {
	case R.id.logout:
		session.logoutUser();
		
		break;
	case R.id.view:
		if(session.isUserLoggedIn())
		{
		Intent i=new Intent(this,ViewMyProfileActivity.class);
		startActivity(i);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Your are not logged In ",2000).show();
		}
		break;
	case R.id.finsh:
		finish();
		break;
	


	default:
		break;
	}
	return super.onMenuItemSelected(featureId, item);
	
	}



	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
 
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(arg0.getPosition());

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		actionBar.setSelectedNavigationItem(arg0);
		
	}
}

class MyAdapter extends FragmentPagerAdapter {

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		if (arg0 == 0) {
			fragment = new CleanAjmerFragment();

		}
		if (arg0 == 1) {
			fragment = new SmartCityAjmerFragment();

		}

		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
}