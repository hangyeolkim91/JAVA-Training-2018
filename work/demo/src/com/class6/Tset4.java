package com.class6;

interface Test{
	
	public int total();
	public void write();
	
}

class TestImpl implements Test{

	private String sid,name;
	private int kor, eng;
	
	public TestImpl(){ // 기본 생성자
		
	}
	
	public TestImpl(String sid, String name, int kor, int eng){
		/*this.sid = sid;
		this.name = name;
		this.kor = kor;
		this.eng = eng;*/
		set(sid,name,kor,eng);
	}
	
	public void set(String sid, String name, int kor, int eng){
		this.sid = sid;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	@Override
	public int total() {
		return kor+eng;
	}

	@Override
	public void write() {
		System.out.println(sid+" : " + name + "\ntotal : " + total());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean flag= false;
		
		if(obj instanceof TestImpl){
			TestImpl t = (TestImpl) obj;
			
			if(this.sid.equals(t.sid) && this.name.equals(t.name)){
				flag = true;
			}
		}
		
		return flag;
	}
	
}

public class Tset4 {

	public static void main(String[] args) {

		TestImpl ob = new TestImpl();
		ob.set("1234", "abc", 12,21);
		ob.write();
		
		Test ob1 = new TestImpl("9876", "hello", 20, 30);
		ob1.write();
		
		Test ob2 = new TestImpl("9876", "hello", 20, 30);
		ob2.write();
		
		if( ob1.equals(ob2))
			System.out.println("ob1과 ob2는 동일 인물..");
		else
			System.out.println("ob1과 ob2는 다른 인물..");
		
	}

}
