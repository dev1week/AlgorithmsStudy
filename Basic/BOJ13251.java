import java.io.*;
import java.util.*;


public class BOJ13251 {
    static StringBuilder sb = new StringBuilder(); 
    static int Combination(int A, int B){
        //A개 중 B개 뽑는 경우의 수 계산 
        int[][] D = new int[A+1][A+1];
        for(int i=0; i<=A; i++){
            D[i][0] = 1;
            D[i][1] = i; 
            D[i][i] =1; 
        }
        for(int i=2; i<=A; i++){
            for(int j=1; j<i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }
        return D[A][B];
    }
    static int[] colors;
    static int numOfColors;
    static int K; 
    static int total; 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        total =0;
        numOfColors = Integer.valueOf(tokens.nextToken());
        colors = new int[numOfColors];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<numOfColors; i++){
            colors[i] = Integer.valueOf(tokens.nextToken());
            total += colors[i];
        }
        K = Integer.valueOf(buffer.readLine());
    }
    public static void main(String[] args) throws IOException{
        
        init(); 
        int parents = Combination(total, K);
        int son =0; 
        double result =0; 
        for(int i=0; i<numOfColors; i++){
            
            if(colors[i]<K){continue;}
            son += Combination(colors[i],K );
        }

        String s;
        s.length)_
        StringTokenizer tokens = new StringTokenizer(s);
        tokens.
        result = Double.valueOf(son)/Double.valueOf(parents).
        sb.append(result);
    
        System.out.println(sb);
        //N개의 조약돌, M개의 색깔

        //랜덤하게 K 개 뽑았을 때 
        // 조약돌이 모두 같은 경우 
    
    }
}
