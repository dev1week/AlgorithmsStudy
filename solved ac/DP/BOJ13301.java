package DP;
import java.util.*; 
public class BOJ13301 {
	
	static Scanner sc = new Scanner(System.in); 
	static final int MAX_SIZE = 80;
	static long[] dp = new long[MAX_SIZE+1]; 
	static int n; 
	
	//dp[i] = i번째 사각형의 길이 
	
	//둘레 = (dp[i] + dp[i-1])*2  dp[i] *2 
	
	
	public static void main(String[] args) {
		n = sc.nextInt(); 1
		
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println((dp[n]+dp[n-1])*2+dp[n]*2);
	}

}
