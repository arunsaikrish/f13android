package com.example.f13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Workshops extends FragmentActivity{

	int noc;
	static String[] listOfWorkshops;
	static String[] workshopsDesc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workshops);
		Intent i=getIntent();
		listOfWorkshops=i.getStringArrayExtra("workshops");
		workshopsDesc=i.getStringArrayExtra("desc");
		//Log.d("Frag", "added");
		TextView tv=(TextView)findViewById(R.id.tvWorkshops);		
		ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
		tv.setText("WORKSHOPS");
		viewpager.setAdapter(new pageradapter());
	}
	
	public class pageradapter extends FragmentPagerAdapter
	{
		final int PAGE_COUNT = listOfWorkshops.length;
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
			return listOfWorkshops[position]; 
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
            String[] str=workshopsDesc[mPage-1].split(";");
            String s="\n";
            for(int i=0;i<str.length;i++)
            	s=s+str[i]+"\n\n";
            
            textView.setText(s);
            return view;
        }
	}

}
