package Recursive;
import java.io.*;
import java.util.*; 

public class BOJ1074 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	static int n; 
	static int r;
	static int c;
	
	//상태 r, c, count
	
	static int func(int n, int r, int c) {
		//2^n일 때의 r,c의 방문순서 반환 
		int size = (int)Math.pow(2, n);
		int half = size/2;
		int areaSize = half*half; 
		
		if(n==0) {
			return 0; 
		}
		
		if(r<half&&c<half){
			return func(n-1, r, c);
		}else if(r<half&&c>=half) {
			return func(n-1,r, c-half)+areaSize; 
		}else if(r>=half&&c<half) {
			return func(n-1, r-half, c)+2*areaSize;
		}else {
			return func(n-1, r-half, c-half)+3*areaSize; 
		}
		//베이스 컨디션 
		//n==0 
			//return 0;
		
		//재귀식 
		 //r,c가 1번 사각형 내부에 있을   = func(n-1, r,c);  
		//2번 사각형 내부 = half*half + func(n-1, r, c-half);
		//3번 사각형 내부 = 2*half*half + func(n-1, r-half, c);
		//4번 사각형 내부 = 3*half*half + func(n-1, r-half, c-half); 		
	}
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
		
		n = Integer.valueOf(tokens.nextToken());
		r = Integer.valueOf(tokens.nextToken());
		c = Integer.valueOf(tokens.nextToken()); 
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		init(); 
		
		System.out.println(func(n,r,c)); 
	}
}
