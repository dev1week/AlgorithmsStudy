package DP;
import java.util.*; 
import java.io.*; 

public class BOJ25706 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer tokens; 
	static int n; 
	static int[] heights; 
	static int[] dp; 
	
	//dp[i] = i번째에서 출발했을 때 몇 개의 칸을 밟는지 
		//dp[1] = dp[2] + 1 
		//dp[2] = dp[4]+1
		//dp[3] = dp[4] + 1 
		//dp[4] = dp[7] + 1 
		//dp[5] = dp[7] + 1 
		//dp[6] = dp[7] + 1
		//dp[7] = dp[8] + 1
		//dp[8] = dp[12] + 1; 
		//dp[9] = dp[10] + 1;	
		//dp[i] = dp[i+heights[i]+1] + 1; 
					//현재위치 + 점프거리 + 기본전진 거리 
	
	static void init() throws Exception{
		tokens = new StringTokenizer(buffer.readLine());
		
		n = Integer.valueOf(tokens.nextToken()); 
		heights = new int[n+1]; 
		tokens = new StringTokenizer(buffer.readLine());
		for(int i=1; i<=n; i++) {
			heights[i] =  Integer.valueOf(tokens.nextToken());
		}
		dp = new int[200001]; 
	}
 
	static void tabulation() {
		for(int i=n; i>=0; i--) {
			if(isValid(i+heights[i]+1)) {
				dp[i] = dp[i+heights[i]+1]+1; 
			}else {
				dp[i] = 1; 
			}
		}
	}
	
	static boolean isValid(int x) {
		return x>=0&&x<=n; 
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=n; i++) {
			sb.append(dp[i]+" ");
		}System.out.println(sb);
	}
	public static void main(String[] args) throws Exception{
		
		init(); 
		
		tabulation();
		
		print();
		//i+heights[i] = 유효하다면 
			//	dp[i] = dp[i+heights[i]]+1
		//유효하지 않다면
			// dp[i] = 1;
	}
}
