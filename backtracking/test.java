import java.io.*;
import java.util.*; 

public class test {
    static int N; 
    static int M; 
    static boolean[] isUsed;
    static int[] resultIdx; 
    static int[] candidates; 
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());

        resultIdx = new int[M];
        //순서를 고려안함 
        //중복 안됨 
        //순열 구하기 
        candidates = new int[N+1];
        isUsed = new boolean[N+1];
        tokens = new StringTokenizer(buffer.readLine());
        for(int idx=1; idx<=N; idx++){
            candidates[idx] = Integer.valueOf(tokens.nextToken());
        }
        Arrays.sort(candidates);
    }


    static void BT(int k){
        if(k==M){
            for(int idx=0; idx<M; idx++){
                sb.append(candidates[resultIdx[idx]]+" ");
            }sb.append("\n");
            return;
        }
        int start =1; 
        if(k>0){
            start = resultIdx[k-1]+1; 
        }
        for(int idx=start; idx<=N; idx++ ){
            if(isUsed[idx]){continue;}  
            isUsed[idx]=true; 
            resultIdx[k] = idx; 
            BT(k+1);
            isUsed[idx]=false; 
        }

    }    


    public static void main(String[] args) throws IOException{
        init();
        BT(0);
        System.out.println(sb);
    }
    
}

