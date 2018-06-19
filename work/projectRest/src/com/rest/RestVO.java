package com.rest;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class RestVO implements Serializable {
	
	private String name;
	private List<FoodVO> food = new Vector<FoodVO>();
	
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
