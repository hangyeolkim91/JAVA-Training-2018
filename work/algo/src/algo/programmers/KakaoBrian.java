package algo.programmers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



class Symbol{
	char sym;
	int count;
	
	@Override
	public String toString() {
		return sym + " " + count;
	}
}

public class KakaoBrian {
	
	List<Symbol> list = new ArrayList<Symbol>();
	
	public void count(String sentence){
		char sym = 'a';
		
		for(int i = sym ; i<='z'; i++){
			int indx=0;
			Symbol symbol = new Symbol();
			char s = (char)i;
			while( (indx=sentence.indexOf(s,indx)) != -1){
				symbol.count++;
				symbol.sym = s;
				indx++;
			}
			if(symbol.count >0){
				list.add(symbol);
			}
		}
	}
	public String solution(String sentence){
		
		String answer="";
		
		count(sentence);
		
		Iterator<Symbol> it = list.iterator();
		while(it.hasNext()){
			
			if(answer.equals("invalid"))
				break;
			
			Symbol sy = it.next();
			String word;
			
			if( sy.count >2){
				
				word = sentence.substring(sentence.indexOf(sy.sym)-1, sentence.lastIndexOf(sy.sym)+1);
				for(int i=0; i<word.length(); i++){
					if( i%2 == 0 ){
						if(word.charAt(i) >='A' && word.charAt(i) <='Z')
							answer += word.charAt(i);
						else{
							answer="invalid";
							break;
						}
					}else if ( i%2 == 1 ){
						
						if( word.charAt(i) != sy.sym){
							answer = "invalid";
							break;
						}
						
					}
				}
			}else if ( sy.count == 2){
				word = sentence.substring(sentence.indexOf(sy.sym), sentence.lastIndexOf(sy.sym));
				if( word.length() == 3 ){
					
				}else{
					
				}
			}
		}
		
		
		return answer;
	}

}
