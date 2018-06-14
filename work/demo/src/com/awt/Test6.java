package com.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test6 extends Frame implements ActionListener {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TextField tf1, tf2, res;
	private Button btnPlus, btnMinus, btnMulti, btnDiv;
	
	public Test6(){
		
		setLayout(new GridLayout(4,1));
		
		tf1 = new TextField();
		add(tf1);
		
		tf2 = new TextField();
		add(tf2);
		
		Panel p = new Panel();
		
		btnPlus = new Button("+");
		btnPlus.addActionListener(this);
		p.add(btnPlus);
		
		
		btnMinus = new Button("-");
		btnMinus.addActionListener(this);
		p.add(btnMinus);
		
		btnMulti = new Button("*");
		btnMulti.addActionListener(this);
		p.add(btnMulti);
		
		btnDiv = new Button("/");
		btnDiv.addActionListener(this);
		p.add(btnDiv);
		
		add(p);
		
		res = new TextField();
		add(res);
		
		setTitle("°è»ê±â");
		setSize(200,300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

		new Test6();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		
		if( ob instanceof Button ){
			try{
				Button b  = (Button) ob;
				
				int r=0, n1, n2;
				
				
				if( tf1.getText() == "" || tf2.getText() =="")
					return;
				
				n1 = Integer.parseInt(tf1.getText());
				n2 = Integer.parseInt(tf2.getText());
				
				if(b == btnPlus){
					r = n1 + n2;
					
				}else if ( b == btnMinus){
					r = n1 - n2;
				}else if ( b == btnMulti){
					r = n1 * n2 ;
					
				}else if ( b == btnDiv ){
					r = n1 / n2;
				}
				
				res.setText(Integer.toString(r));
			}catch(Exception exc){
				
			}
		}
		
	}

}
