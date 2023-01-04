import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2206 {
    static int N;
    static int M; 
    static int[][] map;
    static int[][][] distance; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());

        map = new int[N][M];
        distance = new int[N][M][2];
        
        for(int[] d: distance){
            Arrays.fill(d,-1);
        }

        for(int x=0; x<N; x++){
            tokens = new StringTokenizer(buffer.readLine());
            String line = tokens.nextToken();
            for(int y=0; y<M; y++){
                map[x][y]= Integer.valueOf(line.charAt(y)-'0');
            }
        }
    }

    static void print2D(int[][] map){
        for(int[] ma: map){
            for(int m: ma){
                System.out.print(m);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        init(); 
        print2D(map);
    }
}
