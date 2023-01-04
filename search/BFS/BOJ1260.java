package search.BFS;

import java.util.ArrayList;
import java.util.Scanner; 

public class BOJ1260{
    static boolean visited[];
    static ArrayList<Integer>[] A; 
    static int N;
    static int M;
    static int Start;
    public static void inputData(){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt(); 
        Start = scan.nextInt(); 

        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Integer>(); 
        }
        for(int i =0; i<M; i++){
            int S = scan.nextInt();
            int E = scan.nextInt(); 
            A[S].add(E);
            A[E].add(S);
        }

    }
    public static void main(String[] args){
        inputData(); 
        for()

    }


}