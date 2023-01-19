import java.io.*;
import java.util.*; 
public class BOJ1463{
    static int[] distance;
    static boolean[] isVisited;
    static int N;
    static StringBuilder sb = new StringBuilder();

    static void BFS(int N){
        Queue<Integer> que = new LinkedList<>();
        que.add(N);

        while(!que.isEmpty()){
            int current = que.poll();
            int next=0; 

            if(current>0){
                next = current-1; 
                que.add(next);
                distance[next] = distance[current]+1; 
                if(next ==1){
                    sb.append(distance[1]);
                    return; 
                } 
            }
            if(current%2==0){
                next = current/2;
                que.add(next);
                distance[next] = distance[current]+1; 
                if(next ==1){
                    sb.append(distance[1]);
                    return; 
                } 
            }if(current%3==0){
                next = current/3;
                que.add(next);
                distance[next] = distance[current]+1; 
                if(next ==1){
                    sb.append(distance[1]);
                    return; 
                } 
            }
            
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        distance = new int[N+1];
        BFS(N); 
        System.out.println(sb);
    }

}