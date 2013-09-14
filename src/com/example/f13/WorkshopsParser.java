package com.example.f13;

import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class WorkshopsParser extends DefaultHandler {
	Stack<WorkshopDetails> workshopStack = new Stack<WorkshopDetails>();
	WorkshopDetails workshop;
	ArrayList<WorkshopDetails> workshopList = new ArrayList<WorkshopDetails>();
	private boolean insideDate=false;
	private boolean insideDesc=false;
	private boolean insideName=false;
	private boolean insideEvent=false;
	public WorkshopsParser(ArrayList<WorkshopDetails> List) {
		this.workshopList = List;
	}
	public ArrayList<WorkshopDetails> getWorkshopList(){
		return workshopList;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (localName.equals("name")){			
			insideName=false;
		}
		if(localName.equals("date")){
			insideDate=false;
		}
		if(localName.equals("desc")){
			insideDesc=false;
		}
		if(localName.equals("event"))
			{
			insideEvent=false;
			//Log.d("Pop",workshopStack.peek().name);
			//workshopList.add(workshopStack.pop());
			//Log.d("End Event",eventStack.pop().cildren.get(0).name);			
			}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		
		if (localName.equals("name"))
			insideName = true;
		if (localName.equals("date")) {
			insideDate = true;
		}
		if (localName.equals("event")) {
			workshop = new WorkshopDetails();
			insideEvent = true;
			workshopList.add(workshop);
			//workshopStack.push(workshop);
			Log.d("Push", "pushed");
		}
		if (localName.equals("desc")) {
			insideDesc = true;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(insideName)
		{
			//EventDetails sub_eve=new EventDetails();			
					
			String str=new String(ch, start,length);
			Log.d("Add Chars",str);			
			//sub_eve.setName(str);
			//workshopStack.peek().children.add(sub_eve);
			int x=workshopList.size();
			workshopList.get(x-1).name=str;
			Log.d("Size", x+";"+workshopList.get(x-1).name);
		}
		if(insideDate){
			int x=workshopList.size();
			workshopList.get(x-1).date=new String(ch, start,length);
			
		/*	i++;
			if(i==1)
				i=0;*/
			//int x=eventStack.peek().children.size();
			//Log.d("Date", eventStack.peek().name+";"+eventStack.peek().children.get(x-1).date+";"+eventStack.peek().children.get(x-1).name);
			
		}
		if(insideDesc){
			int x=workshopList.size();			
			workshopList.get(x-1).desc=new String(ch, start,length);					
			Log.d("DESC", workshopList.get(x-1).desc);
		}
		
		
	}

}
