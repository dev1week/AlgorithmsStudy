import java.io.*;
import java.util.*; 

public class BOJ2579 {
    // 한번에 하나 혹은 두 개를 오를 수 있음 
    //연속으로 3개 밟으면 안됨 
    //마지막 도착 계단은 반드시 밟는다. 

    static int N;
    static int[] stairs;

    static StringBuilder sb = new StringBuilder(); 

    static int[][] D; 
    //D[i][j] j개의 계단을 연속해서 밟고 i번째 밟았을 때 점수 합의 최대값 
    //D[k][1] = 1개의 계단을 연속해서 밟고 k번째 밟았을 때 점수 합의 최대값 
                // k-1번째는 밟지 않음 
                // k-2 번째 밟음 
                // MAX(D[k-2][1], D[k-2][2]) + stairs[k]
    //D[k][2] = 2개의 계단을 연속해서 밟고 k번째 밟았을 때 점수 합의 최대값 
                //D[k-1][1] +staris[k]
    //D[1][1] = stairs[1]
    //D[1][2] = 0 
    //D[2][1] = staris[1] + staris[2]
    //D[2][2] = 0 

    static void DP(){
        D[1][1] = stairs[1];
        D[2][1] = stairs[1] + stairs[2];
        
        for(int i=2; i<=N;i++){
            D[i][1] = Math.max(D[i-2][1], D[i-2][2]) + stairs[i];
            D[i][2] = D[i-1][1] + stairs[i];
        }
    }



    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stairs = new int[N+1];
        D = new int[N+1][3];
        for(int i=1; i<=N; i++){
            stairs[i] = sc.nextInt(); 
        }
    }
    static void print(int[] arr){
        for(int a : arr){
            sb.append(a);
        }sb.append("\n");
    }

    public static void main(String[] args){
        init();
        DP(); 
        sb.append(Math.max(D[N][1], D[N][2]));
        System.out.println(sb);
    }
}
