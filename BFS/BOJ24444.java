import java.io.*;
import java.util.*; 

public class BOJ24444 {
    static StringBuilder sb = new StringBuilder(); 
    static int node;
    static int edge;
    static int start; 
    static boolean[][] adjMx;
    static int[] visit;
    static LinkedList<Integer> notVisitedList;
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        node = Integer.valueOf(tokens.nextToken());
        edge = Integer.valueOf(tokens.nextToken());
        start = Integer.valueOf(tokens.nextToken());
        adjMx = new boolean[node+1][node+1];
        visit = new int[node+1];
        notVisitedList = new LinkedList<>();
        for(int i = 0; i<edge; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int node1 = Integer.valueOf(tokens.nextToken());
            int node2 = Integer.valueOf(tokens.nextToken());
            adjMx[node1][node2]=true; 
            adjMx[node2][node1]=true; 
        }
        
    }
    static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start]=1;
        while(!que.isEmpty()){
            int current = que.poll();
            for(int next=0; next<adjMx[current].length;next++){
                if(!adjMx[current][next])continue; 
                if(visit[next]!=0)continue;
                que.add(next);
                visit[next]=visit[current]+1;
            }
        }
    }
    static void printVisit(){
        for(int i : visit){
            sb.append(i+"\n");
        }
    }
    public static void main(String[] args) throws IOException{
        init();
        BFS(start);
        System.out.println(sb);
    }
}
