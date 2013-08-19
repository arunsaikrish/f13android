package com.example.f13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class FirstFragment extends Fragment {
	
	static Button mButton;
	static View buttId;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//Button next = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.button1);
		/**next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Hi");
			}
		});**/
		//View root = (View) inflater.inflate(R.layout.mainfrag, null);
		//View root=(LinearLayout) inflater.inflate(R.layout.mainfrag, container, false);
		
		/**final Button next = (Button) root.findViewById(R.id.button1);
	
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Hola");
				next.setText("hello");
			}
		});**/
		
		//return (LinearLayout) inflater.inflate(R.layout.mainfrag, container, false);
		
		LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.mainfrag,
                container, false);

		// note that we're looking for a button with id="@+id/myButton" in your inflated layout
		// Naturally, this can be any View; it doesn't have to be a button
		mButton = (Button) mLinearLayout.findViewById(R.id.mybutton);
		buttId=mLinearLayout.findViewById(R.id.mybutton);
		
		mButton.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        // here you set what you want to do when user clicks your button,
		        // e.g. launch a new activity
		    	/*mButton.setText("finally!");
		    	System.out.println("hola");*/
		    	Intent i = new Intent(getActivity(), EventList.class);
		    	startActivity(i);
		    }
		});
		
		// after you've done all your manipulation, return your layout to be shown
		return mLinearLayout;
				
	}
	
     
}