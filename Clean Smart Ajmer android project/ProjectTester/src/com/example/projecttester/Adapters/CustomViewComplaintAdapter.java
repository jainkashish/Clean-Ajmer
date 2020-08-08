package com.example.projecttester.Adapters;

import java.util.ArrayList;

import com.example.projecttester.R;
import com.example.projecttester.ViewAllComplainsActivity;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomViewComplaintAdapter extends BaseAdapter {
	TextView t1, t2, t3, t4, t5, t6, t7, t8;

	ViewAllComplainsActivity context;
	Integer layout;
	ArrayList<String> id, name, address, contact, email, ward, complaint,
			image;

	public CustomViewComplaintAdapter(ViewAllComplainsActivity context,
			Integer layout, ArrayList<String> id, ArrayList<String> name,
			ArrayList<String> address, ArrayList<String> contact,
			ArrayList<String> email, ArrayList<String> ward,
			ArrayList<String> complaint, ArrayList<String> image) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layout = layout;
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.ward = ward;
		this.complaint = complaint;
		this.image = image;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return id.size();
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

		LayoutInflater inflate = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		convertView = null;
		if (convertView == null) {
			convertView = inflate.inflate(layout, parent, false);
			t1 = (TextView) convertView.findViewById(R.id.textView1);
			t1.setText(id.get(position));

			t2 = (TextView) convertView.findViewById(R.id.textView2);
			t2.setText(name.get(position));

			t3 = (TextView) convertView.findViewById(R.id.textView3);
			t3.setText(address.get(position));

			t4 = (TextView) convertView.findViewById(R.id.textView4);
			t4.setText(contact.get(position));

			t5 = (TextView) convertView.findViewById(R.id.textView5);
			t5.setText(email.get(position));

			t6 = (TextView) convertView.findViewById(R.id.textView6);
			t6.setText(ward.get(position));

			t7 = (TextView) convertView.findViewById(R.id.textView7);
			t7.setText(complaint.get(position));

			t8 = (TextView) convertView.findViewById(R.id.textView8);
			t8.setText(image.get(position));

		}
		return convertView;

	}

}