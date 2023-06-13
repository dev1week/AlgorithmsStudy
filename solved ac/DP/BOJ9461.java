package DP;
import java.util.*;

public class BOJ9461 {
	static Scanner sc = new Scanner(System.in); 
	static int[] dp; 
	static int n; 
	static final int MAX_SIZE = 100; 
	
	static void init() {
		dp = new int[MAX_SIZE+1]; 
		
		tabulation(); 
	}
	
	static void tabulation() {
		dp[1] = 1;
		dp[2] =1;
		dp[3] = 1;
		for(int i=4; i<=MAX_SIZE; i++) {
			dp[i] = dp[i-2]+dp[i-3]; 
		}
	}
	
	public static void main(String[] args) {
		init();
		int Q = sc.nextInt();
		StringBuilder sb = new StringBuilder(); 
		for(int query =0; query<Q; query++) {
			int num = sc.nextInt(); 
			sb.append(dp[num]+"\n");
		}
		System.out.println(sb);
	}

}
