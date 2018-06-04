package com.library2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;








public class LibraryImpl implements Library{
	
	private Map<Integer, BookVO> bmap = new HashMap<Integer, BookVO>();
	private int serialIndex = 0;
	
	
	@Override
	public boolean bookInput(String title, String author, String publisher) {
		BookVO bk = new BookVO();
		
		
		bk.setTitle( title);
		bk.setAuthor(author);
		bk.setLendDate("");
		bk.setLender("");
		bk.setRental(false);
		bk.setReturnDate("");
		bk.setPublisher(publisher);
		
		serialIndex = bmap.size()+1;
		bmap.put(serialIndex, bk);
		
		return true;
	}

	@Override
	public void init() throws IOException  {
		
		BufferedReader fr = new BufferedReader(new FileReader("Book.txt"));
		String line="";
		
		while( (line=fr.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line," ");
			BookVO bk = new BookVO();
			int sn = Integer.parseInt(st.nextToken());
			
			bk.setTitle(st.nextToken());
			bk.setAuthor(st.nextToken());
			bk.setPublisher(st.nextToken());
			bk.setRental(Boolean.parseBoolean(st.nextToken())); 
			
			if( st.hasMoreTokens()){
				bk.setLender(st.nextToken());
				bk.setLendDate(st.nextToken());
				bk.setReturnDate(st.nextToken());
			}else{
				bk.setLender("");
				bk.setLendDate("");
				bk.setReturnDate("");
			}
			
			
			bmap.put(sn, bk);
			
			
		}
		fr.close();
	}

	@Override
	public boolean lendBook(int serialNumber, String name) {
		
		BookVO bk = bmap.get(serialNumber);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR,7);
		
		
		if(bk == null || bk.isRental())
			return false;
		
		bk.setRental(true);
		bk.setLender(name);
		bk.setLendDate(sdf.format(now));
		bk.setReturnDate(sdf.format(cal.getTime()));
		
		
		bmap.put(serialNumber,bk);
		
		return true;
	}

	@Override
	public boolean returnBook(int serialNumber) {
		BookVO bk = bmap.get(serialNumber);
		
		if(bk == null || !bk.isRental())
			return false;
		
		bk.setRental(false);
		bk.setLender("");
		bk.setLendDate("");
		bk.setReturnDate("");
		
		bmap.put(serialNumber,bk);
		return true;
	}

	@Override
	public boolean deleteBook(int serialNumber) {
		bmap.remove(serialNumber);
		return true;
	}

	@Override
	public void saveData() throws IOException {
		
		BufferedWriter fw = new BufferedWriter(new FileWriter("Book.txt"));
		String str="";
		Set<Integer> keySet = bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO bk = bmap.get(key);
			str = key+" "+bk.toString();
			fw.write(str);
			fw.newLine();
		}
		
		fw.flush();
		fw.close();
	}

	
	@Override
	public void showBookList() {
		
		Set<Integer> keySet = bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		
		System.out.printf("%2s %s %s %s %s %s %8s %10s\n","번호", "책제목", "저자","출판사", "대출여부","대출한사람", "대출일자","반납예정일");
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO value = bmap.get(key);
			System.out.printf("%2d",key);
			System.out.println(value.toString());
			
		}
	}
	
	@Override
	public void showBookList(Map<Integer, BookVO> bmap) {
		
		Set<Integer> keySet = bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		
		System.out.printf("%2s %s %s %s %s %s %8s %10s\n","번호", "책제목", "저자","출판사", "대출여부","대출한사람", "대출일자","반납예정일");
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO value = bmap.get(key);
			System.out.printf("%2d",key);
			System.out.println(value.toString());
			
		}
	}

	@Override
	public Map<Integer, BookVO> searchByTitle(String title) {
		Set<Integer> keySet =bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		Map<Integer, BookVO> searchResult = new HashMap<Integer, BookVO>();
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO value = bmap.get(key);
			if(value.getTitle().equalsIgnoreCase(title)){
				searchResult.put(key, value);
			}
		}
		return searchResult;
	}

	@Override
	public Map<Integer, BookVO> searchByAuthor(String author) {
		Set<Integer> keySet =bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		Map<Integer, BookVO> searchResult = new HashMap<Integer, BookVO>();
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO value = bmap.get(key);
			if(value.getAuthor().equalsIgnoreCase(author)){
				searchResult.put(key, value);
			}
		}
		return searchResult;
	}

	@Override
	public Map<Integer, BookVO> searchByPublisher(String publisher) {
		Set<Integer> keySet =bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		Map<Integer, BookVO> searchResult = new HashMap<Integer, BookVO>();
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			BookVO value = bmap.get(key);
			if(value.getPublisher().equalsIgnoreCase(publisher)){
				searchResult.put(key, value);
			}
		}
		return searchResult;
	}

	@Override
	public List<BookVO> sortingByTitle() {
		List<BookVO> list = new ArrayList<BookVO>(bmap.values());
		Collections.sort(list);
		return list;
	}

	@Override
	public void showBookList(List<BookVO> list) {
		System.out.printf("%2s %s %s %s %s %s %8s %10s\n","번호", "책제목", "저자","출판사", "대출여부","대출한사람", "대출일자","반납예정일");
		Iterator<BookVO> it = list.iterator();
		int index = 1;
		while(it.hasNext()){
			System.out.printf("%2d",index);
			index++;
			BookVO bk = it.next();
			
			System.out.println(bk.toString());
		}
	}

}
