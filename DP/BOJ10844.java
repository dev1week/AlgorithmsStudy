import java.io.*;
import java.util.*;


public class BOJ10844 {
    static StringBuilder sb = new StringBuilder(); 
    static int N; //자릿수 1~100 
    static int[][] D;

    //D[i][j] = i 번째 자릿수에서 j일때의 계단수의 갯수 
    //D[1] = 1 2 3 4 5 6 7 8 9 
    //D[2] = 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
    //D[3] = 
    // D[i][j] = D[i-1][j-1] + D[i-1][j+1]
    // D[i][9] = D[i-1][8]
    // D[i][0] = D[i-1][1]


    //      1210 1212 
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        D = new int[N+1][10];
        
        for(int i=1; i<=9; i++){
            D[1][i] = 1; 
        }

        for(int i=2; i<=N;i++){
            D[i][9] = D[i-1][8]%1000000000;
            D[i][0] = D[i-1][1]%1000000000;
            for(int j=1; j<=8; j++){
                D[i][j] = (D[i-1][j-1] + D[i-1][j+1])%1000000000;    
            }
        }
        

        //D[i] = D[i-1]*2 -1; 
    }

    static void printResult(){
        int result=0;
        for(int data: D[N]){
            result += data; 
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        init();
        printResult();

    }
    
}
