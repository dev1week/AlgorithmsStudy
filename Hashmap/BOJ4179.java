import java.io.*;
import java.util.*;


public class BOJ4179 {
    static String[][] map;
    static int[][] fireDistance; 
    static int[][] JDistance;
    static Queue<int[]> fireQue = new LinkedList<>();
    static Queue<int[]> JQue = new LinkedList<>(); 

    static int H;
    static int W;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken()); 
        map = new String[H][W];
        JDistance = new int[H][W];
        fireDistance = new int[H][W];
        for(int x=0; x<H; x++){
            String line = buffer.readLine();
            for(int y=0; y<W; y++){
                map[x][y] = String.valueOf(line.charAt(y)); 
                if(map[x][y].equals("J")){
                    JDistance[x][y]=1; 
                    JQue.add(new int[] {x,y});
                }
                else if(map[x][y].equals("F")){
                    fireDistance[x][y]=1; 
                    fireQue.add(new int[] {x,y});
                }
            }
        }
    }
    static void print(String data){
        System.out.println(data);
    }
    static void printMap(){
        for(String[] s: map){
            for(String l : s){
                System.out.print(l);
            }System.out.println(" ");
        }
    }
    static void printDistance(int[][] map){
        for(int[] s: map){
            for(int l : s){
                System.out.print(l);
            }System.out.println(" ");
        }
    }
    static void BFS(Queue<int[]> que, int[][] distance){
        while(!que.isEmpty()){
            int[] cur = que.poll(); 
            for(int dir=0; dir<4; dir++){
                int tmpX = cur[0]+dx[dir];
                int tmpY = cur[1]+dy[dir]; 
                print(tmpX+":"+tmpY);
                if(tmpX<0||tmpY<0||tmpX>=H||tmpY>=W){print("경계조건");continue;}
                print(tmpX+":"+tmpY+"="+!(map[tmpX][tmpY].equals('#'))+map[tmpX][tmpY]);
                if(!(map[tmpX][tmpY].toString().equals('.'))){print("움직일수 없음");continue;}
                if(distance[tmpX][tmpY]!=0){print("이미 지나감");continue;}
                print("돌아가는중");
                que.add(new int[] {tmpX, tmpY});
                distance[tmpX][tmpY]= 1+ distance[cur[0]][cur[1]]; 
            }
        }
    }
    public static void main(String[] args)throws IOException{
        init(); 
        BFS(fireQue, fireDistance);
        BFS(JQue, JDistance);
        printMap(); 
        printDistance(JDistance);
        printDistance(fireDistance);
    }
}
