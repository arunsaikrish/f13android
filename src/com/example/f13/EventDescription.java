package com.example.f13;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventDescription extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_description);
		Intent i = getIntent();
		String title = i.getStringExtra("title");
		TextView eventtitle = (TextView) findViewById(R.id.title);
		eventtitle.setText(title);
		ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(new pageradapter());
	}
	
	public class pageradapter extends FragmentPagerAdapter
	{
		final int PAGE_COUNT = 5;
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
			return "Page: " + (position+1); 
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
            textView.setText("Fragment #" + mPage);
            return view;
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}