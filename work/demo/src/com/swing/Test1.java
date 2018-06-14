package com.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Test1 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test1(){
		
		lbl = new JLabel("메세지", JLabel.CENTER);
		
		getContentPane().add(lbl);
		
		//메뉴 추가
		
		JMenuBar mbar = new JMenuBar();
		JMenu menu;
		JMenuItem mi;
		
		menu = new JMenu("메세지 대화 상자");
		mi = new JMenuItem("메세지");
		mi.addActionListener(this);
		menu.add(mi);
		
		mi = new JMenuItem("입력");
		mi.addActionListener(this);
		menu.add(mi);
		
		mi = new JMenuItem("종료");
		mi.addActionListener(this);
		menu.add(mi);
		
		mbar.add(menu);
		
		setJMenuBar(mbar);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
			
		});
		
		setTitle("대화상자");
		setSize(300,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {

		new Test1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		
		if( str.equals("메세지") ){
			JOptionPane.showMessageDialog(this, "오늘은 목요일 입니다.","요일", JOptionPane.INFORMATION_MESSAGE);
		}else if ( str.equals("입력")){
			String age = JOptionPane.showInputDialog(this,"당신의 나이는?","나이 입력",JOptionPane.QUESTION_MESSAGE);
			
			lbl.setText("당신은 "+age + "살 이군요.");
		}else if ( str.equals("종료")){
			
			int result;
			
			result = JOptionPane.showConfirmDialog(this, "프로그램을 종료 하시겠습니까?","종료확인",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			System.out.println(JOptionPane.YES_OPTION);
			if( result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
			
		}
	}

}
