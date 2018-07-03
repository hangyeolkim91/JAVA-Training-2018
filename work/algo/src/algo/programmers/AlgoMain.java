package algo.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlgoMain {

	public static void main(String[] args) {

/*		KakaoFreindsColoringBook sol = new KakaoFreindsColoringBook();
		int[][] picture = { {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[][] picture = { {1, 1, 1, 0}, {1, 1, 1, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}};
		int[][] picture = new int[100][100];
		for(int[] i : picture){
			Arrays.fill(i, 1);
		}
		
		for(int[] i : picture){
			for(int p : i){
				System.out.print(p+ " ");
			}
			System.out.println();
		}
		int[] answer = sol.solution(6, 4, picture);
		
		System.out.println(Arrays.toString(answer));*/
		
/*		KakaoBrian kb = new KakaoBrian();
		String sentence = "HaEaLaLaObWORLDb";
		System.out.println(kb.solution(sentence));*/
		
		
		Solution3 s = new Solution3();
		long a = 10000000000L;
		int b = (int)a%26;
		System.out.println(b);
		String rule = "abcdefghij";
		String A ="jjjjjjjjjj";
		String B = "bbbbbbbbbb";
		String r =s.solution(rule, A, B);
		System.out.println(r);
	}

}
