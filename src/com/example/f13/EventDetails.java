package com.example.f13;

import java.util.ArrayList;



public class EventDetails{
	public String name;
	public String date;
	public String desc;
	public  ArrayList<EventDetails>children=new ArrayList<EventDetails>();
	private int level;
	public void setLevel(int i)
	{
		level=i;
	}
	public ArrayList<EventDetails> getChildren() {			
		return children;
	}
	public int getLevel() {
		return level;		
	}
	public String getName() {
		return name;		
	}
	public String getDate() {
		return date;		
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDate(String date){
		this.date=date;
	}
	public void addChildren(EventDetails eve){			
		children.add(eve);
	}
	public String getDesc() {
		// TODO Auto-generated method stub
		
		return desc;
		
		
	}
	
}