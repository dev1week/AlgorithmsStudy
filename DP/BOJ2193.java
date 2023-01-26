import java.io.*;
import java.util.*; 

public class BOJ2193 {
    static int N; 
    static long[][] D; 
    //D[i][0] = i자릿수의 이친수중 0으로 끝나는 것의 개수 
            // = D[i-1][0] + D[i-1][1]
    //D[i][1] = i자릿수 중 이친수중 1로 끝나는 것의 개수
            // = D[i-1][0] 
    //D[1][0] = 1;
    //D[1][1] = 1; 

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new long[101][2];
    }
    static void DP(){
        D[1][0] =0;
        D[1][1]=1;
        D[2][0] =1;
        D[2][1] = 0;
        D[3][1] = 1;
        D[3][0] =1;

        for(int i=4; i<=N; i++){
            D[i][0] = D[i-1][1] + D[i-1][0];
            D[i][1] = D[i-1][0];
        }
        long result = D[N][0] + D[N][1];

        System.out.println(result);
    }

    public static void main(String[] args){
        init();
        DP(); 
    }
}
