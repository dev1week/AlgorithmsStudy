import java.io.*;
import java.util.*; 

public class test3 {
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
        candidates = new int[N];
        isUsed = new boolean[N];
        tokens = new StringTokenizer(buffer.readLine());
        for(int idx=0; idx<N; idx++){
            candidates[idx] = Integer.valueOf(tokens.nextToken());
        }
        Arrays.sort(candidates);
    }


    static void BT(int k, int start){
        if(k==M){
            for(int idx=0; idx<M; idx++){
                sb.append(candidates[resultIdx[idx]]+" ");
            }sb.append("\n");
            return;
        }
        
        for(int idx=start; idx<N; idx++ ){
            resultIdx[k] = idx; 
            BT(k+1, start+1);   
            resultIdx[k] = 0;          
        }
    }    


    public static void main(String[] args) throws IOException{
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=1; i<9; i++){
            tree.add(i);
        }
        sb.append(tree.first());
        sb.append(tree.last());
        System.out.println(tree);
    }
    
}


