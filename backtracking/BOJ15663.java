
import java.io.*;
import java.util.*;

public class BOJ15663 {
    static int N; 
    static int M; 
    static boolean[] isVisit;
    static int[] nums; 
    static int[] result; 
    static int max = 100000;
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        nums = new int[N];
        result = new int[M];
        tokens = new StringTokenizer(buffer.readLine());
        for(int idx =0; idx<N; idx++){
            nums[idx] = Integer.valueOf(tokens.nextToken());
        }
        isVisit = new boolean[N];
    }

    static void print(int[] arr){
        for(int a: arr){
            sb.append(a+" ");
        }sb.append("\n");
    }

    static void BT(int current){
        if(current==M-1){
            print(result);
        }else{
            for(int nextIdx =0; nextIdx<N; nextIdx++){
                if(isVisit[nextIdx])continue;
                result[current] = nums[nextIdx];
                isVisit[nextIdx]=true;
                BT(current+=1);
                isVisit[nextIdx]=false; 
            }
        }
    }
    public static void main(String[]args) throws IOException{
        init();
        Arrays.sort(nums);
        print(nums);
        BT(0);
        System.out.print(sb);
    }
}
