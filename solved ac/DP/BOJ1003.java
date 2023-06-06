package DP;
import java.util.*; 
public class BOJ1003 {
	static Scanner sc = new Scanner(System.in);
	static final int N = 40; 
	
	static int[][] dp; 
	
	
	
	//dp[i][0] i를 인자로 넘겼을 때 0을 출력하는 횟수 
	//dp[i][1] i를 인자로 넘겼을 때 1을 출력하는 횟수 
	
	//dp[0][0] = 1
	//dp[0][1] = 0
	
	//dp[1][0] = 0;
	//dp[1][1] = 1;
	
	//dp[2][0] = dp[1][0] + dp[0][0] = 1
	//dp[2][1] = dp[1][1] + dp[0][1] = 1
	
	//dp[3][0] = dp[2][0] + dp[1][0] = 1
	//dp[3][1] = dp[2][1] + dp[1][1] = 2 
	
	//dp[i][0] = dp[i-1][0] + dp[i-2][0] 
	//dp[i][1] = dp[i-1][1] + dp[i-2][1]
	
	
	static void init() {
		
		dp = new int[N+1][2];
		
		tabulation(); 
	}
	
	static void tabulation() {
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=2; i<=40; i++) {
			for(int x=0; x<=1; x++) {
				dp[i][x] = dp[i-2][x] + dp[i-1][x];
			}
		}
	}
	
	public static void main(String[] args) {
		init(); 
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder(); 
		for(int query = 0; query<q; query++) {
			int number = sc.nextInt(); 
			sb.append(dp[number][0]+" "+dp[number][1]+" \n");
		}
		
		System.out.println(sb);
	}
}
