import java.io.*;
import java.util.*; 
public class BOJ7576_1 {
    static int H;
    static int W;
    static int[][] map; 
    static int[][] distance; 
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    static int max = 0; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
        W = Integer.valueOf(tokens.nextToken()); 
        H = Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        distance = new int[H][W]; 

        for(int x=0; x<H;x++){
            tokens= new StringTokenizer(buffer.readLine());
            for(int y=0; y<W; y++){
                map[x][y] = Integer.valueOf(tokens.nextToken()); 
                if(map[x][y]==1){ 
                    que.add(new int[] {x,y});
                    distance[x][y] =1; 
                 }else if(map[x][y]==-1)distance[x][y]=-1; 
            }
        }
    
    }

    static void print2Dmap(int[][] map){
        for(int[] x : map){
            for(int y : x ){
                System.out.print("  "+y);
            }System.out.println(" ");
        }
    }
    static void print(String data){
        System.out.println(data);
    }
    static void BFS(){
        while(!que.isEmpty()){
            
            int[] cur = que.poll(); 
            for(int dir=0; dir<4; dir++){
                
                int tmpX = cur[0] + dx[dir];
                int tmpY = cur[1] + dy[dir];
                
                if(tmpX<0||tmpY<0||tmpX>=H||tmpY>=W){continue;} 
                if(map[tmpX][tmpY]!=0){continue;} 
                if(distance[tmpX][tmpY]!=0){continue;} 
                
                distance[tmpX][tmpY] = distance[cur[0]][cur[1]]+1; 
                map[tmpX][tmpY] =1; 
                max(distance[tmpX][tmpY]);
                que.add(new int[] {tmpX, tmpY});
            }
        }
    }
    static void max(int data)
    {
        if(max<data){
            max = data; 
        }
    }
    static boolean isUnTomato(){
        for(int[] x: map){
            for(int y: x)
            if(y==0)return true; 
        }
        return false; 
    }
    public static void main(String[] args) throws IOException{
        //하루가 지날 때 마다 4방향의 토마토가 익는다. 
        //전부다 읻을 때 최소 일수 
        init();
        BFS(); 
        if(isUnTomato())print(-1+"");
        else if(max==0)print(0+"");
        else print(max-1+"");
        //bfs -> 토마토 익는 로직 구현 
        //안익은 토마토가 있다면 0 출력하는 로직 (전체 조회)
        //distance값 출력 

    }
    
}
