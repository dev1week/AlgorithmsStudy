package DP;
import java.io.*;
import java.util.*; 
public class BOJ16493 {
	
	static int n; 
	static int m; 
	static int[] days;
	static int[] pages; 
	static int[] dp; // dp[i] = 날짜 합이 i일 때의 최대 페이지수    
	
	// Math.max(dp[i], dp[i-days[i]] + pages[i]
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken());
		
		
		days = new int [m+1];
		pages = new int[m+1]; 
		dp = new int[n+1];
		
		
		for(int chapter = 1; chapter<=m; chapter++) {
			tokens = new StringTokenizer(buffer.readLine());
			days[chapter] = Integer.valueOf(tokens.nextToken());
			pages[chapter] = Integer.valueOf(tokens.nextToken()); 
		}
	}
	
	static void tabulation() {
		for(int chapter =1; chapter <=m; chapter++) {
			for(int day=n; day>=0; day--) {
				if(day<days[chapter])continue; 
				dp[day] = Math.max(dp[day], dp[day-days[chapter]]+pages[chapter]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init(); 
		
		tabulation(); 
		
		System.out.println(print());
	}
	
	static int print() {
		int result = 0; 
		for(int d: dp) {
			result = Math.max(result, d);
		}
		
		return result; 
	}

}
