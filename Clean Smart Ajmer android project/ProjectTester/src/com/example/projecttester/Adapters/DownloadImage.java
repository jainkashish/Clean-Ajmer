package com.example.projecttester.Adapters;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class DownloadImage extends AsyncTask<Void, Void, Bitmap> {
	String name;
	private static final String SERVER_ADDRESS = "http://manishandroid.comxa.com/";
	

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

	
}

