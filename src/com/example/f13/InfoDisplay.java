package com.example.f13;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InfoDisplay extends ListActivity {

	String [] events=new String[8];
	int noc;
	ArrayList<EventDetails> eventList=new ArrayList<EventDetails>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_info_display);				
		
		try {
			/* Create a URL we want to load some xml-data from. */
			URL url = new URL("http://10.0.2.2/event_list.xml");

			/* Get a SAXParser from the SAXPArserFactory. */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			/* Get the XMLReader of the SAXParser we created. */
			XMLReader xr = sp.getXMLReader();
		
			/* Create a new ContentHandler and apply it to the XML-Reader*/ 
			EventsParser myExampleHandler = new EventsParser(eventList);
			xr.setContentHandler(myExampleHandler);
			
			/* Parse the xml-data from our URL. */
			xr.parse(new InputSource(url.openStream()));
			/* Parsing has finished. */
			
			eventList=myExampleHandler.getEventList();
			Log.d("GetList", eventList.get(0).getName());
			for(int i=0;i<eventList.size();i++)
				events[i]=eventList.get(i).getName();
			Log.d("Desc", eventList.get(0).getChildren().get(0).getDesc());
			
		} catch (Exception e) {
			/* Display any Error to the GUI. */
			
			Log.e("Error", "MainError", e);
		}
				
			
	
		
		// Show the Up button in the action bar.
		setupActionBar();
		ArrayAdapter<String> events_list= new ArrayAdapter<String>(InfoDisplay.this,R.layout.eventname,events);
		setListAdapter(events_list);
	}

	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		String[] listOfEvents=new String[eventList.get(position).getChildren().size()];
		String[] eventsDesc=new String[eventList.get(position).getChildren().size()];
		String eventname = new String(((TextView)v.findViewById(R.id.eventname)).getText().toString());
		Intent i= new Intent(this, InfoDesc.class);
		i.putExtra("title", eventname);
		i.putExtra("children", eventList.get(position).getChildren().size());
		for(int x=0;x<eventList.get(position).getChildren().size();x++){
			listOfEvents[x]=eventList.get(position).getChildren().get(x).getName();
		}
					
		i.putExtra("ListOfEvents", listOfEvents);
		Log.d("NOC", eventList.get(position).getChildren().size()+"");
		
		for(int x=0;x<eventList.get(position).getChildren().size();x++){
			eventsDesc[x]=eventList.get(position).getChildren().get(x).getDesc();
		}
		//Log.d("Desc", eventsDesc[0]);
		i.putExtra("eventsDesc", eventsDesc);
		startActivity(i);
	}
	
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
