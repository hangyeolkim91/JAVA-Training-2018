package com.headfirstoop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List<Guitar> guitars;
	
	public Inventory(){
		guitars = new LinkedList<Guitar>();
		
	}
	
	public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type,
			Wood backWood, Wood topWood, int numStrings){
		Guitar guitar = new Guitar( serialNumber,  price,new GuitarSpec(builder, model, type, backWood, topWood, numStrings));
		
		guitars.add(guitar);
	}
	public Guitar getGuitar(String serialNumber){
		
		for(Iterator<Guitar> i = guitars.iterator(); i.hasNext();){
			Guitar guitar = i.next();
			if(guitar.getSerialNumber().equals(serialNumber)){
				return guitar;
			}
		}
		return null;
	}
	
	public List<Guitar> search(GuitarSpec searchSpec){
		List<Guitar> matchingGuitars = new LinkedList<Guitar>();
		
		for(Iterator<Guitar> i = guitars.iterator(); i.hasNext();){
			Guitar guitar = i.next();
			// 일련번호는 유일한 값이니까 무시
			// 가격은 유일한 값이니까 무시
			
			GuitarSpec guitarSpec = guitar.getSpec();
			
			
			/*if( searchSpec.equals(guitarSpec) ){
				matchingGuitars.add(guitar);
			}*/
			
			if( guitar.getSpec().matches(searchSpec)){
				matchingGuitars.add(guitar);
			}
			
		}
		return matchingGuitars;
	}
}
