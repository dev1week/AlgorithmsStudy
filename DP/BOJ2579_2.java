import java.io.*;
import java.util.*; 

public class BOJ2579_2 {
    static StringBuilder sb  =new StringBuilder();
    static int N; 
    static int[] stairs;
    static int[] D; 
    static int total = 0; 
    //D[i] = i 번째 계단까지 올라섰을 때 밟지 않을 계단 합의 최솟값 = n번째 계단까지의 점수의 최대값  
            // i번째 계단은 반드시 밟지 않을 계단으로 선택해야함 
    //D[1] = 0 
    //D[2] = 0 
    //D[3] = min()
    //D[i] = Min(D[i-2], D[i-1]) + chais[i]
    static void init(){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        stairs = new int[301];
        D = new int[301];
        for(int i=1; i<=N; i++){
            int tmp = sc.nextInt();
            stairs[i] = tmp; 
            total += tmp; 
        }
    }

    static void DP(){
        D[1] = stairs[1];
        D[2] = stairs[2];

        for(int i=3; i<=N; i++){
            D[i] = Math.min(D[i-2], D[i-3])+stairs[i];
        }
    }

    public static void main(String[] args){
        init();
        DP(); 
        sb.append(total -Math.min(D[N-1], D[N-2]));
        System.out.println(sb);
    }
}
