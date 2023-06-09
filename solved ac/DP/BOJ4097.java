package DP;
import java.io.*;
import java.util.*; 
public class BOJ4097 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	static int n;
	static int[] benefits;
	static int[] dp;
	
	static void print(int[] arr) {
		for(int a: arr) {
			System.out.print(a+" ");
		}System.out.println();
	}
	
	static void init() throws IOException {
		n = Integer.valueOf(buffer.readLine());
		while(n!=0){
			benefits = new int[n];
			dp = new int[n];
			Arrays.fill(dp, -10001);
			
			for(int i=0; i<n; i++) {
				benefits[i] = Integer.valueOf(buffer.readLine());
			}
			tabulation();
			System.out.println(findMax());
			
			
			n = Integer.valueOf(buffer.readLine());
		}
		
		
		
		
	}
	
	static void tabulation() {
		dp[0] = Math.max(-10001, benefits[0]);
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+benefits[i], benefits[i]);
		}
	}
	
	static int findMax() {
		int result = Integer.MIN_VALUE;
		for(int d: dp) {
			result = Math.max(result, d);
		}
		return result;
	}
	
	//dp[i]i일까지 고려했을 때 최대 수익 
	//dp[i] = Math.max(dp[i-1]+benefits[i], benefits[i]);
	
	public static void main(String[] args)throws IOException{
		init();
		
	}

}
