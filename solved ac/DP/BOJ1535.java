package DP;
import java.io.*;
import java.util.*; 
public class BOJ1535 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	static int n; 
	static int[] damages;
	static int[] values; 
	
	static int[] dp; // dp[i] 데미지 총합이 i일 때, 최대 가치 
	
	static void init() throws IOException{
		n = Integer.valueOf(buffer.readLine());
		dp = new int[99+1];
		damages = new int[n+1];
		values = new int [n+1];
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		for(int i=1; i<=n; i++) {
			damages[i] = Integer.valueOf(tokens.nextToken());  
		}
		tokens = new StringTokenizer(buffer.readLine());
		for(int i=1; i<=n; i++) {
			values[i] = Integer.valueOf(tokens.nextToken()); 
		}
	}
	
	static void tabulation() {
		for(int person =1; person<=n; person++) {
			for(int damage=99; damage>=0; damage--) {
				if(damage<damages[person])continue; 
				dp[damage] = Math.max(dp[damage], dp[damage-damages[person]]+values[person]);
			}
		}
	}
	
	static int findMax() {
		int result = 0;
		for(int d: dp) {
			result = Math.max(d,  result);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		
		init(); 
		
		tabulation(); 
		
		
		System.out.println(findMax());
	}

}
