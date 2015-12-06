package com.example.letmedrive;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	ListView list;
    String[] contactName;
    String[] contactNumber;
    int[] image ={R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        //here accessing stingArray which define in string.xml
        
        Resources res= getResources();
        contactName = res.getStringArray(R.array.name);
        contactNumber = res.getStringArray(R.array.number);
        
        
        list = (ListView) findViewById(R.id.listView1);
        VijayAdapter adapter= new VijayAdapter(this, contactName, image, contactNumber);
        list.setAdapter(adapter);
    }
}


class VijayAdapter extends ArrayAdapter<String>
{
	//Creating a reference
	
	Context context;
	int[] images;
	String[] nameArray;
	String[] numberArray;

	VijayAdapter(Context c, String[] name, int imgs[], String[] number){
		
		super(c, R.layout.contact, R.id.textView1, name);
		this.context=c;
		this.images=imgs;
		this.nameArray=name;
		this.numberArray=number;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row=inflater.inflate(R.layout.contact, parent, false);
		
		ImageView myImage=(ImageView) row.findViewById(R.id.imageView1);
		TextView myName=(TextView) row.findViewById(R.id.textView1);
		TextView myNumber=(TextView) row.findViewById(R.id.textView2);
		
		//position define the image list, Name, Contact number by passing 0,1,2,3,4..... internally
		
		myImage.setImageResource(images[position]);
		myName.setText(nameArray[position]);
		myNumber.setText(numberArray[position]);
		
		return row;
	}
}
