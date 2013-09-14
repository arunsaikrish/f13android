package com.example.f13;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
EditText et;
TextView tv;
Button b1,b2,b3,b4,b5,b6,b7,b8;
AnimationDrawable anim;
HorizontalScrollView hsv;
ArrayList<WorkshopDetails> workshopList=new ArrayList<WorkshopDetails>();
String[] workshops;
String[] desc;
int h,w;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// full screen
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		
		b1=(Button)findViewById(R.id.button1);
		hsv=(HorizontalScrollView)findViewById(R.id.horizontalScrollView1);
		
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		b5=(Button)findViewById(R.id.button5);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i= new Intent(MainActivity.this,InfoDisplay.class);
		switch(arg0.getId())
		{
		//Events
		case R.id.button1:
			startActivity(i);
			break;
		//Workshops	
		case R.id.button5:
			i.setClass(this, Contacts.class);
			startActivity(i);
			break;
		//Sponsors
		case R.id.button3:
			startActivity(i);
			break;
		//Pro Nite
		case R.id.button4:
			startActivity(i);
			break;
		//FSR
		case R.id.button2:
			try {
				/* Create a URL we want to load some xml-data from. */
				URL url = new URL("http://10.0.2.2/workshops.xml");

				/* Get a SAXParser from the SAXPArserFactory. */
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();

				/* Get the XMLReader of the SAXParser we created. */
				XMLReader xr = sp.getXMLReader();
			
				/* Create a new ContentHandler and apply it to the XML-Reader*/ 
				WorkshopsParser myExampleHandler = new WorkshopsParser(workshopList);
				xr.setContentHandler(myExampleHandler);
				
				/* Parse the xml-data from our URL. */
				xr.parse(new InputSource(url.openStream()));
				/* Parsing has finished. */
				
				workshopList=myExampleHandler.getWorkshopList();
				Log.d("GetList", workshopList.get(0).getName());
				workshops=new String[workshopList.size()];
				desc=new String[workshopList.size()]; 
				for(int x=0;x<workshopList.size();x++)
					{
					workshops[x]=workshopList.get(x).getName();				
					desc[x]=workshopList.get(x).getDesc();
					}
				Log.d("Desc", workshopList.get(0).getDesc());
				
			} catch (Exception e) {
				/* Display any Error to the GUI. */				
				Log.e("Workshop", "MainError", e);
			}
			i.setClass(this, Workshops.class);
			i.putExtra("workshops", workshops);
			i.putExtra("desc", desc);
			startActivity(i);
			break;
		}
		
			
	}

	

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		h=hsv.getHeight();
		w=hsv.getChildAt(0).getWidth();
		RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams)b1.getLayoutParams();
		params.leftMargin=(int)(w*0.175);
		params.topMargin=(int) (h/2.5);
		params.width=(int)(h/2);
		params.height=(int)(h/3);
		b1.setLayoutParams(params);
		RelativeLayout.LayoutParams params2=(RelativeLayout.LayoutParams)b2.getLayoutParams();
		params2.leftMargin=(int) (w * 0.40);
		params2.topMargin=(int) (h/4);
		params2.height=(int)(h/2);
		params.width=(int)(h/2);
		b2.setLayoutParams(params2);
		RelativeLayout.LayoutParams param3=(RelativeLayout.LayoutParams)b3.getLayoutParams();
		param3.leftMargin=(int) (w * 0.575);
		param3.topMargin=(int) (h/2.75);
		param3.width=(int)(h/2.5);
		param3.height=(int)(h/2.7);
		b3.setLayoutParams(param3);
		RelativeLayout.LayoutParams params4=(RelativeLayout.LayoutParams)b4.getLayoutParams();
		params4.leftMargin=(int) (w *0.775);
		params4.topMargin=(int) (h/4);
		params4.height=(int)(h/2);
		params4.width=(int)(h/2.5);
		b4.setLayoutParams(params4);
		RelativeLayout.LayoutParams params5=(RelativeLayout.LayoutParams)b5.getLayoutParams();
		params5.width=h/3;
		params5.height=(int) (h/2.5);
		params5.leftMargin=(int) (w*0.02);
		params5.topMargin= (int) (h/3);
		b5.setLayoutParams(params5);
		
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		finish();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		android.os.Process.killProcess(android.os.Process.myPid());
		finish();
	}
	
	}
