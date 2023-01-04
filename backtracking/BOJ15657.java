import java.io.*;
import java.util.*; 

public class BOJ15657 {
    static int N;
    static int M; 
    static int[] resNums; 
    static int[] inputNums;
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        resNums=new int[M];
        inputNums = new int[N];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            inputNums[i] = Integer.valueOf(tokens.nextToken());
        }
    }
    static void BT(int cur){
        if(cur==M){
            for(int num : resNums){
                sb.append(num + " "); 
            }sb.append("\n"); 
        }
        else{
            int start = 0; 
            if(cur!=0){start = cur-1-;}
            for(int index= start; index <N;index++){
                resNums[cur] = inputNums[index]; 
                BT(cur+1); 
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init(); 
        Arrays.sort(inputNums); 
        BT(0);
        System.out.print(sb); 
        //백트래킹 (현재자릿수)
            //베이스 컨디션 -> 결과출력 
            //else
                //int start = 0; 
                // 1 7 8 9
                //if(현재자릿수!=0)start = cur
                //for(int index=start; index<N; index++)
                // 결과수열에 넣어주기 res[cur] input[index]
                // bt(cur+1)
    }
    
}
