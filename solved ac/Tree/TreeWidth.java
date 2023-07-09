package Tree;
import java.io.*; 
import java.util.*; 

class Node{
	int num, dist;
	
	public Node(int num, int dist) {
		this.num = num;
		this.dist = dist; 
	}
}

public class TreeWidth {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	static final int MAX_N = 10000; 
	
	static int n; 
	static ArrayList<Node>[] edges = new ArrayList[MAX_N+1]; 
	static boolean[] isVisited = new boolean[MAX_N+1]; 
	static int[] dist = new int[MAX_N+1]; 
	
	static void dfs(int cur, int totalDist) {
		for(int nextIdx =0; nextIdx< edges[cur].size(); nextIdx++) {
			int nextNode = edges[cur].get(nextIdx).num; 
			int distFromNext = edges[cur].get(nextIdx).dist;
			
			if(!isVisited[nextNode]) {
				isVisited[nextNode] = true; 
				dist[nextNode] = totalDist + distFromNext; 
				dfs(nextNode, totalDist+distFromNext);
			}
		}
	}
	
	static Node findFartherNode(int startNode) {
		for(int node=1; node<=n; node++) {
			isVisited[node] = false;
			dist[node] = 0; 
		}
		
		isVisited[startNode] = true; 
		dist[startNode] = 0;
		
		//dfs를 진행하여 dist를 채워준다. 
		dfs(startNode, 0); 
		
		//dist를 순회하면서 가장 멀리 떨어진 정점 정보를 찾는다. 
		int farthestDist = Integer.MIN_VALUE; 
		int farthestNode = -1;
		
		for(int node=1; node<=n; node++) {
			if(dist[node]> farthestDist) {
				farthestDist = dist[node]; 
				farthestNode = node;
			}
		}
		
		return new Node(farthestDist, farthestNode);
	}
	
	
	public static void main(String[] args) throws IOException{
		n = Integer.valueOf(buffer.readLine()); 
		
		for(int node=1; node<=n; node++) {
			edges[node] = new ArrayList<>(); 
		}
		
		for(int edge=0; edge<n-1; edge++) {
			int node1 = Integer.valueOf(buffer.readLine());
			int node2 = Integer.valueOf(buffer.readLine());
			int dist = Integer.valueOf(buffer.readLine());
			
			edges[node1].add(new Node(node2, dist));
			edges[node2].add(new Node(node1, dist)); 
		}
		
		//1번 정점으로부터 가장 멀리 있는 정점 노드 번호를 찾는다. 
		int fNodeNum = findFartherNode(1).num;
		
		//위에서 찾은 정점으로부터 가장 멀리 있는 정점 정보를 찾는다. = 이 때의 길이가 지름이 된다. 
		int diameter = findFartherNode(fNodeNum).dist; 
		
	}
}
