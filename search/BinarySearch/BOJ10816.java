import java.io.*;
import java.util.*; 

public class BOJ10816 {
    static StringBuilder sb = new StringBuilder(); 
    static int N; 
    //500,000 
    static int M; 

    static int[] A;
    static int[] querys;

    static int left_idx(int target){
        int st = 0;
        int en = M; 
        while(st<en){
            int mid = (st+en)/2;
            if(target<=A[mid]){
                en = mid; 
            }
            else{
                st = mid+1; 
            }
        }
        return st; 
    }

    static int right_idx(int target){
        int st = 0;
        int en = M; 
        while(st<en){
            int mid = (st+en)/2;
            if(A[mid]>target){
                en = mid; 
            }else{
                st = mid +1; 
            }
        }
        return st; 
    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(buffer.readLine());
        A = new int[N];
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.valueOf(tokens.nextToken());
        }
        M = Integer.valueOf(buffer.readLine());
        querys = new int[M];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<M; i++){
            querys[i] = Integer.valueOf(tokens.nextToken());
        }
    }

    static void printArr(int[] arr){
        for(int a: arr){
            sb.append(a + " ")            ;
        }sb.append("\n");
    }

    public static void main(String[] args) throws IOException{
        init();
        Arrays.sort(A);
        printArr(A);
        for(int q : querys){
            sb.append(q+" "+right_idx(q)+" "+left_idx(q)).append("\n");
        }

        System.out.println(sb);
    }
}
