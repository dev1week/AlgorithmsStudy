

import java.util.*; 
import java.io.*;

public class swea11315 {
	 static int n; 
	 static char[][] map;
	 static int t;
	 static final char BLOCK = 'o';
	 static final char EMPTY = '.';
	 
	 static int[] dx = {-1,1,0,0,-1,-1,1,1};
	 static int[] dy = {0,0,-1,1,-1,1,1,-1};
	 
	static boolean inRange(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n; 
	}
	 
	static boolean isPossible(int sX, int sY) {
		//System.out.println("시작위치 "+sX+" "+sY);
		for(int dir = 0; dir<8; dir++) {
			
			int nX = sX; 
			int nY = sY;
			int count = 0;
			while(inRange(nX, nY)) {
				if(map[nX][nY]==EMPTY) {
					//System.out.println("not need to see"+nX+" "+nY);
					break;
				}
				count ++; 
				nX += dx[dir];
				nY += dy[dir];
				
			}
			
			if(count >=5) {
				//System.out.println("5end 위치"+nX+" "+nY+" " +count);
				return true; 
			}
		}
		
		return false; 
	}
	 
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		t = sc.nextInt(); 
		for(int testCase=1; testCase<=t; testCase++) {

            //입력부 
			n = sc.nextInt();
			map = new char[n][n];
			for(int x=0; x<n; x++) {
				String line = sc.next();
				for(int y=0; y<n; y++) {
					map[x][y] = line.charAt(y);
				}
			}
			boolean result = false;


			//맵 전체 순회 
			//o가 나올 때마다 판단 
				//맞으면 플래그 세우기 
			for(int x=0; x<n; x++) {
				for(int y=0; y<n; y++) {
					if(result) {break;}
					if(map[x][y]==BLOCK) {	
						if(isPossible(x,y)) {
							result = true;
						}
					}
				}
			}

            //출력부 
			//플래그 판단			
			if(result) {
				System.out.println("#"+testCase+" YES");
			}else {
				System.out.println("#"+testCase+" NO");
			}
 
		}
	}
	
	static void printMap() {
		for(char[] ma: map) {
			for(char m : ma) {
				System.out.print(m+" ");
			}System.out.println();
		}
	}
}

