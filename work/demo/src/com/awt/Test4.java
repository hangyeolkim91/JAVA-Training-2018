package com.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 extends Frame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button btn;
	private TextArea ta;
	private TextField tf;
	
	public Test4() {
		// TODO Auto-generated constructor stub
		
		btn = new Button("Ãß°¡");
		ta = new TextArea();
		tf = new TextField();
		
		add(tf,BorderLayout.NORTH);
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
		
		
		setTitle("window"); 
		setVisible(true);
		setSize(200,300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}
	public static void main(String[] args) {

		new Test4();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob instanceof Button || ob instanceof TextField){
			
			String str = tf.getText();
			
			if( !str.equals("")){
				ta.append(str+"\n");
				
			}
			tf.setText("");
			tf.requestFocus();
			
		}
	}

}
