import java.io.*;
import java.util.*; 


public class BOJ11403 {
    static StringBuilder sb = new StringBuilder(); 
    static int n;
    static int[][] adj;
    static int[] visit;
    static int[][] res; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
        n = Integer.valueOf(tokens.nextToken()); 
        res = new int[n][n];
        adj = new int[n][n];
        visit = new int[n];
        for(int x=0; x<n; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<n; y++){
                adj[x][y] = Integer.valueOf(tokens.nextToken()); 
            }
        }
    }

    static void print2D(int[][] arr){
        for(int ar[] : arr){
            for(int a: ar){
                sb.append(a+" ");
            }sb.append("\n");
        }
    }
    static boolean isExist(int start, int end ){
        Queue<Integer> que = new LinkedList<>();
        que.add(start); 
        visit[start]= 1; 
        while(!que.isEmpty()){
            int current = que.poll(); 
            for(int next=0; next<n; next++){
                if(visit[next]==1){continue;}
                if(adj[current][next]==0){continue;}
                if(next == end){return true;}
                que.add(next);
                visit[next]=1; 
            }
        }
        return false; 
    }
    static void initRES(){
        for(int [] r: res){
            Arrays.fill(r, 1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        init(); 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visit = new int[n];
                if(isExist(i, j)){
                    res[i][j]=1; 
                }
            }

        }
        print2D(res);

        System.out.println(sb);
    }
}
