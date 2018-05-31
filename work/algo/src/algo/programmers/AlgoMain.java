package algo.programmers;

import java.util.Arrays;

public class AlgoMain {

	public static void main(String[] args) {

		KakaoFreindsColoringBook sol = new KakaoFreindsColoringBook();
		//int[][] picture = { {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[][] picture = { {1, 1, 1, 0}, {1, 1, 1, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}, {0, 0, 0, 2}};
		/*int[][] picture = new int[100][100];
		for(int[] i : picture){
			Arrays.fill(i, 1);
		}*/
		
		for(int[] i : picture){
			for(int p : i){
				System.out.print(p+ " ");
			}
			System.out.println();
		}
		int[] answer = sol.solution(6, 4, picture);
		
		System.out.println(Arrays.toString(answer));
	}

}
