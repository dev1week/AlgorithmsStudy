import java.io.*;
import java.util.*;

public class BOJ11727 {
    static int N; 
    static int[] D; 
    static void DP(){
        D[1] =1;
        D[2] =3;
        for(int i=3; i<=N; i++){
            D[i] = (D[i-1] + D[i-2]*2)%10007;
        }
    }
    //D[1] = 1;
    //D[2] = 3
    //D[i] = D[i-1] + D[i-2]*2
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        D = new int[1001];
    }
    public static void main(String[] args){
        init();
        DP(); 
        System.out.println(D[N]);
    }
}
