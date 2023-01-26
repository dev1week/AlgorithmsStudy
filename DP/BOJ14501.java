import java.io.*;
import java.util.*; 


public class BOJ14501 {
    //N일동안 상담 
    static int N; 

    //상담을 완료하는데 걸리는 기간 
    static int[] T; 
    //상담했을 때 받을 수 있는 금액 
    static int[] P;
    
    //i번째 날부터 퇴사일까지 벌 수 있는 최대 수입 
    static int[] D; 
    //D[i] = i번째 날부터 퇴사일까지 벌 수 있는 최대 수입 
    //퇴사일(or 상담일)까지 상담이 끝나지 않는 경우 7-i < T[i]
        // D[i] = D[i-1] 
    //퇴사일까지 상담이 끝나는 경우 7-i>T[i]
        // D[i] = D[i-1] + P[i] 
    // 1 2 3 4 5 6 7
    // 3 5 1 1 2 4 2
    
    // D[1] = 

    static int num;

    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        T= new int[N+1];
        P = new int[N+1];

        for(int i=1; i<=N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            T[i] = Integer.valueOf(tokens.nextToken());     
            P[i] = Integer.valueOf(tokens.nextToken());     
        }
        
    }

    static void DPp(){

    }
    public static void main(String[] args){
        init(); 
        DPp();
        System.out.println(sb);
    }
}
