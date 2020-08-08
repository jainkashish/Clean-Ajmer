package com.example.projecttester;

import java.util.ArrayList;

import com.example.projecttester.Adapters.CustomAdapterFragmentGrid;
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
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class SmartCityAjmerGridFragment extends Fragment implements
		OnItemClickListener {
	GridView gv;
	ArrayList<String> item;
	ArrayList<Integer> image;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.smartcitygridfragment, container,
				false);
		gv = (GridView) getActivity().findViewById(R.id.gvv1);
		item = new ArrayList<String>();
		
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

		image = new ArrayList<Integer>();
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

		CustomAdapterFragmentGrid ad1=new CustomAdapterFragmentGrid(getActivity(),R.layout.custom_view,item,image);
		gv.setAdapter(ad1);
		gv.setOnItemClickListener(this);

		return v;

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch (arg2) {
		case 0:
			Intent i = new Intent(getActivity(), SchoolActivity.class);
			startActivity(i);

			break;

		default:
			break;
		}
	}

}
