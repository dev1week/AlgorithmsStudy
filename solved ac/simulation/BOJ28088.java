package simulation;
import java.util.*; 
import java.io.*;

public class BOJ28088 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] current;
	static boolean[] next;
	static int n; 
	static int m; 
	static int k;
	
	static int nextIdx(int idx) {
		int adjc = idx+1;
		if(adjc>=n) {
			adjc = 0;
		}
		return adjc;
	}
	static int prevIdx(int idx) {
		int adjc = idx-1;

		if (adjc<0) {
			adjc= n-1;
		}
		return adjc;
	}
	
	static void makeNext() {
		for(int i=0; i<n; i++) {
			if(current[i]) {
				next[nextIdx(i)] = true;
				next[prevIdx(i)] = true;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(current[nextIdx(i)]&&current[prevIdx(i)]) {
				next[i] = false;
			}
		}
	}
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken());
		k = Integer.valueOf(tokens.nextToken()); 
		
		current =  new boolean[n];
		next =  new boolean[n];
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(buffer.readLine());
			int idx = Integer.valueOf(tokens.nextToken());
			current[idx] = true; 
		}
		
		
		
	}
	
	static void print() {
		for(boolean d: current) {
			System.out.print(d+" ");
		}System.out.println();
	}
	
	static void printNext() {
		for(boolean d: next) {
			System.out.print(d+" ");
		}System.out.println();
	}
	static boolean isAllFalse() {
		for(boolean d: current) {
			if(d) {
				return false;
			}
		}
		return true;
	}
	
	static int getCount(){
		int result =0;
		for(boolean d: current) {
			if(d)result++;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException{
		init();
		for(int i=0; i<k; i++) {
			makeNext();
			current = next; 
			next = new boolean[n];
			if(isAllFalse()) {
				break;
			}
		}
		System.out.println(getCount());
		
		//현재값 토대로 next 배열 생성 
		
		//next를 current로 옮겨준다. 
		
		
		
	}

}
