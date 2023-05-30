package DP;
import java.util.*; 
public class BOJ2839 {
	
	static Scanner sc = new Scanner(System.in); 
	
	static int[] candidates = {3,5};
	static int[] dp;
	
	//dp[i] = 무게합이 i일 때 최소 설탕 봉지 개수 
	static final int MAX_SIZE = 5000;
	static int n; 
	
	static void init() {
		n = sc.nextInt(); 
		dp = new int[MAX_SIZE+1];
		
		Arrays.fill(dp, 2000);
	}
	
	static void tabulation() {
		dp[3] = 1;
		dp[5] = 1; 
		
		for(int i=1; i<=n; i++) {
			for(int candidate : candidates) {
				if(i<candidate)continue; 
				dp[i] = Math.min(dp[i], dp[i-candidate]+1);
			}
		}
	}
	
	static void print() {
		for(int d: dp) {
			System.out.print(d+" ");
		}System.out.println();
	}
	public static void main(String[] args) {
		init(); 
		tabulation();
		if(dp[n]==2000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
	}

}
