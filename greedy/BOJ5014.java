import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int[] distance;
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        F = Integer.valueOf(tokens.nextToken());
        S = Integer.valueOf(tokens.nextToken());
        G = Integer.valueOf(tokens.nextToken());
        U = Integer.valueOf(tokens.nextToken());
        D = Integer.valueOf(tokens.nextToken());
        distance = new int[F+1];
        Arrays.fill(distance,-1);
    }
    static void BFS(){
        Queue<Integer> que = new LinkedList<>(); 
        que.add(S);
        distance[S]=0; 
        while(!que.isEmpty()){
            int cur = que.poll(); 
            int up = cur+U;
            
            int down = cur-D; 
            for(int next : new int[] {up,down}){
                if(next>F||next<=0||distance[next] !=-1)continue;
                distance[next] = distance[cur]+1; 
                que.add(next);
            }
    
        }
    }
    static void judge(){
        if(distance[G]==-1){
            System.out.println("use the stairs");
        }
        else System.out.println(distance[G]);
    }

    public static void main(String[] args) throws IOException{
        init();
        BFS();
        judge();
    }

}
