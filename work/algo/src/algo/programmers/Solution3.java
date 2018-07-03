package algo.programmers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	Map<Character, BigInteger> hMap = new HashMap<Character, BigInteger>();
	
	public BigInteger nToDeci(String num , BigInteger n){
		
		BigInteger digit = new BigInteger("1");
		BigInteger res = new BigInteger("0");
		
		for(int i=num.length()-1; i>=0; i--){
			
			res = res.add(digit.multiply(hMap.get(num.charAt(i))));
			digit = digit.multiply(n);
			System.out.println(digit);
			System.out.println(res);
		}
		
		return res;
	}
	
	public String deciToN(BigInteger r, String rule, BigInteger n){
		String ans = "";
		
		if( r.equals(BigInteger.ZERO)){
			ans += rule.charAt(0);
			return ans;
		}
		
		while( r.compareTo( BigInteger.ZERO ) > 0){
			
			BigInteger i = r.remainder(n);
			ans =  rule.charAt(i.intValueExact()) + ans;
			r = r.divide(n);
		}
		
		
		return ans;
	}
	
	public String solution(String rule, String A, String B){
		String answer="";
		
		for(int i=0; i<rule.length(); i++){
			
			BigInteger bi = new BigInteger(Integer.toString(i));
			hMap.put(rule.charAt(i), bi);
			
			
		}
		BigInteger n = new BigInteger(Integer.toString(rule.length()));
		BigInteger a = nToDeci(A, n);
		BigInteger b = nToDeci(B, n);
		
		System.out.println(a + " : " + b);
		
		BigInteger r = a.subtract(b);
		System.out.println(r);
		answer = deciToN(r, rule, n);
		
		return answer;
	}
}
