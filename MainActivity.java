package com.my.helloworld;

import android.app.Activity;
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
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		b1=(Button)findViewById(R.id.button1);
		hsv=(HorizontalScrollView)findViewById(R.id.horizontalScrollView1);
		
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		b5=(Button)findViewById(R.id.button5);
		b6=(Button)findViewById(R.id.button6);
		b7=(Button)findViewById(R.id.button7);
		b8=(Button)findViewById(R.id.button8);
		
		/*StateListDrawable bg=(StateListDrawable)b.getBackground();
		Drawable curr=bg.getCurrent();
		if(curr instanceof AnimationDrawable)
		{
			anim=(AnimationDrawable)curr;
			anim.start();
		}
		*/
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		/*String str;
		str=et.getText().toString();
		tv.setText(str);
		*/
		Toast.makeText(this, "Check", Toast.LENGTH_SHORT).show();
		switch(arg0.getId())
		{
		//Events
		case R.id.button1:
			break;
		//Workshops	
		case R.id.button2:
			break;
		//Sponsors
		case R.id.button3:
			break;
		//Pro Nite
		case R.id.button4:
			break;
		//FSR
		case R.id.button5:
			break;
		//Register	
		case R.id.button6:
			break;
		//Informals
		case R.id.button7:
			break;
		//Contact	
		case R.id.button8:
			break;
		
			
		}
			
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		h=hsv.getHeight();
		w=hsv.getChildAt(0).getWidth();
		RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams)b1.getLayoutParams();
		params.leftMargin=w/(w-10);
		params.topMargin=(int) (h/3);
		b1.setLayoutParams(params);
		RelativeLayout.LayoutParams params2=(RelativeLayout.LayoutParams)b2.getLayoutParams();
		params2.leftMargin=w/6;
		params2.topMargin=(int) (h/3.5);
		b2.setLayoutParams(params2);
		RelativeLayout.LayoutParams param3=(RelativeLayout.LayoutParams)b3.getLayoutParams();
		param3.leftMargin=w/(w-10);
		param3.topMargin=(int) (h*.75);
		b3.setLayoutParams(param3);
		RelativeLayout.LayoutParams params4=(RelativeLayout.LayoutParams)b4.getLayoutParams();
		params4.leftMargin=(int) (w/4);
		params4.topMargin=(int) (h/1.5);
		b4.setLayoutParams(params4);
		
		RelativeLayout.LayoutParams params5=(RelativeLayout.LayoutParams)b5.getLayoutParams();
		params5.leftMargin=(int) (w/(1.9));
		params5.topMargin=(int) (h/3);
		b5.setLayoutParams(params5);
		RelativeLayout.LayoutParams params6=(RelativeLayout.LayoutParams)b6.getLayoutParams();
		params6.leftMargin=(int) (w*.85);
		params6.topMargin=(int) (h/(h-20));
		b6.setLayoutParams(params6);
		RelativeLayout.LayoutParams param7=(RelativeLayout.LayoutParams)b7.getLayoutParams();
		param7.leftMargin=(int) (w*.60);
		param7.topMargin=(int) (h*.75);
		b7.setLayoutParams(param7);
		RelativeLayout.LayoutParams params8=(RelativeLayout.LayoutParams)b8.getLayoutParams();
		params8.leftMargin=(int) (w*.85);
		params8.topMargin=(int) (h*.8);
		b8.setLayoutParams(params8);
		//Log.d("w-h",width+" "+height);
		 
		Log.d("w-h",w+" "+h);
	}

}
