package com.example.projecttester.Adapters;

import com.example.projecttester.CleanAjmerFragment;
import com.example.projecttester.SmartCityAjmerFragment;
import com.example.projecttester.SmartCityAjmerGridFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			return  new CleanAjmerFragment();
			
		

		case 1:
			return new SmartCityAjmerFragment();
		
		}
		return null;

		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	

}
