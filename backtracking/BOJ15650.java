import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N;
    static int M; 
    static int[] res;
    static boolean[] issued;
    static void print(String data){
        System.out.print(data);
    }
    static void bt(int cur){
        if(cur==M){
            for(int r: res){
                print(r+" ");
            }print("\n");
            return; 
        }
        int start =1; 
        if(cur !=0)start = res[cur-1]+1;
        for(int can=start; can<=N; can++){
            if(issued[can])continue; 
            issued[can]=true; 
            res[cur]=can; 
            bt(cur+1);
            issued[can]=false;
        }

    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        issued = new boolean[N+1];
        res = new int[M];
    }
    public static void main(String[] args) throws IOException{
        init(); 
        bt(0);
    }
    
}
