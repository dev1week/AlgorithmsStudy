package simulation;
import java.io.*;
import java.util.*;

public class BOJ12739 {
	//색바꾸기 
		//1. 앙옆에 칠해진 색이 모두 같거나 모두 다르다면 현재 위치를 파란색으로 
		//else
			//2. 빨강색이 2개 칠해지고 초록색인 경우 현재 위치를 빨강색으로
			//3. 초록색이 2개이고 파란색이 1개인 경우 현재 위치를 빨강색으로 
			//4. 파랑색이 2개이고 빨강색이 1개 인경우 현재 위치를 빨강색으로 
			//나머지 모든 경우는 초록색으로 
	
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	static int n;
	static int k; 
	static String current;
	
	static int resultRed; 
	static int resultBlue;
	static int resultGreen; 
	
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		k = Integer.valueOf(tokens.nextToken());
		
		current = buffer.readLine();
		
	}
	
	static String change() {
		StringBuilder next = new StringBuilder("");
		for(int currentIdx=0; currentIdx<current.length(); currentIdx++) {
			int blueCount = 0;
			int redCount = 0;
			int greenCount = 0; 
			
			for(int offset=-1; offset<=1; offset++) {
				int neighbor = currentIdx + offset; 
				if(neighbor<0) {
					neighbor = current.length()-1;
				}else if(neighbor>current.length()-1) {
					neighbor = 0;
				}
				
				if(current.charAt(neighbor)=='R') {
					redCount ++; 
				}else if(current.charAt(neighbor)=='G') {
					greenCount ++;
				}else if(current.charAt(neighbor)=='B') {
					blueCount ++;
				}
			}
			//양 옆 == 현재 위치 색이 모두 같은 경우 
			if((redCount ==3||blueCount==3||greenCount==3)||(redCount==1&&blueCount==1&&greenCount==1)) {
				next.append('B');
			}else {
				if(isValid(redCount, blueCount, greenCount)) {
					next.append('R');
				}else {
					next.append('G');
				}
			}
			//
		}
		return next.toString();
	}
	
	static boolean isValid(int redCount, int blueCount, int greenCount) {
		return (redCount ==2 && greenCount==1)||
				(greenCount==2 && blueCount==1)||
				(blueCount==2 && redCount ==1);
	}
	
	static void count() {
		for(int i=0; i<current.length(); i++) {
			if(current.charAt(i)=='B') {
				resultBlue ++;
			}else if(current.charAt(i)=='G') {
				resultGreen ++;
			}else {
				resultRed ++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		for(int i=0; i<k; i++) {
			current = change(); 
			
		}
		
		count();
		
		System.out.println(resultRed+" "+resultGreen+" "+resultBlue);
	}

}
