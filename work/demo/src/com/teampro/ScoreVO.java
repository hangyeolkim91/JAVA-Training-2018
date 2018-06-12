package com.teampro;

import java.io.Serializable;

public class ScoreVO implements Serializable{

	private String name;
	private String birth;
	private int score;
	
	
	@Override
	public String toString() {
		return name + "\t" + birth + "\t" + score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
