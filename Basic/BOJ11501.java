import java.io.*;
import java.util.*; 

public class BOJ11501 {
    static int N; 
    static int K; 
    static int[][] D; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        K = Integer.valueOf(tokens.nextToken());
        D = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            D[i][i] =1;
            D[i][0] =1;
            D[i][1]=i;  
        }
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                D[i][j] = D[i-1][j-1] +D[i-1][j];
                D[i][j] = D[i][j]% 10007;
            }
        }
    }

    static void print2D(){
        for(int[] ma: D){
            for(int d : ma){
                System.out.print(d+" ");
            }System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(D[N][K]);
    }
    
}
