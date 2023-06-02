package DFS;
import java.util.*;

public class BOJ6118 {
	static Scanner sc = new Scanner(System.in);
	
	
	static int n; //노드 개수 
	static int m; //간선 개수 
	
	static ArrayList<Integer>[] graph; 
	static int[] distance; 
	
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt(); 
		graph = new ArrayList[n+1];
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt(); 
			
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
	}
	static void bfs() {
		int startNode = 1;
		Queue<Integer> que = new LinkedList<>(); 
		distance[1] = 0;
		que.add(startNode); 
		
		while(!que.isEmpty()) {
			int currentNode = que.poll();
			ArrayList<Integer> adjcNodes = graph[currentNode];
			for(int adjcNode: adjcNodes) {
				if(!(distance[adjcNode]==Integer.MAX_VALUE))continue; 
				distance[adjcNode] = distance[currentNode]+1; 
				que.add(adjcNode);
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		//bfs활용하여 1번부터의 distance를 전부 채운다. 
		bfs(); 
		
		//distance를 순회하며 최대값을 갖는 노드를 구한다. 		
		int maxValue = Integer.MIN_VALUE;
		int maxNode = 0; 
		for(int node=1; node<=n; node++) {
			if(distance[node]>maxValue) {
				maxValue = distance[node]; 
				maxNode = node; 
			}
		}
		//같은 거리인 노드의 개수를 구한다.
		int nodeCount = 0;
		int resultNode = 0; 
		for(int node=1; node<=n; node++) {
			if(distance[node]==maxValue) {
				nodeCount++;
				if(resultNode==0) {
					resultNode = node;
				}
			}
		}
		System.out.println(resultNode+" "+distance[resultNode]+" "+nodeCount);
		
	}
}
