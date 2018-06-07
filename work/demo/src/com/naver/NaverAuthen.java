package com.naver;

public class NaverAuthen{
	
	public void id(String id) throws Exception{
		
		/*if( id.length() < 8 || id.length() > 15){
			throw new Exception("id는 8자 이상 15자 이내여야 합니다.");
		}
		
		boolean isEng = false;
		boolean isNumber = false;
		
		for( int i=0; i<id.length(); i++){
			
			if( id.charAt(i) >= 'a' && id.charAt(i) <= 'z'){
				isEng=true;
			}
			if( id.charAt(i) >= 'A' && id.charAt(i) <= 'Z'){
				isEng=true;
			}
			
			if( id.charAt(i) >='0' && id.charAt(i) <='9'){
				isNumber = true;
			}
		}
		
		if( !isEng ||  !isNumber){
			throw new Exception("아이디 형식이 맞지 않습니다.");
		}*/
		
		String idReg = "([\\p{Digit}+\\p{Alpha}+]{8,15})|([\\p{Alpha}+\\p{Digit}+]{8,15})";
		
		if( !id.matches(idReg))
			throw new Exception("아이디 형식이 맞지 않습니다.");
		
		
	}
	
	public void pwCheck(String pw1, String pw2) throws Exception{
		if( !pw1.equals(pw2)){
			throw new Exception("비밀 번호가 같지 않습니다.");
		}
	}

}
