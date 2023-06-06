package DP;
import java.util.*;

public class BOJ14606 {
	
	static int n; 
	static long[] dp; 
	static Scanner sc = new Scanner(System.in);
	//n 
	//dp[i] =i개를 2개의 탑으 분리시켰을 때 즐거움의 최대치 
	
	
	//dp[1] = 0; 분리시킬 수 없음 
	
	//dp[2] = 1; 
	
	//dp[3] = 2*1 + 1*1  = 3 
			// = 2*1 + dp[2]
	
	//dp[4] =  4+ dp[2] + dp[2] = 6
			// 3 + dp[3] + dp[1] = 6  
	
	//dp[5] = 3*2 + dp[3] + dp[2] = 10 
			// 4*1 + dp[4] + dp[1] = 10 
	
	//dp[6] = 4*2 + dp[4] + dp[2]  = 15 
			// 5*1 + dp[5] + dp[1] = 15 
	
	//dp[7] = 5*2 + dp[5] + dp[2] = 21 
			// 6*1 + dp[6] + dp[1] = 21 
	
	//dp[8] = 6*2 + dp[6] + dp[2] = 28 
			// 7*1 + dp[7] + dp[1] = 28
	//dp[i] = (i-2)*2 + dp[i-2] + dp[2] 
			// (i-1)*1 + dp[i-1] + dp[1]
	static final int MAX_SIZE = 1000000000;
	
	static void init() {
		n = sc.nextInt(); 
		dp = new long [n+1];
		
	}
	
	static void tabulation() {
		dp[1] = 0;
		if(n>=2) {
			dp[2] = 1; 
			
			for(int i=2; i<=n; i++) {
				dp[i] = Math.max((i-2)*2+dp[i-2]+dp[2], (i-1)+dp[i-1]+dp[1]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		init();
		tabulation(); 
		System.out.println(dp[n]);
	}
	
	
}
