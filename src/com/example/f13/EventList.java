package com.example.f13;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class EventList extends ListActivity {

	String [] events= new String[8];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_event_list);
		ArrayAdapter<String> events_list= new ArrayAdapter<String>(EventList.this,R.layout.eventname,events);
		setListAdapter(events_list);
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		String eventname = new String(((TextView)v.findViewById(R.id.eventname)).getText().toString());
		Intent i= new Intent(this, EventDescription.class);
		i.putExtra("title", "•  "+eventname);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_list, menu);
		return true;
	}

}
