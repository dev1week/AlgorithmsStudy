import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N; 
    static int M; 
    static StringBuilder sb = new StringBuilder();
    static int[] res; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());        
    
        res = new int[M]; 
    }
    static void bt(int cur){
        if(cur==M){
            for(int d : res){
                sb.append(d +" ");
            }sb.append("\n");
        }else{
            for(int tmp =1; tmp<=N; tmp++){
                res[cur] = tmp; 
                bt(cur+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        init(); 
        bt(0);
        System.out.println(sb);
    }
}
