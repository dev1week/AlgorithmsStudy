import java.io.*;
import java.util.*; 

public class BOJ1920{
    static int N; 
    //정수 개수 100,000 
    static int[] A; 

    static int M;
    //질문 개수
    static int[] query;
    //quey 수들이 A안에 존재하는지 

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        N = Integer.valueOf(tokens.nextToken());

        A = new int[N];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            
            A[i] = Integer.valueOf(tokens.nextToken());
        }
        Arrays.sort(A);
        
        tokens = new StringTokenizer(buffer.readLine());
        M = Integer.valueOf(tokens.nextToken());
        query = new int[M];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<M; i++){
            query[i] = Integer.valueOf(tokens.nextToken());
        }
    }

    public static void printArr(int[] arr){
        for(int a: arr){
            sb.append(a + " ");
        }sb.append("\n");

    }

    static int bs(int target){
        int st = 0;
        int en = N-1; 
        
        while(st<=en){
            int mid = (st+en)/2;
            if(A[mid]==target){
                return 1;
            }
            else if(A[mid]> target){
                en = mid -1; 
            }
            else if(A[mid]<target){
                st = mid+1; 
            }
        }

        return 0; 
    }

    public static void main(String[] args) throws IOException{
        init();
        for(int q : query){
            System.out.println(Arrays.binarySearch(A, q));
        }

        System.out.println(sb);

    }
}