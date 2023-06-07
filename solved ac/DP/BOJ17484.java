package DP;
import java.util.*;
import java.io.*; 
public class BOJ17484 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	static int n; 
	static int m; 
	static StringTokenizer tokens;
	
	static int[][] map; 
	
	static int[][] dp; 
	
	static int[] dy = {-1,0,1}; 
	
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken());
		
		
		map = new int[n][m]; 
		dp = new int [n][m];
		
		for(int x=0; x<n; x++) {
			tokens = new StringTokenizer(buffer.readLine());
			for(int y=0; y<m; y++) {
				map[x][y] = Integer.valueOf(tokens.nextToken());
			}
		}
		
		
	}
	
	//dp[i][j] = dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1] 중에서 최소값 + numbers[i][j] 
	
	static void tabulation() {
		for(int y=0; y<m; y++) {
			dp[0][y]=map[0][y];
		}
		
		for(int x=1; x<n; x++) {
			for(int y=0; y<m; y++) {
				int tmp = Integer.MAX_VALUE;
				for(int dir=0; dir<3; dir++) {
					int bX = x-1;
					int bY = y + dy[dir]; 
					if(!inRange(bX, bY))continue; 
					tmp = Math.min(tmp,  dp[bX][bY]);
				}
				dp[x][y] = tmp + map[x][y]; 
			}
		}
	}
	
	static void printDp() {
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				System.out.print(dp[x][y]+" ");
			}System.out.println();
		}
	}
	
	static int getMax() {
		int result = Integer.MAX_VALUE;
		for(int y=0; y<m; y++) {
			result = Math.min(result, map[n-1][y]);
		}
		return result; 
	}
	static boolean inRange(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<m;
	}
	
	public static void main(String[] args) throws IOException{
		init(); 
		tabulation(); 
		System.out.println(getMax());
		printDp();
	}
	
}
