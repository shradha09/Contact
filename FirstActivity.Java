package com.example.appName;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;



public class FirstActivity extends Activity  {
	//here creating the reference of ImageButton for further use
	ImageButton imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       
        imgButton=(ImageButton)findViewById(R.id.imageButton1);
       
        imgButton.setOnClickListener(new View.OnClickListener() {
        	
			//when click the button then following function will work
			@Override
			public void onClick(View v) {
				
				// Here we connecting First activity to second activity
				
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class );
			    startActivity(intent);
			}
		});
      
    }
 
}


