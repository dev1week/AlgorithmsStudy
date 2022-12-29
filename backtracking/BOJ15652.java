
import java.io.*;
import java.util.*; 
public class BOJ15652{
    static int N;
    static int M; 
    static int[] numbers;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        numbers = new int[M];
        isUsed = new boolean[N+1];
    }
    static void print(String data){
        System.out.print(data);
    }
    static void BT(int cur){
        if(cur==M){
            for(int number : numbers){
                sb.append(number + " ");
            }sb.append("\n");
        }else{
            int start = 1; 
            if(cur!=0){start=numbers[cur-1];}
            for(int next=start; next<=N; next++){
                numbers[cur] = next;
                BT(cur+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        init(); 
        BT(0);
        System.out.println(sb);
        
    }
}