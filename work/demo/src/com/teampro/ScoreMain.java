package com.teampro;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class ScoreMain extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button btn1 = new Button("저장");
	private Button btn2 = new Button("종료");
	private String[] title = {"이름", "생일", "점수"};
	
	private TextField[] tf = new TextField[3];
	private TextArea ta = new TextArea();
	
	private Score s = new ScoreImpl();
	
	public ScoreMain(){
		
		
		
		
		setSize(600, 500);
		setVisible(true);
		setLayout(null);
		setTitle("성적처리");
		setResizable(true);
		
		
		for(int i=0; i<tf.length; i++){
			Label lb = new Label();
			lb.setBounds( (i+1)*100, 50, 30, 20);
			lb.setText(title[i]);
			add(lb);
			
			tf[i] = new TextField();
			tf[i].setBounds((i+1)*100 + 40, 50, 50, 20);
			add(tf[i]);
		}
		s.init();
		ta.setBounds(100, 80, 400, 400);
		add(ta);
		s.print(ta);
		
		btn1.setBounds(550, 50, 30, 20);
		add(btn1);
		btn1.addActionListener(this);
		
		btn2.setBounds(550, 80, 30, 20);
		add(btn2);
		btn2.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				s.saveAndExit();
			}
		});
		
		
	}

	public static void main(String[] args) {
		
		new ScoreMain();
		
/*		int ch;
		Scanner sc = new Scanner(System.in);
		
		Score s = new ScoreImpl();
		s.init();
		while(true){
			System.out.print("1.입력 2.출력 3.종료 =>");	
			ch = sc.nextInt();
			
			if( ch == 1){
				s.input();
			}else if( ch ==2){
				s.print();
			}else if(ch==3){
				s.saveAndExit();
				//System.exit(0);
			}
		}*/

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if( ob instanceof Button){
			Button b = (Button)ob;
			if(b==btn1){
				if( tf[0].getText() != "" && tf[1].getText() != "" && tf[2].getText() !="" ) {
					ScoreVO vo = new ScoreVO();
					vo.setName(tf[0].getText());
					vo.setBirth(tf[1].getText());
					vo.setScore(Integer.parseInt(tf[2].getText()));
					s.input(vo);
					s.print(ta);
				}
			}else if ( b == btn2) {
				s.saveAndExit();
			}
		}
	}

}
