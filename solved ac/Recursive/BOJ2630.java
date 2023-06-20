package Recursive;
import java.io.*;
import java.util.*; 

class Count{
	int blue;
	int white; 
	
	
	public Count(int blue, int white) {
		this.blue = blue;
		this.white = white; 
	}
	
	public Count add(Count other) {
		return new Count(this.blue+other.blue, this.white+other.white); 
	}
	
	public String toString() {
		return this.white+"\n"+this.blue; 
	}
}


public class BOJ2630 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	static int n; 
	
	static int[][] map;
	static final int BLUE=1;
	static final int WHITE = 0; 
	
	
	static Count count(int offsetX, int offsetY, int size ) {
		//점화식 
		//count(offsetX, offsetY, size) = count(offsetX, offsetY, size/2) + count(offsetX-size/2, offsetY, size/2)
										// +count(offsetX, offsetY-size/2, size/2) + count(offsetX-size/2, offsetY-size/2, size/2); 
		for(int x=offsetX; x<offsetX+size; x++) {
			for(int y=offsetY; y<offsetY+size; y++) {
				if(map[x][y]!=map[offsetX][offsetY]) {
					return count(offsetX, offsetY, size/2)
								.add(count(offsetX+size/2, offsetY, size/2))
								.add(count(offsetX, offsetY+size/2, size/2))
								.add(count(offsetX+size/2, offsetY+size/2, size/2));
								
				}
			}
		}
		
		
	
		//종료 조건 
			// 조사한 범위가 전부 같은 색일 경우
				//흰색일 경우
					//return new Count(0,1);
				//파란색일 경우 
					//return new Count(0,1);
		
		if(map[offsetX][offsetY]==BLUE ) {
			return new Count(1,0);
		}else {
			return new Count(0,1);
		}
		
		
		
			
	
	}		
	
	//상태
		//(offsetX, offsetY, size) 가 주어졌을 때 파란색 종이와 흰색 종이의 수 반환 
	//함수정의 
	
	//종료 조건 
	
	//점화식 
	
	
	
	
	static void init()throws IOException{
		n = Integer.valueOf(buffer.readLine()); 
		
		map = new int[n][n]; 
		StringTokenizer tokens; 
		for(int x=0; x<n; x++) {
			tokens = new StringTokenizer(buffer.readLine()); 
			for(int y=0; y<n; y++) {
				map[x][y] = Integer.valueOf(tokens.nextToken()); 
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		init();
		
		System.out.println(count(0,0,n)); 
	}
	
	
	
}
