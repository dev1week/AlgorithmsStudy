import java.io.*;
import java.util.*; 

public class BOJ24445 {
    static int node; 
    static int edge;
    static int start; 
    static int[] visit;
    static ArrayList<Integer>[] adj;

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        node = Integer.valueOf(tokens.nextToken());
        edge = Integer.valueOf(tokens.nextToken());
        start= Integer.valueOf(tokens.nextToken());
        visit = new int[node+1];
        adj = new ArrayList[node+1];
        for(int i=0; i<node+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edge; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.valueOf(tokens.nextToken());
            int node2 = Integer.valueOf(tokens.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
    }
    static void sortArrayList(){
        for(ArrayList<Integer> a: adj){
            Collections.sort(a);
        }
    }

    static void arrayList(){
        for(ArrayList<Integer> a: adj){
            System.out.println(a);
        }
    }
    static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start]=1; 
        int count =2; 
        while(!que.isEmpty()){
            int current = que.poll();
            for(int next: adj[current]){
                if(adj[next]==null)continue;
                if(visit[next]>0)continue;
                visit[next]= count;
                count++; 
                que.add(next);
            }
        }

    }

    static void printList(){
        for(int i=1; i<node+1; i++){
            System.out.println(visit[i]);
        }
    }
    public static void main(String[] args) throws IOException{
        init();
        sortArrayList();
        BFS(); 
        printList(); 

    }
    
}
