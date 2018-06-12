package com.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame implements ActionListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private TextField[] tf = new TextField[4];
	
	private Label result = new Label("", Label.LEFT);
	private Button btn1;
	private Button btn2;
	
	public Test5() {
		// TODO Auto-generated constructor stub
		
		String[] title = {"이름", "국어", "영어", "수학","총점"};
		
		btn1 = new Button("결과");
		btn2 = new Button("종료");
		
		btn1.setBounds(180,30, 60, 20);
		btn1.addKeyListener(new KeyHandler());
		
		add(btn1);
		btn2.setBounds(180,60, 60, 20);
		add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setTitle("성적 처리");
		setLayout(null); // 레이아웃 초기화 ( 수동 배치 ) 좌표 사용
		
		for(int i=0; i<title.length; i++){
			Label lbl = new Label();
			lbl.setText(title[i]);
			lbl.setBounds(10,(i+1)*30,50,20);
			add(lbl);
			
			if( i !=4){
				tf[i] = new TextField();
				tf[i].setBounds(80,(i+1)*30,70,20);
				tf[i].addKeyListener(new KeyHandler());
				add(tf[i]);
			}else{
				result.setBounds(80,(i+1)*30, 70,20);
				add(result);
			}
			
		}
		
		setSize(260,180);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

		new Test5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if( ob instanceof Button){
			Button b = (Button)ob;
			if( b == btn1 ){
				excute();
			}else{
				System.exit(0);
			}
		}
		
	}

	private void excute(){
		int sum=0;
		try {
			for(int i=1; i<4; i++){
				sum += Integer.parseInt(tf[i].getText());
			}
		} catch (Exception e2) {
			// TODO: handle exception
			result.setText("입력오류");
		}
		
		
		result.setText(Integer.toString(sum));
	}
	
	class KeyHandler extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			
			Object ob = e.getSource();
			
			if( e.getKeyCode() != KeyEvent.VK_ENTER){
				return;
			}
			
			if( ob instanceof Button){
				Button b = (Button) ob;
				
				if( b == btn1){
					excute();
					
					
				}
				return;
			}
			
			if( ob instanceof TextField){
				TextField t = (TextField)ob;
				
				for(int i=0; i<tf.length;i++){
					if( i !=3 && tf[i] == t){
						tf[i+1].requestFocus();
						return;
					}else if(tf[3] == t){
						btn1.requestFocus();
						return;
					}
				}
			}
		}
		
		
	}
}
