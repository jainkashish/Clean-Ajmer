package com.example.projecttester;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MallActivity extends Activity implements OnClickListener {
	Button b, b2, b3;
	Dialog dialog;
	TextView text1, text2, text3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mall);
		b = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);

		b.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mall, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			
			dialog = new Dialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.dialog);
			text1 = (TextView) dialog.findViewById(R.id.textView1);
			text1.setText("Vega Mall");

			TextView text2 = (TextView) dialog.findViewById(R.id.textView2);
			text2.setText(" Near Suchna Kendra Ajmer");

			final TextView text3 = (TextView) dialog.findViewById(R.id.textView3);
			String no = "9782677254";
			text3.setText(no);
			text3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:"
							+ text3.getText().toString()));
					startActivity(callIntent);

				}
			});
			RatingBar rb = (RatingBar) dialog.findViewById(R.id.ratingBar1);
			rb.setRating(4);
			b = (Button) dialog.findViewById(R.id.button1);

			b.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();

				}
			});
			Button b2 = (Button) dialog.findViewById(R.id.button2);
			b2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					try {
						String address = "Suchna Kendra";
						address = address.replace(' ', '+');
						Intent i = new Intent(android.content.Intent.ACTION_VIEW,
								Uri.parse("geo:0,0?q=" + address));
						startActivity(i);

					} catch (Exception e) {
						// TODO: handle exception
						// Log any error messages to LogCat using Log.e()

					}

				}
			});
			dialog.show();

			
			break;
	case R.id.button2:
		
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog);
		text1 = (TextView) dialog.findViewById(R.id.textView1);
		text1.setText("Reliance");

		TextView text22 = (TextView) dialog.findViewById(R.id.textView2);
		text22.setText("Vaishali Nagar Ajmer");

		final TextView text33 = (TextView) dialog.findViewById(R.id.textView3);
		String no1 = "9782677254";
		text33.setText(no1);
		text33.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"
						+ text33.getText().toString()));
				startActivity(callIntent);

			}
		});
		RatingBar rb1 = (RatingBar) dialog.findViewById(R.id.ratingBar1);
		rb1.setRating(4);
		b = (Button) dialog.findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.dismiss();

			}
		});
		Button b22 = (Button) dialog.findViewById(R.id.button2);
		b22.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					String address = "Reliance Ajmer  rajasthan";
					address = address.replace(' ', '+');
					Intent i = new Intent(android.content.Intent.ACTION_VIEW,
							Uri.parse("geo:0,0?q=" + address));
					startActivity(i);

				} catch (Exception e) {
					// TODO: handle exception
					// Log any error messages to LogCat using Log.e()

				}

			}
		});
		dialog.show();

					
			break;

	case R.id.button3:
		
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog);
		text1 = (TextView) dialog.findViewById(R.id.textView1);
		text1.setText("Miraj Cinemas");

		TextView text222 = (TextView) dialog.findViewById(R.id.textView2);
		text222.setText("Vaishali Ajmer");

		final TextView text333 = (TextView) dialog.findViewById(R.id.textView3);
		String no2 = "9782677254";
		text333.setText(no2);
		text333.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"
						+ text333.getText().toString()));
				startActivity(callIntent);

			}
		});
		RatingBar rb2 = (RatingBar) dialog.findViewById(R.id.ratingBar1);
		rb2.setRating(4);
		b = (Button) dialog.findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.dismiss();

			}
		});
		Button b222 = (Button) dialog.findViewById(R.id.button2);
		b222.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					String address = "Miraj Cinemas Ajmer  rajasthan";
					address = address.replace(' ', '+');
					Intent i = new Intent(android.content.Intent.ACTION_VIEW,
							Uri.parse("geo:0,0?q=" + address));
					startActivity(i);

				} catch (Exception e) {
					// TODO: handle exception
					// Log any error messages to LogCat using Log.e()

				}

			}
		});
		dialog.show();

					
		
		
		break;


		}
		
	}

}
