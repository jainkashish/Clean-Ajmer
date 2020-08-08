package com.example.projecttester;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GetImageFromServer extends Activity implements OnClickListener {
	EditText t1;
	Button b1;
	String id, result, imageValue;
	ArrayList<String> data;
	DataBaseHelper db = null;
	TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
	ImageView img;
	private static final String SERVER_ADDRESS = "http://manishandroid.comxa.com/";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_image_from_server);
		t1 = (EditText) findViewById(R.id.editText1);
		data = new ArrayList<String>();
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		tv1 = (TextView) findViewById(R.id.textView2);
		tv2 = (TextView) findViewById(R.id.textView3);
		tv3 = (TextView) findViewById(R.id.textView4);
		tv4 = (TextView) findViewById(R.id.textView5);
		tv5 = (TextView) findViewById(R.id.textView6);
		tv6 = (TextView) findViewById(R.id.textView7);
		tv7 = (TextView) findViewById(R.id.textView8);
		img = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String id = t1.getText().toString();
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getReadableDatabase();
		String q = "select * from  clean_ajmer4  where id=?";
		Cursor c = db.rawQuery(q, new String[] { id });
		if (c.moveToFirst()) {
			tv1.setText(c.getString(0));
			tv2.setText(c.getString(1));
			tv3.setText(c.getString(2));
			tv4.setText(c.getString(3));
			tv5.setText(c.getString(4));
			tv6.setText(c.getString(5));
			tv7.setText(c.getString(6));
			String path = c.getString(7);
			new DownloadImage(path).execute();

		} else {
			Toast.makeText(this, "Record Not Present", 2000).show();
		}

	}

	private class DownloadImage extends AsyncTask<Void, Void, Bitmap> {
		String name;

		public DownloadImage(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}

		@Override
		protected Bitmap doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			String url = SERVER_ADDRESS + "pictures/" + name + ".JPG";
			try {

				URLConnection connection = new URL(url).openConnection();
				connection.setConnectTimeout(1000 * 30);
				connection.setReadTimeout(1000 * 30);
				return BitmapFactory.decodeStream(
						(InputStream) connection.getContent(), null, null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;

			}
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result != null) {
				img.setImageBitmap(result);
			}
		}

	}

}
