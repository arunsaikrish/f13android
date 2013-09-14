package com.example.f13;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Contacts extends Activity{
	String[] names={"Sivas Subramaniyan","Jude Naveen Raj", "Mohamed Fasil", "Sindhura Siravan", "Suraj Barthy", "Aditya Narayanan", "Karthik Moorthi", "Harish Jp", "Kandha Raj", "Gautham Eshwar", "Rahul Joshi", "Afdal Basheer", "Karthika Ramesh", "Aditya Narayanan", "Divya Rangan", "Sponsorship Queries", "Pranav Sankar", "Pradeep Varma"}; 
	String[] desigs={"Chairman", "Head, Csg", "Cultural Secretary", "Head, Events", "Head, Design", "Head, Content", "Head, FSR", "Head, Public Relations", "Organising Head", "Head, Hospitality", "Head, Workshops", "Head, Publicity", "Head, Marketing", "Head, Media", "Head, Treasurer", "", "Overall coordinator", "Head, Marketing"};
	String[] emails= {"chairman@festember.com", "csg@festember.com", "cultsec@festember.com", "events@festember.com", "design@festember.com", "content@festember.com", "fsr@festember.com", "pr@festember.com", "organizing@festember.com", "hospitality@festember.com", "workshops@festember.com", "publicity@festember.com", "marketing@festember.com", "media@festember.com", "treasurer@festember.com", "", "oc@festember.com", "marketing@festember.com"};
	String[] phnums= {"+91 9486001186", "+91 8903627333", "+91 7299156060", "+91 8903454379", "+91 9566216861", "+91 9600544395", "+91 8056515050", "+91 9791761592", "+91 8807604965", "+91 9445567665", "+91 7418259520", "+91 7200582343", "+91 9445191650", "+91 9600544395", "+91 9677343948", "+91 7708534339", "+91 9486560693", "+91 7708534339"};
	ArrayList<ContactDetails> nameList=new ArrayList<ContactDetails>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		ContactDetails ctc;
		for(int i=0; i<names.length;i++)
		{
			ctc=new ContactDetails(names[i],desigs[i],emails[i],phnums[i]);
			nameList.add(ctc);
		}
		GridView gv=(GridView)findViewById(R.id.gv);
		MyAdapter adp=new MyAdapter(nameList,this);
		gv.setAdapter(adp);
	}
	
	class ContactDetails
	{
		public
			String name;
			String desig;
			String email;
			String phnum;
			
			ContactDetails(String s, String t, String v, String w)
			{
				name=s;
				desig=t;
				email=v;
				phnum=w;
				
			}
	};

	class MyAdapter extends BaseAdapter{
		ArrayList<ContactDetails> list;
		Context context;
		public MyAdapter(ArrayList<ContactDetails> splist,Context c) {
			// TODO Auto-generated constructor stub
			list=splist;
			context=c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View row=convertView;
			
			if (row == null) {
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.sponsors_grid_cell, parent, false);
			}
			TextView tv1,tv2;
			
			
			
			tv1 = (TextView) row.findViewById(R.id.tvContact);
			tv2 = (TextView) row.findViewById(R.id.tvName);
			// detail = (TextView) row.findViewById(R.id.detail);
			// i1=(ImageView)row.findViewById(R.id.img);
			//iv.setImageResource(list.get(position).imageId);
			/*if (position % 2 == 0) {
				ll.setGravity(Gravity.RIGHT);
				tile.setTextColor(Color.RED);
			} else {
				ll.setGravity(Gravity.LEFT);
				tile.setTextColor(Color.BLUE);
			}
			// detail.setText(Detail[position]);
			// i1.setImageResource(imge[position]);
	*/		tv2.setText(list.get(position).name);	
			tv1.setText("\n"+list.get(position).desig+"\n"+list.get(position).email+"\n"+list.get(position).phnum);
			return (row);
		}
		
	}
	
		
}
