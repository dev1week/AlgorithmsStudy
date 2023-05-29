package DP;


import java.util.*; 
public class BOJ2670 {
	static Scanner sc = new Scanner(System.in); 
	
	static double[] dp;
	//dp[i] =i 번째 수를 고려했을 때 최대 연속 곱 
	//dp[i] = Math.max(dp[i-1]*numbers[i] , numbers[i]);
	static double[] numbers; 
	static int n; 
	
	static void init() {
		n = sc.nextInt();
		
		numbers = new double[n];
		dp = new double[n];
		
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextDouble(); 
		}
	}
	
	static void tabulation() {
		dp[0] = numbers[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]*numbers[i], numbers[i]);
		}
	}
	
	static void print() {
		for(double d : dp) {
			System.out.print(d+" ");
		}System.out.println();
	}
	
	static void find() {
		double result = Double.MIN_VALUE;
		for(double d: dp) {
			result = Math.max(result, d);
			
		}
		System.out.println(String.format("%.3f", result));
	}
	
	public static void main(String[] args) {
		init();
		tabulation(); 
		find();
	}

}
