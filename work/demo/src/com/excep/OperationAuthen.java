package com.excep;

public class OperationAuthen {

	public void inputForm(String str) throws MyException{
		
		String temp[] = str.split(",");
		
		if( temp.length !=2){
			throw new MyException("���� �Է� ���� ����!: " + str);
		}
	}
	
	@SuppressWarnings("unused")
	public void number(String str) throws MyException{
		
		try {
			
			if(str.indexOf(".") != -1){
				double num = Double.parseDouble(str);
				
			}else{
				int num = Integer.parseInt(str);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyException("���� ��ȯ �Ұ� ! : " + str);
		}
	}
	
	public void operator(char ch) throws MyException{
		
		switch(ch){
		case '+':case '-':case '*':case '/':
			return;
		default:
			throw new MyException("������ ���� : " + ch);
		}
		
	}
}
