import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N,M,V; 
    static ArrayList<Integer>[] adj; 
    static boolean[] visit;

    static void BFS(int start){
        visit[start]=true; 
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()){
            int current = que.poll(); 
            sb.append(current).append(' ');
            for(int next: adj[current]){
                if(visit[next]==true)continue;
                System.out.println(next);
                que.add(next);
                visit[next]= true; 
            }
        }
    }

    static void DFS(int current){
        visit[current]=true; 
        sb.append(current).append(' ');
        for(int next: adj[current]){
            if(visit[next]==true)continue; 
            DFS(next);
        }
    }

    static void input(){
        N = sc.nextInt(); //노드 개수 
        M = sc.nextInt(); //간선 개수 
        V = sc.nextInt(); 
        adj = new ArrayList[N + 1];
        for(int i=1; i<=N;i++){
            adj[i] = new ArrayList<>(i);
        }
        for(int i=1; i<=M; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        //array리스트 정렬해줘야함 
        for(int i=1; i<=N; i++){
            Collections.sort(adj[i]);
        }
    } 
    static void pro(){
        visit = new boolean[N+1];
        DFS(V);
        sb.append('\n');
        for(int x=0; x<=N; x++){
            visit[x] = false; 
        }
        BFS(V);
        System.out.println(sb);
        
    }
    public static void main(String[] args){
        input(); 
        pro(); 
    }
    
}
