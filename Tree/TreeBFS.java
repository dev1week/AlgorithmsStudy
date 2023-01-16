import java.io.*;
import java.util.*; 

public class TreeBFS {
    static    int[] lc = {0,2,4,6,0,8,0,0,0};
    static    int[] rc ={0,3,5,7,0,8,0,0,0};
    static int[] p = new int[lc.length];
    static StringBuilder sb = new StringBuilder(); 

    static void BFS(int root){
        Queue<Integer> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int current = que.poll();;
            sb.append(current);
            for(int next : )

        }

    }

    static void BFS(int current){
        Queue<Integer> que = new LinkedList<>();
        que.add(current);

        while(!que.isEmpty()){
            int next = que.poll(); 
            sb.append(next +" ");
            if(lc[next]!=0){que.add(lc[next]);}
            if(rc[next]!=0){que.add(rc[next]);}
        }
    }
    public static void main(String[]args){
        BFS(1);
        System.out.println(sb);

    }
}
