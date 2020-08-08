package com.example.projecttester;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.example.projecttester.Adapters.DataEntity;
import com.example.projecttester.Adapters.DataEntity2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CleanAjmerFragment extends Fragment implements OnClickListener {
	UserSessionManager session;
	private static final int RESULT_LOAD_IMAGE = 1;
	private static final String SERVER_ADDRESS = "http://manishandroid.comxa.com/";
	Uri selectedImage;

	EditText name, address, contact, email, ward, complaint;
	Button b1, b2;
	String imagePath = "aaa";
	ImageView iv;
	private DataBaseHelper sql = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v = inflater
				.inflate(R.layout.cleanajmerfragment, container, false);

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		session = new UserSessionManager(getActivity());
		Toast.makeText(getActivity(),
				" User Login Status: " + session.isUserLoggedIn(),
				Toast.LENGTH_LONG).show();

		name = (EditText) getActivity().findViewById(R.id.editText1);
		address = (EditText) getActivity().findViewById(R.id.editText2);
		contact = (EditText) getActivity().findViewById(R.id.editText3);
		email = (EditText) getActivity().findViewById(R.id.editText4);

		ward = (EditText) getActivity().findViewById(R.id.editText5);
		complaint = (EditText) getActivity().findViewById(R.id.editText6);
		iv = (ImageView) getActivity().findViewById(R.id.iv1);
		b1 = (Button) getActivity().findViewById(R.id.button1);

		b2 = (Button) getActivity().findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		iv.setOnClickListener(this);

		if (session.isUserLoggedIn()) {
			HashMap<String, String> user = session.getUserDetails();

			// get name
			String val1 = user.get(UserSessionManager.KEY_NAME);
			String val2 = user.get(UserSessionManager.KEY_ADDRESS);
			String val3 = user.get(UserSessionManager.KEY_CONTACT);

			// get email
			String val4 = user.get(UserSessionManager.KEY_EMAIL);

			name.setText(val1);
			address.setText(val2);
			contact.setText(val3);
			email.setText(val4);

		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.iv1:
			Intent galleryIntent = new Intent(Intent.ACTION_PICK,
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);

			break;
		case R.id.button1:
			Bitmap image = ((BitmapDrawable) iv.getDrawable()).getBitmap();
			new UploadImage(image, imagePath).execute();

			if (name.getText().toString().equals("")) {
				name.setError("Please Enter name");
			} else if (address.getText().toString().equals("")) {
				address.setError("Please Enter address");
			} else if (contact.getText().toString().equals("")) {
				contact.setError("Please Enter contact");
			} else if (email.getText().toString().equals("")) {
				email.setError("Please Enter email");
			} else if (ward.getText().toString().equals("")) {
				ward.setError("Please Enter Ward No");
			} else if (complaint.getText().toString().equals("")) {
				complaint.setError("Please Enter Password to confirm");
			} else {
				sql = new DataBaseHelper(getActivity());

				DataEntity2 de = new DataEntity2(0, name.getText().toString(),
						address.getText().toString(), contact.getText()
								.toString(), email.getText().toString(), ward
								.getText().toString(), complaint.getText()
								.toString(), imagePath);
				if (sql.insertComplaint(de)) {
					Toast.makeText(getActivity(),
							"Information added successfully", Toast.LENGTH_LONG)
							.show();

				} else {
					Toast.makeText(getActivity(),
							"Fail to  add Information, please try again!",
							Toast.LENGTH_LONG).show();
				}

			}

			break;
		case R.id.button2:
			name.setText("");
			address.setText("");
			contact.setText("");
			email.setText("");
			ward.setText("");
			complaint.setText("");
			iv.setImageResource(R.drawable.upload);

			break;

		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && data != null) {
			selectedImage = data.getData();// Address of the image selected
			String a = "img";
			Random rd = new Random();
			imagePath = a + rd.nextInt(1000);
			iv.setImageURI(selectedImage);
			Toast.makeText(getActivity(), imagePath + "", Toast.LENGTH_LONG)
					.show();
		}
	}

	private class UploadImage extends AsyncTask<Void, Void, Void> {
		Bitmap image;
		String name;

		public UploadImage(Bitmap image, String name) {
			this.image = image;
			this.name = name;
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			// encode the image into basic defaults . holds the byte
			// represenation of the stream .
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			// 100 is the best quality .
			image.compress(Bitmap.CompressFormat.JPEG, 100,
					byteArrayOutputStream);

			// String Represenation of image
			String encodeImage = Base64.encodeToString(
					byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

			ArrayList<NameValuePair> datatoSend = new ArrayList<NameValuePair>();

			datatoSend.add(new BasicNameValuePair("image", encodeImage));
			datatoSend.add(new BasicNameValuePair("name", name));

			HttpParams httpRequestParams = getHttpRequestParams();
			// will assist to send the request to the server and will tell the
			// client abut time timeouts n oll .

			HttpClient client = new DefaultHttpClient(httpRequestParams);

			HttpPost post = new HttpPost(SERVER_ADDRESS + "savePicture.php");
			try {
				// We giving the data to the post request
				post.setEntity(new UrlEncodedFormEntity(datatoSend));
				// tell the client to excecute the post
				client.execute(post);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(getActivity(), "Image Uploadedd", 2000).show();
		}

	}

	private HttpParams getHttpRequestParams() {
		// Holds the attributes that we will send to the server
		HttpParams httpRequestParams = new BasicHttpParams();
		// Set The Time out For connection .
		HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
		HttpConnectionParams.setSoTimeout(httpRequestParams, 1000 * 30);
		return httpRequestParams;
	}

}
