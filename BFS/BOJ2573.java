


import java.io.*;
import java.util.*;


public class BOJ2573 {
    public static int numOfIce = 0; 
    public static int year = 0; 


    public static int[][] map;
    public static int[][] tmpMap; 
    public static int[][] visit;
    
    public static int H;
    public static int W; 

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        map = new int[H][W];
        tmpMap = new int[H][W];
        visit = new int[H][W];
        for(int x=0; x<H; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<W; y++){
                map[x][y] = Integer.valueOf(tokens.nextToken());
            }
        }
    };
    public static void print(String data){
        System.out.print(data);
    }
    public static void print2D(int[][] arr){
        for(int[] ar: arr){
            for(int a: ar){
                print(a+"  ");
            }print("\n");
        }
    }

    public static boolean isIceed(){
        for(int[] ma: map){
            for(int m: ma){
                if(m>0){
                    return true; 
                }
            }
        }
        return false;
    }
    public static void copyMap(){
        
        for(int x=0; x<H; x++){
            for(int y=0; y<W; y++){
                tmpMap[x][y] = map[x][y];
            }
        }
    }

    public static void melting(){
        int meltingCoeff; 
        copyMap();
        for(int x=0; x<H; x++)
        {
            for(int y=0; y<W; y++){
                if(tmpMap[x][y]>0){
                    meltingCoeff = 0; 
                    for(int dir=0; dir<4; dir++){
                        int tmpX = x+dx[dir];
                        int tmpY = y+dy[dir]; 
                        if(tmpX<0||tmpY<0||tmpX>=H||tmpY>=W)continue; 
                        if(tmpMap[tmpX][tmpY]!=0)continue; //바다가 아니면 안센다
                        meltingCoeff ++; 
                    }if(tmpMap[x][y]-meltingCoeff<0)map[x][y]=0;
                    else map[x][y] -= meltingCoeff; 
                }
            }
        }
        //전체 맵 순회 
            //if map>0
                //for(방향)
                    //좌표얻기 
                    //맵에 접근하여 0인지 확인 
                        //0일 경우 count 증가 
                        // 맵 요소값 - count 
                            //양수이면 그대로 넣기 
                            //음수이면 0으로 넣기 

    }
    public static void BFS(int startX, int startY){
        visit[startX][startY] = 1;
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[] {startX, startY});
        while(!que.isEmpty()){
            int[] cur = que.poll(); 
            for(int dir=0; dir<4; dir++){
                int tmpX = cur[0] + dx[dir];
                int tmpY = cur[1] + dy[dir];
                if(tmpX<0||tmpY<0||tmpX>=H||tmpY>=W)continue; 
                if(visit[tmpX][tmpY]==1||map[tmpX][tmpY]==0)continue;
                que.add(new int[] {tmpX,tmpY});
                visit[tmpX][tmpY]=1; 
            }
        }
    }
    public static int logic(){
        while(numOfIce<2){
            if(!isIceed()){return 0;}
            melting();
            numOfIce=0; 
            visit = new int[H][W];
             
            for(int x=0; x<H; x++){
                for(int y=0;y<W; y++){
                    if(map[x][y]>0&&visit[x][y]==0){
                        BFS(x,y);
                        numOfIce++; 
                    }
                }
            }    
            year++; 
        }return year; 
        
    }
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(logic());
    }
    
}
