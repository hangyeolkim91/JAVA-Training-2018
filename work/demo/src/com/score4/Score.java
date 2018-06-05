package com.score4;

public interface Score {
	
	public void input();
	public boolean searchSid(String sid);
	public void print();
	
	public void delete();//삭제
	public void update();//수정 ( 이름 제외 )
	public void findSid();//학번 검색
	public void findName();// 이름 검색
	
/*	public void searchSid();
	public void searchName();
	public void descSortTotal();
	public void ascSortSid();*/

}
