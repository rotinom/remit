package com.rotinom.remit;

public class ChargeNumberItem {
	private String number_;
	private String description_;
	
	
	public ChargeNumberItem(String number, String desc){
		number_ = number;
		description_ = desc;
	}
	
	public String getNumber() {
		return number_;
	}
	public void setNumber(String number) {
		number_ = number;
	}
	public String getDescription() {
		return description_;
	}
	public void setDescription(String description) {
		description_ = description;
	}


}
