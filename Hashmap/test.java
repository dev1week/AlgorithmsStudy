import java.io.*;
import java.util.*;

public class test {
    static int H;
    static int W; 
    static int[][] map; 
    static int[][] distance; 
    static int[] dx = {1,0,-1,0};
    static int[] dy ={0,1,0,-1};



    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        distance = new int[H][W];
        for(int[] d : distance){
            Arrays.fill(d,-1); 
        }
        for(int x=0; x<H; x++){
            String line = buffer.readLine();
            for(int y=0; y<W; y++){
                map[x][y] = Integer.valueOf(line.charAt(y)-'0');
            }
        }

    }
    static public void printMap(){
        System.out.println("0 1 2 3 4 5 6");
        for(int x=0; x<map.length; x++){
            System.out.print(x);
            for(int y=0;y<map[0].length; y++){
                System.out.print(" "+map[x][y]);
            }System.out.print("\n");
        }
    }

    static public void printDistance(){
        
        for(int x=0; x<distance.length; x++){
        
            for(int y=0;y<distance[0].length; y++){
                System.out.print(" "+distance[x][y]);
            }System.out.print("\n");
        }
    }

    static void print(String data){
        System.out.println(data); 
    }
    static int BFS(int startX, int startY){
        Queue<int[]> queue = new LinkedList(); 
        if(distance[startX][startY]!=-1){return 0;}
        distance[startX][startY]=1; 
        
        queue.add(new int[] {startX, startY});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll(); 
            for(int dir=0; dir<4; dir++){
                int nextX = cur[0]+dx[dir];
                int nextY = cur[1]+dy[dir]; 
                
                if(nextX<0||nextY<0||nextX>=H||nextY>=W)continue; 
                if(distance[nextX][nextY]!=-1)continue; 
                if(map[nextX][nextY]!=1)continue; 
                distance[nextX][nextY] = distance[cur[0]][cur[1]]+1; 
                queue.add(new int[] {nextX, nextY});
                
            }
        }
        return 1; 
    }
    static public void main(String[] args) throws IOException{
        init(); 
        BFS(0,0);
        System.out.println(distance[H-1][W-1]);
        //BFS(0,0) -> distance 길이 저장 
        //distance[H][W]-distance[0][0]
    }
}

