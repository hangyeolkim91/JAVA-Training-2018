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
			System.out.println("���� ���� ���α׷�");
			System.out.println("1.��� 2.������� 3.�뿩 4.�ݳ� 5.���� 6.�˻� 7.��������� 8.���� ?");
			System.out.println("-----------------------------------------------------------------");
			cmd = sc.nextInt();
			
			if(cmd == 1){
				System.out.println("å�̸�,����,���ǻ縦 �Է����ּ���.");
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
				System.out.println("���� �� å ��ȣ�� �Է����ּ���");
				bnum = sc.nextInt();
				System.out.println("���� �� ����� �̸��� �Է����ּ���");
				name = sc.next();
				
				if( !lib.lendBook(bnum, name) )
					System.out.println("���� �� ���� å�Դϴ�!");
				
				
			}else if (cmd==4){
				int bnum;
				
				lib.showBookList();
				System.out.println("�ݳ� �� å ��ȣ�� �Է����ּ���");
				bnum = sc.nextInt();
				
				
				if( !lib.returnBook(bnum))
					System.out.println("�ݳ� �� �� ���� å�Դϴ�");
				
			}else if (cmd==5){
				int bnum;
				lib.showBookList();
				System.out.println("���� �� å ��ȣ�� �Է����ּ���");
				bnum = sc.nextInt();
				
				lib.deleteBook(bnum);
				
			}else if(cmd == 6){
				System.out.println("�˻� ������ �Է����ּ���");
				System.out.println("\n 1.å�̸� 2.���� 3.���ǻ�");
				
				cmd = sc.nextInt();
				if(cmd == 1){
					System.out.println("å ������ �Է����ּ���.");
					String title = sc.next();
					Map<Integer,BookVO> m = lib.searchByTitle(title);
					lib.showBookList(m);
				}else if ( cmd == 2){
					System.out.println("���ڸ� �Է����ּ���.");
					String author = sc.next();
					Map<Integer,BookVO> m = lib.searchByAuthor(author);
					lib.showBookList(m);
				}else if ( cmd == 3){
					System.out.println(" ���ǻ縦 �Է����ּ���.");
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
