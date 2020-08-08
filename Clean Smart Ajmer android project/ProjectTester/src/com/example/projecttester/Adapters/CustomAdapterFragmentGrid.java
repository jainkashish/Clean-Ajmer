package com.example.projecttester.Adapters;

import java.util.ArrayList;

import com.example.projecttester.R;
import com.example.projecttester.SmartCityAjmerFragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterFragmentGrid extends BaseAdapter {
	private  ArrayList<String> name;
	private  ArrayList<Integer> image;
	private Context context;
	private Integer layout;
	public CustomAdapterFragmentGrid(Context context,Integer layout,ArrayList<String> name,ArrayList<Integer> image) {
		// TODO Auto-generated constructor stub
	
	this.context=context;
	this.layout=layout;
	this.name=name;
	this.image=image;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflate=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		convertView=null;
		if(convertView==null)
		{
			convertView=inflate.inflate(layout,parent,false);
			TextView tv=(TextView)convertView.findViewById(R.id.textView1);
			ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);
			tv.setText(name.get(position));
			img.setImageResource(image.get(position));
			
		}
		return convertView;

	}
}	
		