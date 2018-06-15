package com.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTest2 {

	private ArrayList<Socket> clients = new ArrayList<Socket>();
	
	public void serverStart(){
		try {
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("���� ���� .....");
			
			while(true){
				Socket sc = ss.accept();
				
				WorkThread wt = new WorkThread(sc);
				System.out.println(wt.getName());
				wt.start();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	
	class WorkThread extends Thread{
		
		private Socket sc;
		
		public WorkThread(Socket sc){
		
			this.sc = sc;
		}
		
		@Override
		public void run() {
			
			String ip = null;
			String msg = null;
			
			
			try {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				ip = sc.getInetAddress().getHostAddress();
				
				//������ Ŭ���̾�Ʈ
				clients.add(sc);
				
				// �ٸ� Ŭ���̾�Ʈ���� ���� ����� �˸�
				msg = ip + "]�� �����߽��ϴ�.!";
				for(Socket s : clients){
					
					if(s == sc)
						continue;
					
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
				}
				System.out.println(msg);
				
				//����
				
				while( (msg = br.readLine()) != null){
				
					for(Socket s : clients){
						
						if(s == sc)
							continue;
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
						System.out.println(msg);
					}
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
				
				msg = ip + "]�� �����Ͽ����ϴ�";
				try {
					
					for(Socket s : clients){
						
						if(s == sc)
							continue;
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					System.out.println(msg);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
			
		}
	}
	
	public static void main(String[] args) {

		ServerTest2 ob = new ServerTest2();
		ob.serverStart();
	}

}
