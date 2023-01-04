import java.io.*;
import java.util.*; 

public class test {
    static int N;
    static int M; 
    static int[] result;
    static boolean[] isVisit;
    static StringBuilder sb = new StringBuilder(); 

    static void printArr(int[] result){
        for(int a : result){
            sb.append(a).append(" ");
        }sb.append("\n");
    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());

        result = new int[M];
        isVisit = new boolean[N+1];
    }
    static void BT(int current){
        if(current==M-1){
            
        }
        for(int next=1; next<=N; next++){
            if(isVisit[next])continue; 
            result[current] = next;
            
        }
    }
    public static void main(String[] args){

    }
    
}

