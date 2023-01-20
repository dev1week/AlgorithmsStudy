import java.io.*;
import java.util.*; 

public class BOJ1926 {
    static int H;
    static int W; 
    
    static int[][] maps; 
    static boolean[][] isVisted; 
    //그림의 갯수 
    
    
    static StringBuilder sb = new StringBuilder();

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        maps = new int[H][W];
        isVisted = new boolean[H][W];
        for(int x=0; x<H; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<W; y++){
                maps[x][y] = Integer.valueOf(tokens.nextToken());
            }
        }
    }

    

    static void print2D(int[][] maps){
        for(int[] ma : maps){
            for(int m : ma){
                sb.append(m +" ");
            }
        }
    }

    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean isValid(int startX, int startY){
        return startX < 0|| startY < 0 || startX>=H||startY>=W;
    }
    static int BFS(int startX, int startY){
        int maxSize=0; // 그림 중 가장 넓이가 넓은 것의 넓이 
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[] {startX, startY});
        isVisted[startX][startY] = true; 
        while(!que.isEmpty()){  
            Integer[] current = que.poll(); 
            maxSize +=1; 
            for(int dir=0; dir<4; dir++){
                int nextX = current[0] + dx[dir];
                int nextY = current[1] + dy[dir];
                if(isValid(nextX, nextY)){continue;}
                if(isVisted[nextX][nextY]){continue;}
                if(maps[nextX][nextY]==0){continue;}
                que.add(new Integer[] {nextX, nextY});
                isVisted[nextX][nextY] = true; 
            }
        }
        return maxSize;
    }
    

    //모든 좌표에 대해 순회 
        //1일 경우&방문하지 않았을 경우만 
            //bfs 
            //그림 개수 카운트 
    

    //BFS()
        //큐에서 빼올 때마다 넓이 증가 
        //그림 중 가장 넓이가 넓은 것의 넓이를 반환 

    public static void main(String[] args) throws IOException{
        init();
        int resultSize = 0;
        int numOfP =0;
        for(int x=0; x<H; x++){
            for(int y=0; y<W; y++){
                if(maps[x][y]==1 && !(isVisted[x][y])){
                    numOfP +=1;
                    resultSize = Math.max(resultSize,BFS(x,y));
                }
            }
        }sb.append(numOfP+"\n"+resultSize);
        System.out.println(sb);
    }
    
}
