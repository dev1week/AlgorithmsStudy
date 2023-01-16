import java.io.*;
import java.util.*;

public class BOJ1010 {
    static int T; 
    static int N; 
    static int M; 
    static int[][] D; 
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws NumberFormatException, IOException{
        T = Integer.valueOf(buffer.readLine());
    }
    static void process(){
        D = new int[M+1][M+1];
        for(int i=0; i<=M; i++){
            D[i][0] = 1;
            D[i][1] = i; 
            D[i][i] = 1; 
        }
        for(int i=2; i<=M; i++){
            for(int j=1; j<i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException{

        //M개 중 N개를 뽑는 순열 문제 
        init();
        for(int testCase=0; testCase<T;testCase++){
            tokens = new StringTokenizer(buffer.readLine());
            N = Integer.valueOf(tokens.nextToken());
            M = Integer.valueOf(tokens.nextToken()); 
            process(); 
            sb.append(D[M][N]).append("\n");
        }
        
        System.out.println(sb);
    }

}
