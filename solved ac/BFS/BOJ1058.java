package BFS;
import java.io.*;
import java.util.*; 
public class BOJ1058 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] graph;
	static int[] distance; 
	static int n; 
	
	//A와 B가 2-친구 
		//1. A-B 바로 친구 
		//2. A-?-B인 ?가 존재해야한다. 
	//유명한 사람
		//2-친구의 수가 가장 많은 사람 
	
	//각 사람의 그래프 탐색 
		//방문 개수 구하기 = 2-친구의 개수
	static StringTokenizer tokens;
	static void init() throws IOException {
		n = Integer.valueOf(buffer.readLine()); 
		
		graph =  new boolean[n][n];
		
		for(int x=0; x<n; x++) {
			String line = buffer.readLine();
			for(int y=0; y<n; y++) {
				
				if(line.charAt(y)=='N') {
					graph[x][y] = false;
				}
				else {
					graph[x][y] = true; 
				}
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>(); 
		
		que.add(start);
		distance[start] = 0; 
		
		while(!que.isEmpty()) {
			int current = que.poll();
			for(int next=0; next<n; next++) {
				if(distance[next]!=-1)continue; 
				
				if(graph[current][next]) {
					distance[next] = distance[current]+1;
					que.add(next);
				}
			}
		}
		
	}
	static int get2FriendsCount(int start) {
		int result = 0;
		
		for(int i=0; i<n; i++) {
			if(i==start)continue;
			if(distance[i]<3&&distance[i]>=1)result++;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException{
		init();
		int result = 0;
		for(int person=0; person<n; person++) {
			distance = new int[n]; 
			Arrays.fill(distance, -1);
			bfs(person);
			result = Math.max(result, get2FriendsCount(person)); 
		}
		System.out.println(result);
	}
	
	
	

}
