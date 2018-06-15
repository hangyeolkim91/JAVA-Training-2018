package com.network;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest1 extends Frame implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private ServerSocket serverSock = null;
	private Socket sock = null;
	
	public ServerTest1(){
		add(ta,BorderLayout.CENTER);
		
		
		tf.addActionListener(this);
		tf.requestFocus();
		add(tf,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("ä�� ����");
		setSize(300,400);
		setVisible(true);
		
		//serverStart();
	}

	public static void main(String[] args) {

		new ServerTest1().serverStart();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// ���� �����͸� ���� ��
		
		String str = tf.getText();
		if(str.trim().equals(""))
			return;
		if(sock == null)
			return;
		
		
		
		try {
		
			PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);
			pw.println("[����] :"+str);
			
			ta.append("\n[����] :" + str);
			tf.setText("");
			tf.requestFocus();
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			ta.append("\n Ŭ���̾�Ʈ�� ���� ����");
			sock = null;
			e2.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		// �����͸� ���� ��
		String str;
		String ip;
		
		try {
			
			if( sock == null){
				return;
			}
			InputStream is = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			ip = sock.getInetAddress().getHostAddress();
			
			
			
			while( (str = br.readLine()) !=null){
				ta.append("\n["+ip+"]: " + str);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			ta.append("\n Ŭ���̾�Ʈ ���� " );
			//sock = null;
			sock = null;
			e.printStackTrace();
		}
		
	}
	
	public void serverStart(){
		
		try {
			serverSock = new ServerSocket(5555);
			
			ta.append("��������");
			
			sock = serverSock.accept();
			
			System.out.println(sock.getInetAddress().getHostAddress()+" ����");
			Thread th = new Thread(this);
			th.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
