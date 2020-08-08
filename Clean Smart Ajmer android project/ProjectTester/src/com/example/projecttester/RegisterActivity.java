package com.example.projecttester;

import com.example.projecttester.Adapters.DataEntity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {
	EditText name,address,contact,email,password,cpassword;
	Button b1,b2;
	private DataBaseHelper sql=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name=(EditText)findViewById(R.id.editText1);
		address=(EditText)findViewById(R.id.editText2);
		contact=(EditText)findViewById(R.id.editText3);
		email=(EditText)findViewById(R.id.editText4);
		password=(EditText)findViewById(R.id.editText5);
		cpassword=(EditText)findViewById(R.id.editText6);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			
			if(name.getText().toString().equals("")){
				name.setError("Please Enter name");
			}
			else if(address.getText().toString().equals("")){
				address.setError("Please Enter address");
			}
			else if(contact.getText().toString().equals("")){
				contact.setError("Please Enter contact");
			}
			else if(email.getText().toString().equals("")){
				email.setError("Please Enter email");
			}
			else if(password.getText().toString().equals("")){
				password.setError("Please Enter password");
			}
			else if(cpassword.getText().toString().equals("")){
				cpassword.setError("Please Enter Password to confirm");
			}
			else if(password.getText().toString().equals(cpassword.getText().toString())){
				
						sql=new DataBaseHelper(this);
						DataEntity de = new DataEntity(0,
								name.getText().toString(),
								address.getText().toString(),
								contact.getText().toString(),
								email.getText().toString(),
								password.getText().toString());
							if(sql.insertData(de))
							{
								Toast.makeText(this, "Information added successfully", Toast.LENGTH_LONG).show();
								Intent i=new Intent(this,TabActivity.class);
								startActivity(i);
								
							}
							else
							{
								Toast.makeText(this, "Fail to add Information, please try again!", Toast.LENGTH_LONG).show();
							}
							
					}
					else
					{
						Toast.makeText(this, "Fail to add Information, please try again!", Toast.LENGTH_LONG).show();
					
						password.setError("Password Mismatch");
						cpassword.setError("Password Mismatch");
					
					}
										
					
					
						
			
		
			break;

		case R.id.button2:
			
			name.setText("");
			address.setText("");
			contact.setText("");
			email.setText("");
			password.setText("");
			cpassword.setText("");
			break;

		default:
			break;
		}
	}

}

