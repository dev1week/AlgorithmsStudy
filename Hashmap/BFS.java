import java.util.*; 
import java.io.*; 

public class BFS {
    static int[][] board;
    static int w = 0;
    static int h = 0;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] distance; 
    
    public static int BFS(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>(); 
        int count = 0; 
        queue.offer(new int[] {startX, startY});
        distance[startX][startY]=1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            count+=1; 
            for(int i=0; i<4; i++){
                int tmpX = now[0]+dx[i];
                int tmpY = now[1]+dy[i];
                if(tmpX<0||tmpY>=w||tmpY<0||tmpX>=h) continue; 
                if(distance[tmpX][tmpY]!=-1||board[tmpX][tmpY] !=1) continue; 
                distance[tmpX][tmpY] = distance[now[0]][now[1]]+1; 
                queue.offer(new int[] {tmpX, tmpY});
            }
        }
        return count; 
    }
    
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        h = Integer.valueOf(tokens.nextToken());
        w = Integer.valueOf(tokens.nextToken());
        board = new int[h][w];
        distance = new int[h][w];
        for(int d[]:distance){
            Arrays.fill(d,-1);
        }
        for(int x=0; x<h; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<w; y++){
                board[x][y] = Integer.valueOf(tokens.nextToken());
            }
        }
    }
    public static void main(String[] args) throws IOException{
    init(); 
    int max = 0;
    int numPic = 0; 
     for(int x=0; x<h; x++){
        for(int y=0; y<w; y++){
            if(board[x][y]==1 && distance[x][y]==-1){
                numPic+=1; 
                int tmp = BFS(x,y);
                if(max<tmp){
                    max=tmp;
                }
            }
            
        }
     }System.out.println(numPic);
     System.out.println(max);
     for(int x=0; x<distance.length; x++){
        for(int y=0; y<distance[0].length; y++){
            if(distance[x][y]!=-1){
                System.out.print((distance[x][y]>9 ? "" : " " )+distance[x][y]);
            }
            else{System.out.print(" 0");}
        }
        System.out.print("\n");
     }
    }
}
