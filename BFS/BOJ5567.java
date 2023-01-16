import java.io.*;
import java.lang.reflect.Array;
import java.util.*; 

public class BOJ5567 {
    static int node;
    static int edge;
    static ArrayList<Integer>[] adj;
    static int[] visit; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        node = Integer.valueOf(tokens.nextToken());
        tokens = new StringTokenizer(buffer.readLine());
        edge = Integer.valueOf(tokens.nextToken());
        visit = new int[node+1];
        adj = new ArrayList[node+1];
        for(int i=1; i<=node; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edge; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.valueOf(tokens.nextToken());
            int node2= Integer.valueOf(tokens.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1); 
        }
    }

    static void BFS(){
        Integer start = 1;
        Queue<Integer> que = new LinkedList<>(); 
        que.add(start); 
        visit[start]=1; 
        while(!que.isEmpty()) {
            Integer current = que.poll();
            for(int next : adj[current]){
                if(visit[next]>0)continue; 
                visit[next] = visit[current]+1; 
                que.add(next);
            }
        }
    }
    static int count(){
        int cnt=0; 
        for(int i : visit){
            if(i==2 || i==3){
                cnt++; 
            }
        }
        return cnt; 
    }
    public static void main(String[] args) throws IOException{
        init(); 
        BFS(); 
        System.out.println(count());
    }
    
}
