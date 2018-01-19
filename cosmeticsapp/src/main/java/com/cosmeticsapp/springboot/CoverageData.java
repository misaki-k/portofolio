package com.cosmeticsapp.springboot;

public class CoverageData {
	private String id;
	private String txt;
	private String val;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTxt() {
		return txt;
	}
	
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public String getVal() {
		return val;
	}
	
	public void setVal(String val) {
		this.val = val;
		
		this.txt = val.toUpperCase();
	}
}
