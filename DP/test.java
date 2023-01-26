import java.io.*;
import java.util.*; 

public class test {
    static StringBuilder sb = new StringBuilder(); 

    static int X; 

    static int[][] D; 
    
    //D[i][0] = i번째 집을 빨강으로 칠했을 때 전체 최소 비용
        //    = min(D[i-1][1], D[i-1][2]) + costs[i][0];
    //D[i][1] = i번째 집을 파랑으로 칠했을 때 전체 최소 비용
    //D[i][2] = i번째 집을 초록으로 칠했을 때 전체 최소 비용

    static int[][] costs;

    static void DP(){
        D[1][0] = costs[1][0];
        D[1][1] = costs[1][1];
        D[1][2] = costs[1][2];

        for(int i=2; i<=X; i++){
            D[i][0] = Math.min(D[i-1][1], D[i-1][2])+costs[i][0];
            D[i][1] = Math.min(D[i-1][0], D[i-1][2])+costs[i][1];
            D[i][2] = Math.min(D[i-1][0], D[i-1][1])+costs[i][2];
        }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            result = Math.min(D[X][i], result);
        }
        sb.append(result);
        
    }
    
    public static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        X = Integer.valueOf(tokens.nextToken());
        
        costs = new int[X+1][3];
        D = new int[X+1][3];
        for(int x=1; x<=X; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<3; y++){
                costs[x][y] = Integer.valueOf(tokens.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        DP();
        System.out.println(sb);
    }
}
