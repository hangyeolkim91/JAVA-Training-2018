package com.rest;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class RestVO implements Serializable {
	
	private String name;
	private List<FoodVO> food = new Vector<FoodVO>();
	private boolean isSpecial;
	private String feature;
	private File img;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FoodVO> getFood() {
		return food;
	}
	public void setFood(List<FoodVO> food) {
		this.food = food;
	}
	
	
	
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	@Override
	public String toString() {
		String str =name;
		/*String str = "ÈÞ°Ô¼Ò¸í : " + name + "\n------------------------------------------\n";
		
		Iterator<FoodVO> it = food.iterator();
		while(it.hasNext()){
			FoodVO vo = it.next();
			str += vo.toString()+"\n";
		}*/
		
		return str;
	}
	

}
