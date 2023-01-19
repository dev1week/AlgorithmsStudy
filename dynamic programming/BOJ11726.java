import java.io.*;
import java.util.*; 

public class BOJ11726 {
    static int N; 
    static int[] D; 
    static StringBuilder sb = new StringBuilder();

    static void DP(){
        D[1] = 1;
        D[2] = 2; 

        for(int i=3; i<=N; i++){
            D[i] = (D[i-1] + D[i-2])%10007;
        }
        //D[i] = D[i-1] 
                // 또는 D[i-2] 
        sb.append(D[N]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N+1];
        DP();
        System.out.println(sb);
    }
}
