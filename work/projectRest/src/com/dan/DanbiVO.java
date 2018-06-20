package com.dan;

import java.io.Serializable;

public class DanbiVO implements Serializable{
	
	
	private String  iname;
	private String  iwitch;
	private String  imenu;
	private String  iprice;
	
	
	
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIwitch() {
		return iwitch;
	}
	public void setIwitch(String iwitch) {
		this.iwitch = iwitch;
	}
	public String getImenu() {
		return imenu;
	}
	public void setImenu(String imenu) {
		this.imenu = imenu;
	}
	public String getIprice() {
		return iprice;
	}
	public void setIprice(String iprice) {
		this.iprice = iprice;
	}
	
	@Override
	public String toString() {
		
		String str;
		
		str = String.format("%6s,%6s,%6s,%6s", iname,iwitch,imenu,iprice);
		
		return str;
	}
	
	
	
	
}


