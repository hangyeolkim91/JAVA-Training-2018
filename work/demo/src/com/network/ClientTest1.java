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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTest1 extends Frame implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();

	private Socket sock = null;
	private int port = 5555;
	private String host = "192.168.16.13";//127.0.0.1 localhost
	
	public ClientTest1(){
		add(ta,BorderLayout.CENTER);
		
		
		tf.addActionListener(this);
		tf.requestFocus();
		add(tf,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				/*try {
					sock.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				System.exit(0);
			}
		});
		
		setTitle("ä�� Ŭ���̾�Ʈ");
		setSize(300,400);
		setVisible(true);
		
		//connect();
		
	}

	public static void main(String[] args) {

		new ClientTest1().connect();
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
			pw.println("���Ѱ�]"+str);
			
			ta.append("\n���Ѱ�]" + str);
			tf.setText("");
			tf.requestFocus();
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			ta.append("\n ������ ���� ����");
			sock = null;
			e2.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		// �����͸� ���� ��
		String str;
		
		
		try {
			
			if( sock == null){
				return;
			}
			InputStream is = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			while( (str = br.readLine()) !=null){
				ta.append("\n" + str);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			ta.append("\n ���� ���� " );
			sock = null;
			e.printStackTrace();
		}
		
	}
	

	public void connect(){
		
		try {
			
			sock = new Socket(host,port);
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� ����");
		}
	}

}
