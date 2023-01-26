import java.io.*;
import java.util.*;

public class BOJ9095 {
    //D[i] i의 합을 나타내는 가짓수 
    //D[4] = 1 + 1 + 1 + 1
    //     = 1 + 1 + 2
    //     = 1 + 2 + 1
    //     = 2 + 1 + 1
    //     = 2 + 2
    //     = 1 + 3
    //     = 3 + 1
    static int T; 
    static int[] D;
    static int N; 
    //D[i] = i를 나타내는 방법 
    static StringBuilder sb = new StringBuilder(); 
    static void init(){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i=0; i<T; i++){
            N = sc.nextInt();
            D = new int[12];
            DP();

        }
    }

    static void DP(){
        D[1] =1; 
        D[2] =2;
        D[3] =4; //3 1+2 2+1 1+1+1  
        for(int i=4; i<=N; i++){
            D[i] = D[i-1]+D[i-2]+D[i-3];
        }
        sb.append(D[N]+"\n");
    }

    public static void main(String[] args){
        init(); 
        System.out.println(sb);    
    }
}
