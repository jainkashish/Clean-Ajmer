package com.example.projecttester;

import java.util.ArrayList;

import com.example.projecttester.Adapters.CustomAdapterFragmentList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SmartCityAjmerFragment extends Fragment implements OnItemClickListener {
ListView lv;
ArrayList<String> item;
ArrayList<Integer> image;
	private DataBaseHelper sql=null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.smartcityajmerfragment, container,false);
		lv=(ListView) v.findViewById(R.id.listView1);
		//sql=new DataBaseHelper(getActivity());
		item=new ArrayList<String>();
		//item=sql.getAllCategory();
		
		item.add("Schools");
		item.add("Colleges");
		item.add("Shopping");
		item.add("Multiplex");
		item.add("Malls");
		item.add("Religious");
		item.add("Restaurant");
		item.add("Hospital");
		item.add("Bus Stand");
		item.add("Railway Station");
		
		image=new ArrayList<Integer>();
		image.add(R.drawable.university);
		image.add(R.drawable.college);
		image.add(R.drawable.mall);
		image.add(R.drawable.mov);
		image.add(R.drawable.shop);
		image.add(R.drawable.tem);
		image.add(R.drawable.rest);
		image.add(R.drawable.hos);
		image.add(R.drawable.bus);
		image.add(R.drawable.train);


		CustomAdapterFragmentList adapter=new CustomAdapterFragmentList(getActivity(), R.layout.list_item, item, image);
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.list_item,R.id.tv,item);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
	
		return v;
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch (arg2) {
		case 0:
			Intent i=new Intent(getActivity(),SchoolActivity.class);
			startActivity(i);
			
			break;


		case 1:
			Intent i2=new Intent(getActivity(),CollegesActivity.class);
			startActivity(i2);
			
			break;


		case 2:
			Intent i3=new Intent(getActivity(),ShoppingActivity.class);
			startActivity(i3);
			
			break;


		case 3:
			Intent i4=new Intent(getActivity(),MultiplexActivity.class);
			startActivity(i4);
			
			break;

		case 4:
			Intent i5=new Intent(getActivity(),MallActivity.class);
			startActivity(i5);
			
			break;

		default:
			break;
		}
	}
		
}
