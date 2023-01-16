import java.io.*;
import java.util.*; 


public class BOJ2206{
    static StringBuilder sb = new StringBuilder(); 
    static int H;
    static int W; 
    static int[][] map;
    static int[][][] distance;
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        distance = new int[H][W][2]; 
        for(int i=0; i<2; i++){
            for(int x=0; x<H; x++){
                for(int y=0; y<W; y++){
                    distance[x][y][i] = -1; 
                }
            }
        }
        distance[0][0][0]=0; 
        for(int x=0; x<H; x++){
            String data = buffer.readLine(); 
            for(int y=0; y<W; y++){
                map[x][y]=Integer.valueOf(data.charAt(y)-'0');
            }
        }
    }

    static void print2DMap(int[][] arr){
        for(int[] ar: arr){
            for(int a: ar){
                sb.append(a+" ");
            }sb.append("\n");
        }
    }

    static void printDistance(){
        for(int x=0; x<H; x++){
            for(int y=0; y<W; y++){
                sb.append(distance[x][y][0]+"  ");
            }sb.append("\n");
        }
        enter();
        for(int x=0; x<H; x++){
            for(int y=0; y<W; y++){
                sb.append(distance[x][y][1]+"  ");
            }sb.append("\n");
        }
    }
    static void enter(){
        sb.append("\n");
    }
    static int[] dx = {-1, 1, 0,0};
    static int[] dy = {0,0,-1,1}; 

    static boolean isNotValidated(int x, int y){
        return x<0||y<0||y>=W||x>=H;
    }

    static boolean isObstacle(int x, int y){
        return map[x][y]==1;
    }


    static void BFS(){
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[] {0,0});
        while(!que.isEmpty()){
            int[] current = que.poll();
            int currentX = current[0];
            int currentY = current[1]; 
            for(int dir=0; dir<4; dir++){
                int nextX = currentX + dx[dir];
                int nextY = currentY + dy[dir];
                if(isNotValidated(nextX, nextY)){continue;}

                if(isVisited(nextX, nextY)){continue;}
                if()
            }

        }
        
    }
    public static void main(String[] args) throws IOException{
        init(); 
        print2DMap(map);
        enter(); 
        printDistance(); 
        System.out.println(sb);

    }
}