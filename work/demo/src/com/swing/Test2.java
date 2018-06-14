package com.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Test2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField[] tf = new JTextField[4];
	private JButton btnAdd, btnExit;
	private JTable table;
	
	private File f = new File("swingTable.txt");
	
	
	
	public Test2() {

		getContentPane().setLayout(null);
		
		String[] caption = {"이름", "영어", "국어", "수학"};
		
		for(int i=0; i<caption.length; i++){
			JLabel lbl = new JLabel(caption[i]);
			lbl.setBounds(10,(i+1)*30,50,20);
			getContentPane().add(lbl);
			
			tf[i] = new JTextField();
			tf[i].setBounds(80,(i+1)*30, 70,20);
			getContentPane().add(tf[i]);
		}
		
		btnAdd = new JButton("추가");
		btnAdd.setBounds(10,160,60,20);
		btnAdd.addActionListener(this);
		getContentPane().add(btnAdd);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(90,160,60,20);
		btnExit.addActionListener(this);
		getContentPane().add(btnExit);
		
		addTable();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				writeFile();
				System.exit(0);
			}
		});
		
		setTitle("성적처리");
		setSize(550,250);
		setVisible(true);
		
		
	}
	
	private void addTable(){
		
		String[] title = {"이름", "영어", "국어","수학","총점","평균"};
		
		MyTableModel model = new MyTableModel(title);
		
		
		
		
		if( !f.exists()){
			table = new JTable(model);
		}
		else{
			
			try {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				table = (JTable) ois.readObject();
				
				if(table == null){
					
					table = new JTable(model);
					
				}
				ois.close();
				
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		JScrollPane scp = new JScrollPane(table);
		
		scp.setBounds(160,30,330,150);
		getContentPane().add(scp);
		
		//컬럼 크기 자동변경 off
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//컬럼 폭 지정
		for(int i=0; i<title.length; i++){
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55);
		}
		
		
	}
	
	public static void main(String[] args) {

		new Test2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if( ob instanceof JButton){
			JButton b = (JButton) ob;
			try {
				
				if(b == btnAdd){
					process();
				}else if ( b == btnExit){
					writeFile();
					System.exit(0);
				}
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	private void writeFile(){
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			
			oos.writeObject(table);
			
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void process(){
		String[] data = new String[6];
		int tot=0;
		
		try {
			
			data[0] = tf[0].getText();
			
			for(int i=1; i<4; i++){
				data[i]	= tf[i].getText();
				tot += Integer.parseInt(tf[i].getText());
			}
			data[4] = Integer.toString(tot);
			data[5] = Integer.toString(tot/3);
			
			((MyTableModel)table.getModel()).addRow(data);
			
			//tf 초기화
			
			for(int i=0; i<tf.length; i++){
				tf[i].setText("");
			}
			tf[0].requestFocus();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	class MyTableModel extends DefaultTableModel implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;


		private String[] title;
		
		//의존성 주입		
		public MyTableModel(String[] title) {

			this.title = title;
			
		}
		
		@Override
		public int getColumnCount() {
			
			if(title== null || title.length==0){
				return 0;
			}
			return title.length;
		}
		
		@Override
		public String getColumnName(int column) {
			
			if(title== null || title.length==0){
				return null;
			}
			
			return title[column];
			
		}
		
	}
}
