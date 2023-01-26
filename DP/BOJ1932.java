import java.io.*;
import java.util.*; 


public class BOJ1932 {
    static StringBuilder sb = new StringBuilder();
    static int[][] tree;
    static int Size; 
    static int[][] D; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        Size = Integer.valueOf(tokens.nextToken());
        tree = new int[Size+1][Size+1];
        D = new int[501][501];

        for(int level = 1; level<=Size; level++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int idx=1; idx<=level; idx++){
                tree[level][idx] = Integer.valueOf(tokens.nextToken());
            }
        }
    }

    static void DP(){
        D[1][1] = tree[1][1];
        D[1][2] = tree[1][1];
        D[2][1] = D[1][1] + tree[2][1]; 
        D[2][2] = D[1][2] + tree[2][2]; 
        for(int i=3; i<=Size; i++){
            D[i][1] = D[i-1][1] + tree[i][1];
            for(int index =2; index<=i-1; index++){
                D[i][index] = Math.max(D[i-1][index-1]+tree[i-1][index], D[i-1][index]+ tree[i-1][index]);
            }
            D[i][i] = D[i-1][i-1] + tree[i-1][i];
        }
        
        //D[i][index] = Math.max(D[i-1][index-1]+tree[i-1][index], D[i-1][index]+ tree[i-1][index])
        int result = 0;
        for(int i =1; i<=Size; i++){
            result = Math.max(result, D[Size+1][i]);
        }
        sb.append(result);

    }

    static void print2D(int[][] arr){
        for(int[] ar: arr){
            for(int a: ar){
                sb.append(a+" ");
            }sb.append("\n");
        }
    }
    public static void main(String[] args) throws IOException{
        init();
        DP();
        print2D(tree);
        System.out.println(sb);
    }
}
