import java.io.*;
import java.util.*; 


public class BOJ14501 {
    //N일동안 상담 

    //상담을 완료하는데 걸리는 기간 
    static int[] T; 
    //상담했을 때 받을 수 있는 금액 
    static int[] P;
    
    //i번째 날부터 퇴사일까지 벌 수 있는 최대 수입 
    static int[] D; 
    //D[i] = i번째 날부터 퇴사일까지 벌 수 있는 최대 수입 
    //퇴사일까지 상담이 끝나지 않는 경우 7-i < T[i]
        // D[i] = D[i-1] 
    //퇴사일까지 상담이 끝나는 경우 7-i>T[i]
        // D[i] = D[i-1] + P[i] 
    

    static int num;

    static StringBuilder sb = new StringBuilder(); 

    static void init(){

    }

    static void DPp(){

    }
    public static void main(String[] args){
        init(); 
        DPp();
        System.out.println(sb);
    }
}
