package DP;
import java.util.*; 
public class BOJ25418 {
	static Scanner sc = new Scanner(System.in); 
	static int start;
	static int end;
	
	static int[] dp; 
	
	//dp[i] = i일 때 최소 연산 개수 
		// = Math.min(dp[i/2]+1,dp[i-1] +1); 
	
	//start+1 ~ end 
	static void init() {
		start = sc.nextInt(); 
		end = sc.nextInt(); 
		dp = new int[end+1];
		Arrays.fill(dp,  1000001);
		dp[start] = 0;
		for(int i=start+1; i<=end; i++) {
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2], dp[i-1])+1; 
			}else {
				dp[i] = dp[i-1]+1; 
			}
		}
	}
	
	static void printDp() {
		for(int d : dp) {
			System.out.print(d+" ");
		}System.out.println();
	}
	
	public static void main(String[] args) {
		init();
		System.out.println(dp[end]);
		
	}
}
