import java.io.*;
import java.util.*; 



public class BOJ15683{
    static StringBuilder sb = new StringBuilder(); 
    static int[] dx ={1,0,-1,0}; //남,동,북,서 남을 기준으로 시계방향
    static int[] dy ={0,1,0,-1}; //남,동,북,서 남을 기준으로 시계방향
    static int[][] map;          //사무실 지도 
    static int[][] camMap;       //CCTV 감시 지역 지도 
    static ArrayList<Integer[]> cctvList  = new ArrayList<>();; 
    static int H;                //map의 세로 크기 
    static int W;                //map의 가로 크기 
    static int minSize = 0; 

    static boolean isOutSide(int x, int y){ // 주어진 좌표의 범위가 map 밖으로 나가는지 확인 
        return x<0||x>=H||y<0||y>=W;
    }
    //현재 위치 x, y에서 dir 방향의 모든 칸을 벽을 만나기 전까지 7로 변경헌다. 
    static void update(int x, int y, int dir){
        dir%=4;
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(isOutSide(x, y)||camMap[x][y]==6)return; //밖으로 나가거나 벽을 만났을 경우 강제 종료 
            if(camMap[x][y]!=0)continue;                //cctv를 만났을 경우 스킵 
            camMap[x][y] =7;                            //감시영역으로 설정함 
        }
    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        
        camMap = new int[H][W];
        map = new int[H][W];
        for(int x=0; x<H; x++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int y=0; y<W; y++){
                map[x][y] = Integer.valueOf(tokens.nextToken());
                if(map[x][y]!=0&&map[x][y]!=6){
                    cctvList.add(new Integer[] {x,y});}//cctv 발견시 추가 
                if(map[x][y]==0){minSize++;}          // 빈곳 발견시 최소값 증가 
            }
        }
    }

    // static void print2D(int[][] map){
    //     sb.append("\n");
    //     for(int[] ma : map){
    //         for(int m: ma){
    //             sb.append(m).append(" ");
    //         }sb.append("\n");
    //     }
    // }

    // static void printCCTV(){
    //     for(Integer [] cctvPosition : cctvList){
    //         for(int pos : cctvPosition){
    //             sb.append(pos).append(" ");
    //         }sb.append("\n");
    //     }
    // }
    static void process(){
        long numOfCases = 1; 
        for(int i=0; i<cctvList.size(); i++) {numOfCases *=4;}
        for(int cases=0; cases<numOfCases; cases++){
            for(int x=0; x<H; x++){
                for(int y=0; y<W; y++){
                    camMap[x][y]=map[x][y];
                }
            }
            int dirCase = cases;
            for(int cctv=0; cctv<cctvList.size(); cctv++){
                int dir = dirCase%4;
                dirCase/=4;
                Integer[] position = cctvList.get(cctv);
                int x = position[0];
                int y = position[1];
                if(map[x][y] == 1){
                    update(x,y,dir);
                }
                else if(map[x][y] == 2){
                    update(x,y,dir);
                    update(x,y,dir+2);
                }
                else if(map[x][y] == 3){
                    update(x,y,dir);
                    update(x,y,dir+1);
                }
                else if(map[x][y] == 4){
                    update(x,y,dir);
                    update(x,y,dir+1);
                    update(x,y,dir+2);
                }
                else{ // board1[x][y] == 5
                    update(x,y,dir);
                    update(x,y,dir+1);
                    update(x,y,dir+2);
                    update(x,y,dir+3);
                }
                int countCantWatch =0;
                for(int px=0; px<H; px++){
                    for(int py=0; py<W; py++){
                        if(camMap[px][py]==0){
                            countCantWatch++;
                        }
                    }
                }
                if(minSize>countCantWatch){minSize = countCantWatch;}
            }   

        }

    }
    public static void main(String[] args) throws IOException{
        init();
        process();
        System.out.print(minSize);

    }
}