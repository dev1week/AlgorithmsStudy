import java.io.*;
import java.util.*; 

public class BOJ2146 {

    static int Size;
    static int[][] map; 
    static StringBuilder sb = new StringBuilder();
    static boolean[][] isVisited; 
    static Queue<Integer[]> que = new LinkedList<>();
    static int[][] distance;


    //가장 짧은 다리 

    static void init() throws NumberFormatException, IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Size = Integer.valueOf(buffer.readLine());
        map = new int[Size][Size];
        isVisited = new boolean[Size][Size];
        distance = new int[Size][Size];
        for(int[] d:distance){
            Arrays.fill(d, 10000);
        }
        for(int x=0; x<Size; x++){
            StringTokenizer tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<Size; y++){
                int mapData =Integer.valueOf(tokens.nextToken()); 
                map[x][y] = mapData;
                if(mapData == 1){
                    que.add(new Integer[] {x,y});
                }
            }
        }
    }
    static boolean isNotValidated(int x, int y){
        return x<0||y<0||x>=Size||y>=Size; 

    }
    static boolean isLand(int x,int y){
        return map[x][y] ==1;
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int BFS(int startX, int startY){
        isVisited = new boolean[Size][Size];
        que.add(new Integer[]{startX, startY});
        isVisited[startX][startY] = true;
        int length =0; 
        while(!que.isEmpty()){
            Integer[] current = que.poll(); 
            Integer currentX = current[0];
            Integer currentY = current[1]; 
            
            for(int dir=0; dir<4; dir++){
                int nextX = currentX + dx[dir];
                int nextY = currentY + dy[dir];
                if(isNotValidated(nextX, nextY)){continue;}
                if(isVisited[nextX][nextY]){continue;}
                if(isLand(nextX, nextY)){return length;}    
                que.add(new Integer[] {nextX, nextY});
                isVisited[nextX][nextY] = true; 
                length +=1; 
            }   
        }
        return -1;
    }

    static void print2D(int[][] map){
        for(int[] m: map){
            for(int d : m){
                sb.append(d+" ");
            }sb.append("\n");
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException{
        init();
        for(int x=0; x<Size; x++){
            for(int y=0; y<Size; y++){
                if(isLand(x,y)){
                    int result =BFS(x,y);
                    if(result>-1){
                        distance[x][y] = result ;
                    }
                }
            }
        }
        print2D(distance);
        System.out.println(sb);
    }

    
}
