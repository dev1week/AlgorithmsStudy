package DP;
import java.util.*;

public class BOJ1904 {
	static Scanner sc = new Scanner(System.in); 
	static final int MAX_SIZE = 1000000; 
	static int[] dp;
	static int n; 
	
	//00또는 1이 쓰여있는 낱장의 타일들 
	//지원이가 만들 수 있는 모든 가짓수 
	
	
	//dp[i] = i개 사용했을 때 만들 수 있는 타일 갯수 
	//dp[1] = 1;
	//dp[2] = 00, 11    
	//dp[3] = 001, 111, 100,
	//dp[4] = 1001 0011, 1111, (0000, 1100
	
	//dp[i] = dp[i-1] + dp[i-2]
		//뒤에 숫자 1을 붙이는 경우의 수 + 뒤에 숫자 00을 붙이는 경우의 수 
	
	
	
	static void init() {
		n = sc.nextInt(); 
		dp = new int[MAX_SIZE+1];
		tabulation(); 
	}
	
	static void tabulation() {
		dp[1] =1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
	}
	
	
	
	public static void main(String[] args) {
		init(); 
		
		System.out.println(dp[n]);
	}
}
