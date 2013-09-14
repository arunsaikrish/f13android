package com.example.f13;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class InfoDesc extends FragmentActivity {
int noc;
String[] listOfEvents;
static String [] eventdesc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// full screen
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_info_desc);
		Intent i = getIntent();
		String title = i.getStringExtra("title");
		noc=i.getIntExtra("children", 1);
		listOfEvents=i.getStringArrayExtra("ListOfEvents");
		eventdesc= i.getStringArrayExtra("eventsDesc");
		TextView eventtitle = (TextView) findViewById(R.id.title);
		eventtitle.setText(title);
		ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(new pageradapter());
	}
	
	public class pageradapter extends FragmentPagerAdapter
	{
		final int PAGE_COUNT = noc;
		public pageradapter()
		{
			super(getSupportFragmentManager());
		}
		@Override
		public Fragment getItem(int position) 
		{
			return PageFragment.create(position+1);
		}
		@Override
		public int getCount() 
		{
			return PAGE_COUNT;
		}
		public CharSequence getPageTitle(int position)
		{
			return listOfEvents[position]; 
		}
	}
	
	public static class PageFragment extends Fragment
	{
		public static final String ARG_PAGE="ARG_PAGE";
		private int mPage;
		
		public static PageFragment create(int page)
		{
			Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            PageFragment fragment = new PageFragment();
            fragment.setArguments(args);
            return fragment;
		}
		
		@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPage = getArguments().getInt(ARG_PAGE);
        }
 
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
        {
            View view = inflater.inflate(R.layout.fragment_page, container, false);
            TextView textView = (TextView) view.findViewById(R.id.tv1);
            //Log.d("check 1", "textView");
            String[] str=eventdesc[mPage-1].split(";");
            String s="\n";
            for(int i=0;i<str.length;i++)
            	s=s+str[i]+"\n\n";
            textView.setText(s);
            return view;
        }
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
		getMenuInflater().inflate(R.menu.info_desc, menu);
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
