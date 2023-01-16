import java.io.*;
import java.util.*; 




public class BOJ15657 {

    static StringBuilder sb = new StringBuilder(); 
    static int N; 
    static int M; 
    static int[] candidates;
    static int[] resultIdx; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        candidates = new int[N+1];
        resultIdx = new int[M];

        tokens = new StringTokenizer(buffer.readLine());
        for(int idx=1; idx<=N; idx++){
            candidates[idx] = Integer.valueOf(tokens.nextToken());
        }

        Arrays.sort(candidates);
    }

    static void BT(int k){
        if(k==M){
            for(int i=0; i<M; i++){
                sb.append(candidates[resultIdx[i]]+" ");
            }sb.append("\n");
            return; 
        }
        int startIdx =0; 
        if(k>0){
            startIdx = resultIdx[k-1]+1; 
        }
        for(int nextIdx=startIdx; nextIdx<=N; nextIdx++){
            resultIdx[k] = nextIdx; 
            BT(k+1);
        }
    }
    public static void main(String[] args) throws IOException{
        init();
        BT(0);
        System.out.println(sb);
    }

    //n개중 m개 고르기 
    // 같은 수 가능 -> isUsed 사용안함 
    // 비내림차순 -> 순서 고려함 -> start 조정 안해줘도 됨 
    
}
