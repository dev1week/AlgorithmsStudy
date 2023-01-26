import java.io.*;
import java.util.*; 


public class BOJ1149 {
    static int N;
    static int[][] costs; 
    static StringBuilder sb = new StringBuilder();
    static int[][] D;
    //D[1][0] = costs[1][0]
    //D[1][1] = costs[1][1]
    //D[1][2] = costs[1][2]
    //D[2][0] = costs[2][0]
    //D[2][1] = costs[2][0]
    //D[2][2] = costs[2][0]
     
    //D[i][0] = i번째 집의 0으로 칠했을 때 전체 최소값 = Math.min(D[i-1][1], D[i-1][2]) + costs[i][0]
    //D[i][1]
    //D[i][2]



    //1~1000(N)개 집 
    //빨파초 중 하나의 색 
    //비용의 최솟값 
    //1번집은 2번집의 색과 같지 않아야함 
    //N번은 N-1번 색과 같지 안항야함 
    //양 옆에 있는 것이 서로 달라야함 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        costs = new int[N+1][3];
        D = new int[N+1][3];
        for(int i=1; i<=N;i++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int j=0; j<3; j++){
                costs[i][j] = Integer.valueOf(tokens.nextToken());
            }
        }
    }

    static void print2D(int[][] arr){
        for(int[] ar: arr){
            for(int a : ar){
                sb.append(a+" ");
            }sb.append("\n");
        }
    }

    static void DP(){
        D[1][0] = costs[1][0];
        D[1][1] = costs[1][1]; 
        D[1][2] = costs[1][2]; 
        for(int i=2; i<=N; i++){
            D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + costs[i][0];
            D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + costs[i][1];
            D[i][2] = Math.min(D[i-1][1], D[i-1][0]) + costs[i][2];
        }
        int tmp = Math.min(D[N][1],D[N][2]);
        tmp = Math.min(tmp,D[N][0]);
        sb.append(tmp);
     }
    public static void main(String[] args) throws IOException{
        init(); 
        DP(); 
        System.out.println(sb);
    }
}
