package com.library2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Library {

	public boolean bookInput(String title, String author,String publisher);
	public void init() throws IOException;
	public boolean lendBook(int serialNumber, String name);
	public boolean returnBook(int serialNumber);
	public boolean deleteBook(int serialNumber);
	public void saveData() throws IOException;
	public void showBookList();
	public void showBookList(Map<Integer, BookVO> bmap);
	public void showBookList(List<BookVO> list);
	public Map<Integer, BookVO> searchByTitle(String title);
	public Map<Integer, BookVO> searchByAuthor(String author);
	public Map<Integer, BookVO> searchByPublisher(String publisher);
	public List<BookVO> sortingByTitle();
	
	
}
