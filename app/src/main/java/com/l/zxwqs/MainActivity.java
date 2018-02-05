package com.l.zxwqs;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity 
{
	public String SecureType;
	public String SSID;
	public String Password;
	public Boolean isHidden;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	final ArrayAdapter adapterS = ArrayAdapter.createFromResource(this, R.array.secure, android.R.layout.simple_spinner_item);  
	final ArrayAdapter adapterB = ArrayAdapter.createFromResource(this, R.array.array_boolean, android.R.layout.simple_spinner_item);
	((Spinner)findViewById(R.id.sSpinn)).setAdapter(adapterS); 
	((Spinner)findViewById(R.id.hidSpinn)).setAdapter(adapterB);
	((Spinner)findViewById(R.id.sSpinn)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
		public void onItemSelected(AdapterView p4,View p1,int p2,long p3){
			if(p2==0){
				SecureType="WPA";
			}else if(p2==1){
				SecureType="nopass";
		    }else if(p2==3){
				SecureType="WEP";
			}
		}
		public void onNothingSelected(AdapterView p1){}
	});
	((Spinner)findViewById(R.id.hidSpinn)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
		public void onItemSelected(AdapterView p4,View p1,int p2,long p3){
		if(p2==0){
		isHidden=true;
		}else if(p2==1){
		isHidden=false;
	}
		}
		public void onNothingSelected(AdapterView p1){}
	});
	((Button)findViewById(R.id.made)).setOnClickListener(new View.OnClickListener(){
		public void onClick(View p1){
		 SSID=((EditText)findViewById(R.id.ssid)).getText().toString();
		 Password=((EditText)findViewById(R.id.pass)).getText().toString();
		 ((EditText)findViewById(R.id.result)).setText("WIFI:T:"+SecureType+";S:"+SSID+";P:"+Password+";H:"+isHidden+";;");
		}
	});
    }
}
