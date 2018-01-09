package com.cosmeticsapp.springboot;

public class Data {
	
	
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	
	Data(){
	}
	
	Data(String ans1, String ans2, String ans3, String ans4){
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
	}
	
	
	public void setAnswer1(String answer1){
		this.ans1 = answer1;
	}
	
	public String getAnswer1() {
		return ans1;
	}
	
	public void setAnswer2(String answer2) {
		this.ans2 = answer2;
	}
	
	public String getAnswer2() {
		return ans2;
	}
	
	public void setAnswer3(String answer3) {
		this.ans3 = answer3;
	}
	
	public String getAnswer3() {
		return ans3;
	}
	
	public void setAnswer4(String answer4) {
		this.ans4 = answer4;
	}
	
	public String getAnswer4() {
		return ans4;
	}
	
	

}
