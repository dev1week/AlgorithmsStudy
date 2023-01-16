import java.io.*;
import java.util.*; 

public class permutation {
    static int N;
    static int K; 
    static int[][] DP;
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        K = Integer.valueOf(tokens.nextToken());
        DP = new int[N+1][N+1];
    }

    static void fill1(){
        for(int i=0; i<=N; i++){
            DP[i][0] =1; 
            DP[i][1] =i; 
            DP[i][i]=1; 
        }        
    }

    static void fill2(){
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                DP[i][j] =DP[i-1][j] + DP[i-1][j-1];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init(); 
        fill1();
        fill2(); 
        System.out.println(DP[N][K]);
    }   
}