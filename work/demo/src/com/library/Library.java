package com.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class Library {

	//private ArrayList<Book> blist = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	private Map<Integer, Book> bmap = new HashMap<Integer, Book>();
	private int serialIndex = 0;
	private String[] rentalMsg = {"대여중","대여가능"};
	//private Command comd;
	
	public void start(){
		try {
			init();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int cmd;
		while(true){
			System.out.println("도서 관리 프로그램");
			System.out.println("1.등록 2.도서목록 3.대여 4.반납 5.삭제 6.종료 ?");
			cmd = sc.nextInt();
			
			if(cmd == 1){
				input();
				showBookList();
			}else if(cmd == 2){
				showBookList();
			}else if (cmd == 3){
				int bnum;
				String name;
				
				showBookList();
				System.out.println("대출 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				System.out.println("대출 할 사람의 이름을 입력해주세요");
				name = sc.next();
				
				if( !lendBook(bnum, name) )
					System.out.println("빌릴 수 없는 책입니다!");
				
				
			}else if (cmd==4){
				int bnum;
				
				showBookList();
				System.out.println("반납 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				
				
				if( !returnBook(bnum))
					System.out.println("반납 할 수 없는 책입니다");
				
			}else if (cmd==5){
				int bnum;
				showBookList();
				System.out.println("삭제 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				
				deleteBook(bnum);
				
			}else if( cmd == 6){
				try {
					saveData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
		}
	}
	
	private void input(){
		
		Book bk = new Book();
		
		System.out.println("책 이름?");
		bk.title = sc.next();
		
		System.out.println("저자?");
		bk.author = sc.next();
		
		bk.isRental = false;
		bk.lender = "";
		bk.lendDate ="";
		bk.returnDate ="";
		
		serialIndex++;
		bmap.put(serialIndex, bk);
		
		
	}
	
	private void showBookList(){
		Set<Integer> keySet = bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		
		System.out.printf("%s %15s %15s %15s %15s %15s %15s\n","번호", "책 제목", "저자", "대출여부","대출한사람", "대출일자","반납예정일");
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			Book value = bmap.get(key);
			System.out.printf("%4d %20s %15s",key , value.title , value.author);
			if( value.isRental){
				System.out.printf(" %15s", rentalMsg[0]);
			}else{
				System.out.printf(" %15s", rentalMsg[1]);
			}
			System.out.printf(" %15s %25s %15s\n",value.lender ,value.lendDate , value.returnDate);
		}
	}
	
	private boolean lendBook(int snum, String name){
		Book bk = bmap.get(snum);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR,7);
		
		
		if(bk == null || bk.isRental)
			return false;
		
		bk.isRental = true;
		bk.lender = name;
		bk.lendDate = sdf.format(now);
		bk.returnDate = sdf.format(cal.getTime());
		
		bmap.put(snum,bk);
		return true;
	}
	
	private boolean returnBook(int snum){
		Book bk = bmap.get(snum);
		
		if(bk == null || !bk.isRental)
			return false;
		
		bk.isRental = false;
		bk.lender = "";
		bk.lendDate ="";
		bk.returnDate="";
		
		bmap.put(snum,bk);
		return true;
	}
	
	private boolean deleteBook(int snum){
		bmap.remove(snum);
		return true;
	}
	
	private void saveData() throws IOException{
		BufferedWriter fw = new BufferedWriter(new FileWriter("book.txt"));
		String str="";
		Set<Integer> keySet = bmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()){
			Integer key = keyIterator.next();
			Book bk = bmap.get(key);
			str = key+","+bk.title + ","+ bk.author + ","+ bk.isRental + "," + bk.lender + "," + bk.lendDate + "," + bk.returnDate;
			fw.write(str);
			fw.newLine();
		}
		
		fw.flush();
		fw.close();
	}
	
	private void init() throws IOException{
		BufferedReader fr = new BufferedReader(new FileReader("book.txt"));
		String line="";
		
		while( (line=fr.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line,",");
			Book bk = new Book();
			int sn = Integer.parseInt(st.nextToken());
			
			bk.title = st.nextToken();
			bk.author = st.nextToken();
			bk.isRental = Boolean.parseBoolean(st.nextToken());
			
			if( st.hasMoreTokens()){
				bk.lender = st.nextToken();
				bk.lendDate = st.nextToken();
				bk.returnDate = st.nextToken();
			}else{
				bk.lender = "";
				bk.lendDate = "";
				bk.returnDate = "";
			}
			
			
			bmap.put(sn, bk);
			
			
		}
		fr.close();
	}
}
