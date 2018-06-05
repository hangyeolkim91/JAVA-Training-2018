package com.library2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Library lib = new LibraryImpl();
		int cmd;
		try {
			lib.init();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			System.out.println("-----------------------------------------------------------------");
			System.out.println("도서 관리 프로그램");
			System.out.println("1.등록 2.도서목록 3.대여 4.반납 5.삭제 6.검색 7.제목순정렬 8.종료 ?");
			System.out.println("-----------------------------------------------------------------");
			cmd = sc.nextInt();
			
			if(cmd == 1){
				System.out.println("책이름,저자,출판사를 입력해주세요.");
				String title = sc.next();
				String author = sc.next();
				String publisher = sc.next();
				lib.bookInput(title,author,publisher);
				lib.showBookList();
			}else if(cmd == 2){
				lib.showBookList();
			}else if (cmd == 3){
				int bnum;
				String name;
				
				lib.showBookList();
				System.out.println("대출 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				System.out.println("대출 할 사람의 이름을 입력해주세요");
				name = sc.next();
				
				if( !lib.lendBook(bnum, name) )
					System.out.println("빌릴 수 없는 책입니다!");
				
				
			}else if (cmd==4){
				int bnum;
				
				lib.showBookList();
				System.out.println("반납 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				
				
				if( !lib.returnBook(bnum))
					System.out.println("반납 할 수 없는 책입니다");
				
			}else if (cmd==5){
				int bnum;
				lib.showBookList();
				System.out.println("삭제 할 책 번호를 입력해주세요");
				bnum = sc.nextInt();
				
				lib.deleteBook(bnum);
				
			}else if(cmd == 6){
				System.out.println("검색 조건을 입력해주세요");
				System.out.println("\n 1.책이름 2.저자 3.출판사");
				
				cmd = sc.nextInt();
				if(cmd == 1){
					System.out.println("책 제목을 입력해주세요.");
					String title = sc.next();
					Map<Integer,BookVO> m = lib.searchByTitle(title);
					lib.showBookList(m);
				}else if ( cmd == 2){
					System.out.println("저자를 입력해주세요.");
					String author = sc.next();
					Map<Integer,BookVO> m = lib.searchByAuthor(author);
					lib.showBookList(m);
				}else if ( cmd == 3){
					System.out.println(" 출판사를 입력해주세요.");
					String publisher = sc.next();
					Map<Integer,BookVO> m = lib.searchByPublisher(publisher);
					lib.showBookList(m);
					
				}
				
			}else if(cmd == 7){
				List<BookVO> list = lib.sortingByTitle();
				lib.showBookList(list);
			}else if( cmd == 8){
				try {
					lib.saveData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
		}
	}

}
