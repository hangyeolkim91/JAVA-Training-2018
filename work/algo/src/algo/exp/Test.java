package algo.exp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class MethodTest{
// 접근제한자 / 반환값의 자료형 / 메소드 이름 / (메소드의 인자){
//	
// }
	public int methodName1(){
		
		int number = 1;
		
		return number;  // 반환값 리턴값
	}
	
	public int methodName2(int a){
		
		int number = 1;
		
		number += a;
		
		return number;  // 반환값 리턴값
	}
	
	public void methodName3(){
		System.out.println("인자가 없는 메소드!!!");
		System.out.println("반환값이 없는 메소드!!!");
	}
	
	public void methodName4(String arg){
		System.out.println(arg+"가 있는 메소드!!!");
		System.out.println("반환값이 없는 메소드!!!");
	}
	
	
}

public class Test {

	public static void main(String[] args) throws IOException {
		
/*		MethodTest mt = new MethodTest();
		mt.methodName1();
		mt.methodName2(1);
		mt.methodName3();
		mt.methodName4("인자");
*/
		
		DataInputStream dis = new DataInputStream(System.in);
		int a = dis.read();
		System.out.println(a);
		
		
	}

}
