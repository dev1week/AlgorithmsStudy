import java.io.*;
import java.util.*; 


public class BOJ10451{
    static int H;
    static int W; 
    static int numOfSquare;
    static int[][] map; 
    static StringBuilder sb = new StringBuilder();

    static boolean[][] isVisited; 

    static TreeSet<Integer> sizes = new TreeSet<>();

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        
        H = Integer.valueOf(tokens.nextToken());
        W=Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        isVisited = new boolean[H][W];

        numOfSquare = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<numOfSquare; i++){
            System.out.println(i);
            tokens = new StringTokenizer(buffer.readLine());
            int y1=Integer.valueOf(tokens.nextToken());
            int x1=Integer.valueOf(tokens.nextToken());
            int y2 = Integer.valueOf(tokens.nextToken());
            int x2= Integer.valueOf(tokens.nextToken());
            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2;y++){
                    System.out.println(x+":"+y);
                    map[x][y]=1;
                }
            }
        }

        
    }
    static void print2D(int[][] arr){
        for(int[] ar:arr){
            for(int a: ar){
                sb.append(a+" ");
            }sb.append("\n");
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean isValid(int x, int y){
        return x<0||y<0||x>=H||y>=W;
    }
    static int BFS(int startX, int startY){
        int size =0; 
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[] { startX, startY});
        isVisited[startX][startY] = true; 
        while(!que.isEmpty()){
            int[] current = que.poll(); 
            size+=1; 
            for(int i=0; i<4; i++){
                int nextX = current[0] +1; 
                int nextY = current[1]+1; 
                if(isValid(nextX, nextY)){continue;}
                if(map[nextX][nextY]==1){continue;}
                if(isVisited[nextX][nextY]){continue;}
                que.add(new int[] {nextX, nextY});
                isVisited[nextX][nextY]=true;
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException{
        int numOfRegion=0; 
        init();
        print2D(map);
        System.out.println(sb);
        for(int x=0; x<H; x++){
            for(int y=0; y<W; y++){
                if(!isVisited[x][y]&&map[x][y]==0){
                    numOfRegion +=1; 
                    int sizeOfRegion =BFS(x,y);
                    sizes.add(sizeOfRegion);
                }
            }
        }
        sb.append(numOfRegion+" "+sizes);
        System.out.println(sb);
        //좌표를 입력받아 맵 만들기 (사각형 부분 1로 채우기)
        //맵을가지고 bfs 돌기 (0인곳만 들어가기)
            //bfs 함수 실행할 때마다 -> 영역개수 카운트 
            //큐에서 꺼낼때마다 -> 크기 세서 반환 


    }
}