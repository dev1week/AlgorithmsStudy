import java.io.*;
import java.util.*; 


public class Main {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	static final int TOTAL_NUM = 11; 
	
	static int[][] players; 
	static boolean[] isUsed; 
	//player[포지션번호][적합도] 
	
	static int result; 
	static StringTokenizer tokens; 
	
	
	static void bt(int cur, int totalScore) {
		if(cur==TOTAL_NUM+1) {
			result = Math.max(result,  totalScore); 
		}
		
		for(int next=1; next<=TOTAL_NUM; next++) {
			if(!isUsed[next]&&players[next][cur]!=0) {
				isUsed[next] = true; 
				bt(cur+1, totalScore+players[next][cur]); 
				isUsed[next] = false; 
			}
		}
		
		
		
	}
	static void init() throws IOException{
		players = new int[TOTAL_NUM+1][TOTAL_NUM+1];
		isUsed = new boolean[TOTAL_NUM+1]; 
		result = 0;
		
		
		for(int x=1; x<TOTAL_NUM+1; x++) {
			tokens = new StringTokenizer(buffer.readLine());
			for(int y=1; y<TOTAL_NUM+1; y++) {
				players[x][y] = Integer.valueOf(tokens.nextToken()); 
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		
		int t = Integer.valueOf(buffer.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		for(int test=1; test<=t; test++) {
		
			init();
			bt(1, 0); 
			sb.append(result+"\n"); 
		}
		//능력치 합의 최대값 찾기
		
		
		System.out.println(sb); 
		
		
	}
}
