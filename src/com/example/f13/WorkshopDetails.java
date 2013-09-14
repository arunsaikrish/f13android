package com.example.f13;

import java.util.ArrayList;

public class WorkshopDetails {
	public String name;
	public String date;
	public String desc;
	public  ArrayList<WorkshopDetails> children=new ArrayList<WorkshopDetails>();
	private int level;
	public void setLevel(int i)
	{
		level=i;
	}
	public ArrayList<WorkshopDetails> getChildren() {			
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
	public void addChildren(WorkshopDetails eve){			
		children.add(eve);
	}
	public String getDesc() {
		return desc;		
	}
}
