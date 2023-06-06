package DP;
import java.util.*; 
public class BOJ17212 {
	static Scanner sc = new Scanner(System.in);
	static int n; 
	static int[] coins = {1,2,5,7}; 
	
	static int[] dp; 
	//dp[i] = 합이 i일 때 최소 동전의 개수 
	//dp[0] = 0; 
	//dp[1] = 1; 
	
	static void tabulation() {
		for(int i=1; i<=n; i++) {
			for(int coin : coins) {
				if(i<coin)continue; 
				
				dp[i] = Math.min(dp[i-coin]+1, dp[i]);
			}
		}
	}
	
	static void printDp() {
		for(int d: dp) {
			System.out.print(d+" ");
		}System.out.println();
	}
	
	static void init() {
		n= sc.nextInt(); 
		dp = new int[n+1];
		Arrays.fill(dp,  Integer.MAX_VALUE);
		dp[0] = 0; 
	}
	
	public static void main(String[] args) {
		init(); 
		tabulation(); 
		System.out.println(dp[n]);
		
	}
	
}
