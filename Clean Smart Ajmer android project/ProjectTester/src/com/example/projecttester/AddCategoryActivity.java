package com.example.projecttester;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCategoryActivity extends Activity implements OnClickListener {

	EditText t1;
	Button b1;
	private DataBaseHelper sql=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_category);
		t1=(EditText)findViewById(R.id.editText1);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_category, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		sql= new DataBaseHelper(getApplicationContext());
		if(t1.getText().toString().equals("")){
			t1.setError("Please Enter Category");
		}
		if(sql.insertCategory(t1.getText().toString()))
		{
			Toast.makeText(this, "Catogory Added Succesfully ...", 2000).show();
			
		}
		else
		{
			Toast.makeText(this, "Catogory Cant be  Added  ...", 2000).show();
			
		}
		
		
	}

}
