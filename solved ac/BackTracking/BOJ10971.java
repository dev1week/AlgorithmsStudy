package BackTracking;
import java.util.*;

class Pair{
	int start;
	int end;
	
	public Pair(int start, int end) {
		this.start = start;
		this.end = end; 
	}
	
	public String toString() {
		
		return start +"->"+end;
	}
}

public class BOJ10971 {
	static Scanner sc = new Scanner(System.in); 
	
	static int[][] w;
	static boolean[][] isUsed; 
	static int n; 
	static int result;
	
	static void init() {
		n = sc.nextInt(); 
		
		w = new int[n][n]; 
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				w[x][y] = sc.nextInt(); 
			}
		}
		isUsed= new boolean[n][n];
		result = Integer.MAX_VALUE; 
	}
	
	static void bt(int cur) {
		if(cur==n+1) {
			//뽑아놓은 루트로 전체 비용 계산
			return;
		}
		
		for(int next=0; next<n; next++) {
			
		}
	}
	
	public static void main(String[] args) {
		init();
		
		//bt로 경로 정하기 n개 n개 뽑기 
			
	}
}
