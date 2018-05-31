package com.class5;

//Singleton
//Calendar now = Calendar.getInstance();

class Sing{
	public static Sing ob = new Sing();
	
	public static int  b = 1;
	
	private int a = 10;
	
	public static Sing getInstance(){
		
		/*if( ob == null){
			ob = new Sing();
		}*/
		
		return ob;
	}
	
	public int getA(){
		return a;
	}
}

public class Test5 {

	public static void main(String[] args) {
		
		System.out.println(Sing.ob.getA());

/*		Sing si = Sing.getInstance();
		Sing si2 = Sing.getInstance();
		
		if(si == si2){
			System.out.println("µø¿œ ∞¥√º");
		}else{
			System.out.println("¥Ÿ∏• ∞¥√º");
		}
		
		System.out.println(si.getA());
		System.out.println(si2.getA());*/
		
	}

}
