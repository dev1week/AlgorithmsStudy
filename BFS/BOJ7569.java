import java.io.*;
import java.util.*; 

public class BOJ7569 {

    static int H;
    static int W;
    static int D; 
    static int[][][] map; 
    static int[][][] distance;
    static StringBuilder sb = new StringBuilder(); 
    static Queue<int[]> que = new LinkedList<>();
    static int max = -1000000;

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        W = Integer.valueOf(tokens.nextToken());
        H = Integer.valueOf(tokens.nextToken());
        D = Integer.valueOf(tokens.nextToken());
        map = new int[H][W][D];
        distance = new int[H][W][D];
        for(int[][] dis: distance){
            for(int[] di: dis){
                Arrays.fill(di, -1);
            }
        }
        for(int z=0; z<D; z++){
            for(int x=0; x<H; x++){
                tokens = new StringTokenizer(buffer.readLine());
                for(int y =0; y<W; y++){
                    int data = Integer.valueOf(tokens.nextToken());
                    map[x][y][z]= data; 
                    if(data ==1){
                        que.add(new int[] {x,y,z});
                        distance[x][y][z] =0; 
                    }
                }
            }
        }
    }

    static void print3Dmap(int[][][] map){
        for( int z=0; z<D; z++){
            for(int x=0; x<H; x++){
                for(int y=0; y<W; y++){
                    sb.append(map[x][y][z]+"   "); 
                }sb.append("\n");
            }sb.append("\n");
        }
    }
    //다익었는지 확인함 
    static boolean isAllMatured(){
            //전역 검색
                //if == 0 
                    // false 
        for(int z=0; z<D; z++){
            for(int x=0; x<H; x++){
                for(int y=0; y<W; y++){
                    if(map[x][y][z]==0){
                        return false; 
                    }
                    if(distance[x][y][z]>max){
                        max=distance[x][y][z];
                    }
                }
            }
        }
        return true; 
    }
    
    static boolean isNotValidated(int x, int y, int z){
        return x<0||y<0||z<0||z>=D||x>=H||y>=W;
    }

    static boolean isNotEmpty(int x, int y, int z){
        return map[x][y][z]!=0;
    }
    static boolean isVisited(int x, int y, int z){
        return distance[x][y][z] > -1; 
    }

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static void BFS(){
        while(!que.isEmpty()){
            int current[] = que.poll(); 
            int currentX = current[0];
            int currentY = current[1];
            int currentZ = current[2];
            for(int dir=0; dir<6; dir++){
                int nextX = currentX + dx[dir];
                int nextY = currentY + dy[dir];
                int nextZ = currentZ + dz[dir];
                if(isNotValidated(nextX, nextY, nextZ)){continue;}
                if(isNotEmpty(nextX, nextY, nextZ)){continue;}
                if(isVisited(nextX, nextY, nextZ)){continue;}
                que.add(new int[]{nextX, nextY, nextZ});
                map[nextX][nextY][nextZ] =1;
                distance[nextX][nextY][nextZ] = distance[currentX][currentY][currentZ] +1; 
            }
        }
    }
    //다 익어있을 경우 시작하지 않음 (맵에 0이 없어야한다)
    static boolean isNeedToStart(){
        for(int[][] ma: map){
            for(int[] m: ma){
                for(int d: m){
                    if(d==0){
                        return true; 
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{

        //토마토가 모두 익는데 걸리는 최소 시간 
        
        init();
        //이미 다 익어있을 경우 시작하지 않음 
        if(isNeedToStart()){
            BFS();
            //다 돌고 나서 다 익어있을 경우 거리의 최대값을 출력함 
            if(isAllMatured()){
                sb.append(max).append("\n");
            }// 다 돌았는데도 안익은 것이 하나라도 있을 경우 -1출력함 
            else{
                sb.append(-1).append("\n");
            }
        }else{
            sb.append(0).append("\n");
        }
        //처음 상태에서 모두 익었는지 확인 
            //익었으면 0 출력후 종료 
        //BFS()로 익는 로직 만들기 
        //모두 익었는지 확인 
            //다 안익었으면 -1 출력 후 종료 
        System.out.println(sb);
    }
}
