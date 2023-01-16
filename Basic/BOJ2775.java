import java.io.*;
import java.util.*;

public class BOJ2775 {
    static int T;
    static int[][] apt;
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);



    public static void main(String[] args){
        T = sc.nextInt();
        for(int testCase=0; testCase<T; testCase++){
            int x = sc.nextInt();
            int y = sc.nextInt(); 
            if( x> y){
                apt = new int[x+1][x+1];
            }else{
                apt= new int[y+1][y+1];
            }
            //0층 채우기 
            for(int i=1; i<apt[0].length;i++){
                apt[0][i] = i; 
            }
            for(int i=1; i<apt[0].length; i++){
                for(int j=1; j<apt.length; j++ ){
                    apt[i][j] = apt[i-1][j] + apt[i][j-1];
                }
            }
            System.out.println(apt[x][y]);
        }
        //a층 b호에 살려면 a-1층 의 1호부터 b호까지 사람들의 수 합 만큼 살아야함 
        // 각 층에는 1호부터 존재 
        //0층 i호 에는 i명이 산다. 
    }
    
}
