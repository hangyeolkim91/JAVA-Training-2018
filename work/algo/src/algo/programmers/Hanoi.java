package algo.programmers;


class Solution {

	int[][] answer = {};
	int index = -1;
	
	public void hanoi(int t1, int t2, int t3, int n){
		
		if( n <1){
			return;
		}
		hanoi(t1,t3,t2,n-1);
		System.out.println(t1+ " -> " + t2);
		index++;
		answer[index][0] = t1;
		answer[index][1] = t2;
		hanoi(t3,t2,t1,n-1);
		
		//return hanoi(1,2,n-1) + 1 + hanoi(2,3,n-1);
	}

	public int[][] solution(int n) {
		
		int size = (int)Math.pow(2, n);

		answer =new int[size-1][2];

		hanoi(1,3,2,n);
		return answer;
	}
}

public class Hanoi {

	public static void main(String[] args) {

		Solution s = new Solution();

		int[][] ans = s.solution(3);
		
		for(int[] i : ans){
			for(int j : i){
				System.out.print(j+ " ");
			}
			System.out.println();
		}
		//System.out.println(s.hanoi(1,3,15));

	}

}
