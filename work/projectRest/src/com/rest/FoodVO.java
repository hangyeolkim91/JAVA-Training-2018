package com.rest;

import java.io.Serializable;

public class FoodVO implements Serializable{

	private int price;
	private String name;
	private int count;
	private double rating;
	private double total;
	private String season;
	
	private boolean isChang;
	private boolean isYoung;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	
	public boolean isChang() {
		return isChang;
	}
	public void setChang(boolean isChang) {
		this.isChang = isChang;
	}
	
	public boolean isYoung() {
		return isYoung;
	}
	public void setYoung(boolean isYoung) {
		this.isYoung = isYoung;
	}
	
	
	@Override
	public String toString() {
		String str = "메뉴명:"+name + "\t가격: " + price + "\t평점 : " + rating + "\t계절메뉴: " + season;
		if(isChang){
			str += " 창렬";
		}else if ( isYoung){
			str += " 영자";
		}
		return str;
	}
	
	
}
