import java.util.*;
import java.io.*;

public class test {
    static Scanner sc = new Scanner(System.in);
    static int[][] adj;
    static boolean visit[];
    static int node;
    static int edge;
    static int start;
    static StringBuilder sb = new StringBuilder();

    static void init(){
        node = sc.nextInt();
        edge = sc.nextInt();
        start = sc.nextInt();
        adj = new int[node+1][node+1];
        visit = new boolean[node+1];
        for(int i=0; i<edge; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adj[node1][node2] = 1;
            adj[node2][node1] =1; 
        }
    }
    static void print2D(int[][] map){
        for(int[] ma : map){
            for(int m: ma){
                System.out.print(m+" ");
            }System.out.println();
        }
    }
    static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start]=true;
        while(!que.isEmpty()){
            int current = que.poll();
            sb.append(current +" ");
            for(int next=0; next<adj[current].length; next++){
                if(adj[current][next]!=1)continue; 
                if(visit[next])continue;
                que.add(next);
                visit[next] = true;
            }
        }
    }
    static void DFS(int current){
        visit[current] = true; 
        sb.append(current+" ");
        for(int next=0; next<adj[current].length;next++){
            if(adj[current][next]==0)continue;
            if(visit[next])continue;
            DFS(next);
        }
    }
    public static void main(String[] args){
        init();
        DFS(start);
        visit = new boolean[node+1];
        sb.append("\n");
        BFS(start);

        print2D(adj);
        System.out.print(sb);
    }
    
}
