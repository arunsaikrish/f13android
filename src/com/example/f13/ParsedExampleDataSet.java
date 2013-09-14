package com.example.f13;





public class ParsedExampleDataSet {
	private String extractedString = "";
	private int extractedInt = 0;

	public String getExtractedString() {
		return extractedString;
	}
	public void setExtractedString(String extractedString) {
		this.extractedString += extractedString;
	}

	public int getExtractedInt() {
		return extractedInt;
	}
	public void setExtractedInt(int extractedInt) {
		this.extractedInt = extractedInt;
	}
	
	public String toString(){
		return "ExtractedString =  "+ this.extractedString+ "ExtractedInt = " + this.extractedInt;
	}
}