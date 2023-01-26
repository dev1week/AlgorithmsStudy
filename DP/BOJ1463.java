import java.io.*;
import java.util.*; 

public class BOJ1463{

    static int N; 

    static int[] D; // D[i] = x ㅑ를 만드는데 사용하는 최소 횟수 
    //D[i] = D[i//3]+1
    //D[1] = 0 
    //D[i] 

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N+1];
    }

    static void DP(){
        D[1] =0;
        for(int i=2; i<=N; i++){
            D[i] = D[i-1]+1; 
            if(i%2==0){D[i]= Math.min(D[i], D[i/2]+1);}
            if(i%3==0){D[i]= Math.min(D[i], D[i/3]+1);}
        }


    }
    //3으로 나누어 떨어지면 3으로 나눈다. 
    //2로 나누어떨어지면 2로 나눈다. 
    //1을 뺀다 

    public static void main(String[] args){
        init(); 
        DP();
        System.out.println(D[N]);
    }
}