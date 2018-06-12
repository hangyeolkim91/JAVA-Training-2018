package com.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test2 extends Frame implements WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Test2() {
		// TODO Auto-generated constructor stub
		setTitle("자바 윈도우");
		setSize(200,300);
		
		//addWindowListener(this);
		
		setVisible(true);
		addWindowListener(this);
		
		
	}

	public static void main(String[] args) {

		new Test2();
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}
