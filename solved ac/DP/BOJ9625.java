package DP;
import java.util.*; 
public class BOJ9625 {
	final static int A = 0;
	final static int B = 1; 
	static int[][] dp; 
	
	static int n;
	static int MAX_COUNT = 45;
	
	static Scanner sc = new Scanner(System.in); 
	
	static void init() {
		n = sc.nextInt(); 
		dp = new int[n+1][2];
		
		dp[0][A] = 1;
		dp[0][B] = 0; 
	}
	
	
	public static void main(String[] args) {
		init(); 
		
		for(int i=1; i<=n; i++) {
			dp[i][A] = dp[i-1][B];
			dp[i][B] = dp[i-1][A]+dp[i-1][B];
		}
		
		System.out.println(dp[n][A]+" "+dp[n][B]);
	}
	
	
	//dp 번 눌렀을 때 A혹은 B의 개수 
	
	//dp[0][0] = 1;
	//dp[0][1] = 0; 
	
	//dp[1][0] = 0;
	//dp[1][1] = 1; 
	
	//dp[2][0] = 1;
	//dp[2][1] = 1; 
	
	
	//dp[3][0] = 1;
	//dp[3][1] = 2; 
	
	//dp[i][A] = dp[i-1][B];
	//dp[i][B] = dp[i-1][B]+dp[i-1][A]; 

}
