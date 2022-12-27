import java.util.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;

public class BOJ2468 
{
    static int size;
    static int[][] map; 
    static int[][] distance; 
    static int maxHeight = 0; 
    static int numOfSafeZone; 
    static int maxNumOfSafeZone =0; 
    static int[] dx = {-1,1,0,0};
    static int[] dy ={0,0,1,-1};

    public static void initDistance()
    {
        for(int[] d : distance){
            Arrays.fill(d,-1);
        }
    }
    public static void init() throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        size = Integer.valueOf(tokens.nextToken());
        map = new int[size][size];
        distance = new int[size][size];
        initDistance(); 
        
        for(int x=0; x<size; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<size; y++){
                int limitHeight = Integer.valueOf(tokens.nextToken());
                map[x][y] = limitHeight; 
                if(limitHeight>maxHeight)maxHeight=limitHeight;
            }
        }
    }

    public static void print2D(int[][] map)
    {
        for(int[]ma:map){
            for(int m: ma){
                System.out.print(" "+m);
            }System.out.println(" ");
        }
    }
    public static void BFS(int startX, int startY, int height)
    {
        Queue<int[]> que = new LinkedList<>(); 
        distance[startX][startY]=1;
        numOfSafeZone++;
        que.add(new int[]{startX, startY});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int dir=0; dir<4; dir++){
                int nextX = cur[0]+dx[dir];
                int nextY = cur[1]+dy[dir];
                if(nextX<0||nextY<0||nextX>=size||nextY>=size) continue;
                if(distance[nextX][nextY]!=-1)continue; 
                if(map[nextX][nextY]<=height)continue;
                que.add(new int[] {nextX, nextY}); 
                distance[nextX][nextY] = 1; 
                
            }
            distance[startX][startY]=1;
        }
    }
    static void print(String data){
        System.out.println(data);
    }
    public static void main(String[] args) throws IOException
    {
        init();
        for(int height =0; height<maxHeight; height++)
        {
            initDistance();
            numOfSafeZone =0;     
            for(int x=0; x<size; x++)
            {
                for(int y=0; y<size; y++)
                {
                    if(map[x][y]>height&&distance[x][y]==-1){
                        BFS(x,y,height);
                    }
                }
            }if(maxNumOfSafeZone<numOfSafeZone){maxNumOfSafeZone=numOfSafeZone;}
        }System.out.println(maxNumOfSafeZone);
    }
}