import java.util.*;
import java.io.*;



public class BOJ7562 {
    static int size;
    static int[][] distance;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy ={1, 2, 2, 1, -1, -2, -2, -1};
    static void BFS(int startX, int startY, int Dx, int Dy){
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[] {startX, startY});
        distance[startX][startY] =0; 
        
        while(!que.isEmpty()){
            int[] cur = que.poll(); 
            for(int dir=0; dir<8; dir++){
                int nextX = cur[0] + dx[dir];
                int nextY = cur[1] + dy[dir];
                if(nextX<0||nextY<0||nextX>=size||nextY>=size)continue; 
                if(distance[nextX][nextY]>=0)continue; 
                
                distance[nextX][nextY] = distance[cur[0]][cur[1]]+1; 
                que.add(new int[] {nextX, nextY});
            }
        }
    }
    static void printRes(int destinationX, int destinationY){
        System.out.println(distance[destinationX][destinationY]);
    }
    static void initDistance(int size){
        distance= new int[size][size];
        for(int[] d: distance){
            Arrays.fill(d, -1);
        } 
    }
    static void print(String data){
        System.out.println(data);
    }
    static void dMap(){
        for(int[] d: distance){
            for(int a : d){
                System.out.print("  "+a+"  ");
            }System.out.println(" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
        int numTC = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<numTC; i++){
            tokens = new StringTokenizer(buffer.readLine()); 
            size = Integer.valueOf(tokens.nextToken());
            initDistance(size);
            tokens = new StringTokenizer(buffer.readLine()); 
            int startX = Integer.valueOf(tokens.nextToken());
            int startY = Integer.valueOf(tokens.nextToken());
            tokens = new StringTokenizer(buffer.readLine()); 
            int destinationX = Integer.valueOf(tokens.nextToken());
            int destinationY = Integer.valueOf(tokens.nextToken());
            BFS(startX, startY, destinationX, destinationY);
            dMap();
            printRes(destinationX, destinationY);
        }
    }
}
