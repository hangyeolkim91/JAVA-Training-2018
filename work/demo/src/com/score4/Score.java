package com.score4;

public interface Score {
	
	public void input();
	public boolean searchSid(String sid);
	public void print();
	
	public void delete();//����
	public void update();//���� ( �̸� ���� )
	public void findSid();//�й� �˻�
	public void findName();// �̸� �˻�
	
/*	public void searchSid();
	public void searchName();
	public void descSortTotal();
	public void ascSortSid();*/

}
