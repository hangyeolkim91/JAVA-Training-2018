package algo.exp;

class MethodTest{
// ���������� / ��ȯ���� �ڷ��� / �޼ҵ� �̸� / (�޼ҵ��� ����){
//	
// }
	public int methodName1(){
		
		int number = 1;
		
		return number;  // ��ȯ�� ���ϰ�
	}
	
	public int methodName2(int a){
		
		int number = 1;
		
		number += a;
		
		return number;  // ��ȯ�� ���ϰ�
	}
	
	public void methodName3(){
		System.out.println("���ڰ� ���� �޼ҵ�!!!");
		System.out.println("��ȯ���� ���� �޼ҵ�!!!");
	}
	
	public void methodName4(String arg){
		System.out.println(arg+"�� �ִ� �޼ҵ�!!!");
		System.out.println("��ȯ���� ���� �޼ҵ�!!!");
	}
	
	
}

public class Test {

	public static void main(String[] args) {
		
		MethodTest mt = new MethodTest();
		mt.methodName1();
		mt.methodName2(1);
		mt.methodName3();
		mt.methodName4("����");

	}

}
