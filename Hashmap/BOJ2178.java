import java.util.*;
import java.io.*; 
public class BOJ2178 {
    static int[][] map; 
    static int[][] distance; 
    static int W =0; 
    static int H =0;

    static final int[] dx = {-1,0,-1,0};
    static final int[] dy = {0,1,0,1};

    public static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        distance = new int[H][W];
        for(int d[] : distance){
            Arrays.fill(d,-1); 
        }
        for(int x=0; x<H; x++){
            String line = buffer.readLine();
            for(int y=0; y<W; y++){
                map[x][y] = Integer.valueOf(line.charAt(y)-'0');
            }
            // for(int y=0; y<W; y++){
            //     map[x][y] = Integer.valueOf(line[y]);
            // }
        }
    }

    public static void printMap(){
        for(int x =0; x<map.length; x++){
            for(int y=0; y<map[0].length; y++){
                System.out.print(map[x][y]); 
            }System.out.print("\n");
        }
    }
    public static void distanceMap(){
        for(int x =0; x<distance.length; x++){
            for(int y=0; y<distance[0].length; y++){
                System.out.print(distance[x][y]); 
            }System.out.print("\n");
        }
    }
    public static int BFS(int startX, int startY){
        Queue<Integer[]> queue = new LinkedList<>();
        if(distance[startX][startY]!=-1){return 0;}
        queue.add(new Integer[] {startX, startY});
        distance[startX][startY]=1; 
        while(!queue.isEmpty()){
            System.out.println("들어옴");
            Integer[] cur = queue.poll(); 

            int curX = cur[0];
            int curY = cur[1];
            for(int dir=0; dir<4; dir++){
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];
                if(nextX<0||nextY<0||nextX>=W||nextY>=H)continue; 
                if(map[nextX][nextY]!=1||distance[nextX][nextY]!=-1)continue; 
                distance[nextX][nextY] = distance[curX][curY] +1; 
                queue.add(new Integer[] {nextX, nextY});
            }
        }
        return 1; 
    }

    public static void main(String[] args) throws IOException{
        init(); 
        BFS(0,0);
        System.out.println(distance[H-1][W-1]-distance[0][0]);
        distanceMap(); 
    }
}
