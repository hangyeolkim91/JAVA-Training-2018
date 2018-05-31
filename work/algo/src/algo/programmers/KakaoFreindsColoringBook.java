package algo.programmers;

import java.awt.Point;
import java.util.Stack;


public class KakaoFreindsColoringBook {
	
	
	Point p;
	int[][] dir = {{0,1},{1,0},{0,-1}, {-1,0}}; // up right down left
	
/*	public void floodFill(int x, int y, int c, int[][] picture){
		
		if( c != picture[x][y]){
			return;
		}
		sizeOfOneArea++;
		picture[x][y] = 0;
		floodFill(x+1, y, c, picture);
		floodFill(x, y+1, c, picture);
		floodFill(x-1, y, c, picture);
		floodFill(x, y-1, c, picture);
		
		
	}*/
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int sizeOfOneArea = 0;
		
		Stack<Point> st = new Stack<Point>();
		

		int[][] copyOfPicture = new int[m+2][n+2];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				copyOfPicture[i+1][j+1] = picture[i][j];

			}
		}

		for(int i=1; i<m+1; i++){
			for(int j=1; j<n+1; j++){
				if(copyOfPicture[i][j] !=0 && copyOfPicture[i][j] !=-1 ){
					/*floodFill(i,j,copyOfPicture[i][j],copyOfPicture);
					numberOfArea++;
					if(maxSizeOfOneArea < sizeOfOneArea){
						maxSizeOfOneArea = sizeOfOneArea;
					}
					sizeOfOneArea = 0;*/
					
					Point p = new Point(i,j);
					st.push(p);
					sizeOfOneArea++;
					int color = copyOfPicture[i][j];
					copyOfPicture[i][j] = -1;
					
					while( !st.isEmpty() ){
						
						Point current = st.pop();
						Point before;
						if( st.isEmpty()){
							before = current;
						}else{
							before = st.peek();
						}
						
						boolean check = false;
						
						for(int k=0; k<4; k++){
							
							/*if( current.x+dir[k][0] == before.x && current.y + dir[k][1] == before.y){
								continue;
							}*/
							if(copyOfPicture[current.x+dir[k][0]][current.y+dir[k][1]] ==-1){
								continue;
								
							}
							
							if( copyOfPicture[current.x+dir[k][0]][current.y+dir[k][1]] == color){
								st.push(current);
								st.push(new Point(current.x+dir[k][0],current.y+dir[k][1]));
								check = true;
								sizeOfOneArea++;
								copyOfPicture[current.x+dir[k][0]][current.y+dir[k][1]] =-1;
								break;
							}
						}
						if( !check ){
							
							copyOfPicture[current.x][current.y] = 0;
							check = false;
						}
					}
					numberOfArea++;
					if(maxSizeOfOneArea < sizeOfOneArea){
						maxSizeOfOneArea = sizeOfOneArea;
					}
					sizeOfOneArea = 0;
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}

