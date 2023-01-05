import java.util.*;
import java.io.*; 

public class BOJ11724 {
    static StringBuilder sb; 
    static int node;
    static int edge;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int numCC =0; 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        node = Integer.valueOf(tokens.nextToken());
        edge = Integer.valueOf(tokens.nextToken());
        adj = new ArrayList[node+1];
        visit= new boolean [node+1];
        for(int i=1; i<=node; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edge;i++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.valueOf(tokens.nextToken());
            int node2 = Integer.valueOf(tokens.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
    }

    static void BFS(int start){
        if(visit[start]){return;}
        Queue<Integer> que = new LinkedList<>();
        visit[start]=true;
        que.add(start);
        numCC++;
        while(!que.isEmpty()){
            int current = que.poll(); 
            for(Integer next : adj[current]){
                if(visit[next]){continue;}
                que.add(next);
                visit[next]=true; 
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init(); 
        for(int i=1; i<=node; i++){
            BFS(i);
        }
        System.out.println(numCC);
    }
    
}
