import java.io.*;
import java.util.*; 

public class test2 {
    static StringBuilder sb = new StringBuilder(); 
    static int N; 
    static int M; 
    static int[] resultIdx;
    static boolean[] isUsed;
    static int[] candidates; 

    //순서 고려 -> start 조정 안해도 됨 
    //중복 없음 -> isUsed 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        resultIdx = new int[M];
        isUsed = new boolean[N+1];
        candidates = new int[N+1];
        tokens = new StringTokenizer(buffer.readLine());
        for(int idx=1; idx<=N; idx++ ){
            candidates[idx] = Integer.valueOf(tokens.nextToken());
        }
        Arrays.sort(candidates);
    }

    static void BT(int k){
        if(k==M){
            for(int idx=0; idx<M; idx++){
                sb.append(candidates[resultIdx[idx]]+" ");
            }
            sb.append("\n");
            return; 
        }
        for(int nextIdx=1; nextIdx<=N; nextIdx++){
            if(isUsed[nextIdx]){continue;}
            isUsed[nextIdx] = true; 
            resultIdx[k] = nextIdx; 
            BT(k+1);
            isUsed[nextIdx] = false; 
        }
    }
    public static void main(String[] args) throws IOException{
        init();
        BT(0);
        System.out.println(sb);
    }
    
}
