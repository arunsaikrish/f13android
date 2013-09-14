package com.example.f13;





import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;






public class EventsParser extends DefaultHandler{

	// ===========================================================
	// Fields
	// ===========================================================
	Stack<EventDetails> eventStack=new Stack<EventDetails>();
	EventDetails event;
	
	private boolean insideEvent= false;
	private boolean nameInsideEvent=false;
	//private boolean insideSubEvent=false;
	private boolean insideName = false;
	private boolean insideDate=false;
	private boolean insideDesc=false;
	ArrayList<EventDetails> eventList=new ArrayList<EventDetails>();
	private int i=0;
	
	
	//private ParsedExampleDataSet myParsedExampleDataSet = new ParsedExampleDataSet();

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public EventsParser(ArrayList<EventDetails> eventList) {
		this.eventList=eventList;
	}

	/*public ParsedExampleDataSet getParsedData() {
		return this.myParsedExampleDataSet;
	}*/

	// ===========================================================
	// Methods
	// ===========================================================
	@Override
	public void startDocument() throws SAXException {
		//this.myParsedExampleDataSet = new ParsedExampleDataSet();
	}

	

	/** Gets be called on opening tags like: 
	 * <tag> 
	 * Can provide attribute(s), when xml was like:
	 * <tag attribute="attributeValue">*/
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		
		/*if (localName.equals("event")) {
			// Extract an Attribute
			String attrValue = atts.getValue("level");
			int i = Integer.parseInt(attrValue);
			myParsedExampleDataSet.setExtractedInt(i);
		}*/
		if(localName.equals("name")) {			
				insideName=true;			
		}
		if(localName.equals("event_name"))
			nameInsideEvent=true;
		if(localName.equals("date")) {
			insideDate=true;
		}
		if(localName.equals("event"))			
		{
			event=new EventDetails();			
			insideEvent=true;
			
			eventStack.push(event);
			Log.d("Push", "pushed");
		}
		if(localName.equals("desc")){
			insideDesc=true;
		}
	}
	
	/** Gets be called on closing tags like: 
	 * </tag> */
	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if(localName.equals("event_name"))
			nameInsideEvent=false;
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
			Log.d("Pop",eventStack.peek().name);
			eventList.add(eventStack.pop());
			//Log.d("End Event",eventStack.pop().children.get(0).name);			
			}
	}
	
	@Override
	public void endDocument() throws SAXException {
		
		//EventDetails temp=new EventDetails();
		//temp=
		//if(temp.children.get(0)!=null)
		
		
	}
	
	public ArrayList<EventDetails> getEventList(){
		return eventList;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if(nameInsideEvent)
			{
				String str=new String(ch, start, length);
				eventStack.peek().setName(str);
				Log.d("Add Event Name",str);
			}
					
		
		if(insideName)
		{
			EventDetails sub_eve=new EventDetails();			
			//myParsedExampleDataSet.setExtractedString(new String(ch, start, length));		
			String str=new String(ch, start,length);
			Log.d("Add Chars",str);			
			sub_eve.setName(str);
			eventStack.peek().children.add(sub_eve);
			int x=eventStack.peek().children.size();
			Log.d("Size", x+";"+eventStack.peek().children.get(x-1).name);
		}
		if(insideDate){
			int x=eventStack.peek().children.size();
			eventStack.peek().children.get(x-1).date=new String(ch, start,length);
			
		/*	i++;
			if(i==1)
				i=0;*/
			//int x=eventStack.peek().children.size();
			Log.d("Date", eventStack.peek().name+";"+eventStack.peek().children.get(x-1).date+";"+eventStack.peek().children.get(x-1).name);
			
		}
		if(insideDesc){
			int x=eventStack.peek().children.size();			
			eventStack.peek().children.get(x-1).desc=new String(ch, start,length);					
			Log.d("DESC", eventStack.peek().name+";"+eventStack.peek().children.get(x-1).desc+";"+eventStack.peek().children.get(x-1).name);
		}
		/*if(insideDate){
			Log.d("Date",eventStack.peek().getChildren()+"");
		}*/
			
			
	}
	
	
	
}