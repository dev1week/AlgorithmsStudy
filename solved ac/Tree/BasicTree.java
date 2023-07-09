package Tree;


import java.util.*; 

public class BasicTree {
	
	
	static final int n= 7;
	static ArrayList<Integer>[] graph = new ArrayList[n+1];
	static boolean[] isVisited = new boolean[n+1];
	static int[] parents= new int[n+1]; 
	
	static int[] startPoints = {-1,1,1,1,3,2,3};
	static int[] endPoints = {-1,4,7,6,6,3,5}; 
	
	
	
	
	
	
	static void void dfs(int current) {
		for(int nextIdx =0; nextIdx<graph[current].size(); nextIdx++) {
			int nextNode = graph[x].get(nextIdx);
			
			if(!isVisited[nextNode]) {
				isVisited[nextNode] = true;
				parents[nextNode] = current; 
				
				dfs(nextNode);
			}
		}
	}
	
	
	public static void main(String[] args) {
		for(int i=1; i<=n; i++) {
			edges[i] = new ArrayList<>(); 
		}
		
		for(int i=1; i<=n-1; i++) {
			int x = startPoints[i];
			int y = endPoints[i]; 
			
			edges[x].add(y); 
			edges[y].add(x); 
		}
		
		//1번부터 트리 순회 
		isVisited[1] = true; 
		dfs(1);
	}

}
