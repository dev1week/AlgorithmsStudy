import java.io.*;
import java.util.*;

public class BOJ5427 {
    static int min =10000; 
    static int W;
    static int H; 
    static Scanner sc = new Scanner(System.in); 
    static int[][] fireDistance;
    static int[][] jDistance;
    static String[][] map;
    static int fireStartX;
    static int fireStartY;
    static int jStartX;
    static int jStartY;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Integer[]> jQue = new LinkedList<>();
    static Queue<Integer[]> fQue = new LinkedList<>();
    static void initDistance(int[][] distance){
        for(int[] d : distance){
            Arrays.fill(d, -1);
        }
    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W  = Integer.valueOf(tokens.nextToken());
        map = new String[H][W];
        fireDistance = new int[H][W];
        jDistance = new int[H][W];
        initDistance(fireDistance);
        initDistance(jDistance);
        for(int x=0; x<map.length;x++){
            String line = buffer.readLine();
            for(int y=0; y<map[x].length; y++){
                map[x][y] = String.valueOf(line.charAt(y));
                if(map[x][y].equals(String.valueOf('J'))){jQue.add(new Integer[] {x,y}); jDistance[x][y]=0;}
                if(map[x][y].equals(String.valueOf('F'))){fQue.add(new Integer[] {x,y}); fireDistance[x][y]=0;}
            }
        }
    }
    static void print2Dmap(String[][] map){
        for(String[] ma: map){
            for(String m : ma){
                System.out.print(m);
            }
            System.out.println();
        }
    }

    static void BFS(int[][] distance, int startX, int startY){

    }

    static void fBFS(){
        while(!fQue.isEmpty()){
            Integer[] current = fQue.poll(); 
            for(int dir=0; dir<4; dir++){
                int nextX = current[0] + dx[dir];
                int nextY = current[1] + dy[dir];
                if(nextX<0 || nextX>=H||nextY>=W||nextY<0)continue;
                if(fireDistance[nextX][nextY]!=-1)continue;
                if(map[nextX][nextY].equals(String.valueOf('#')))continue;
                fireDistance[nextX][nextY] = fireDistance[current[0]][current[1]]+1; 
                fQue.add(new Integer[] {nextX, nextY});
            }
        }
    }

    static void JBFS(){
        while(!jQue.isEmpty()){
            Integer[] current = jQue.poll(); 
            for(int dir=0; dir<4; dir++){
                int nextX = current[0] + dx[dir];
                int nextY = current[1] + dy[dir];
                if(nextX<0 || nextX>=H||nextY>=W||nextY<0)continue;
                if(jDistance[nextX][nextY]!=-1)continue;
                if(map[nextX][nextY].equals(String.valueOf('#')))continue;
                jDistance[nextX][nextY] = fireDistance[current[0]][current[1]]+1; 
                jQue.add(new Integer[] {nextX, nextY});
            }
        }
    }

    static void jBFS(){
        while(!jQue.isEmpty()){
            Integer[] current = jQue.poll(); 
            for(int dir=0; dir<4; dir++){
                int nextX = current[0] + dx[dir];
                int nextY = current[1] + dy[dir];
                if(nextX<0||nextY<0||nextX>=H||nextY>=W){
                    if(fireDistance[current[0]][current[1]]!=-1 && fireDistance[current[0]][current[1]] <=jDistance[current[0]][current[1]]+1)continue;
                    System.out.println(jDistance[current[0]][current[1]]+1);
                    //BFS 특성상 큐에 거리순으로 채워지기 때문에 처음 출력되는 수가 최소이다. 
                    return;
                }
                if(jDistance[nextX][nextY]>-1||map[nextX][nextY].equals(String.valueOf('#')))continue;
                if(fireDistance[nextX][nextY]!=-1 && fireDistance[nextX][nextY] <=jDistance[nextX][nextY]+1)continue;
                jDistance[nextX][nextY] = jDistance[current[0]][current[1]]+1; 
                jQue.add(new Integer[] {nextX, nextY});
            }
        
        }System.out.println("IMPOSSIBLE");    
    }

    static void jjBFS(){
        while(!jQue.isEmpty()){
            Integer[] current = jQue.poll(); 
            for(int dir=0; dir<4; dir++){
                int nextX = current[0] + dx[dir];
                int nextY = current[1] + dy[dir];
                if(nextX<0||nextY<0||nextX>=H||nextY>=W){
                    continue;
                }
                if(jDistance[nextX][nextY]>-1||map[nextX][nextY].equals(String.valueOf('#')))continue;
                if(fireDistance[nextX][nextY]!=-1 && fireDistance[nextX][nextY] <jDistance[nextX][nextY])continue;
                jDistance[nextX][nextY] = jDistance[current[0]][current[1]]+1; 
                jQue.add(new Integer[] {nextX, nextY});
            }
        }
    }
    static void print2Darr(int[][] distance){
        for(int[] d: distance){
            for(int l: d){
                System.out.print(l+"   ");
            }System.out.print("\n");
        }
    }

    static void judge(){
        for(int i=0; i<H; i++){
            if((fireDistance[i][0]>jDistance[i][0]&&jDistance[i][0]!=-1)||fireDistance[i][0]==-1){
                System.out.println("tr");
                min = jDistance[i][0];
                // if(min>jDistance[i][0]){
                //     min = jDistance[i][0];
                // }
            }
            if(fireDistance[i][W-1]>jDistance[i][W-1]&&jDistance[i][W-1]!=-1){
                System.out.println("tr");
                min = jDistance[i][W-1];
                // if(min>jDistance[i][W-1]){
                //     min = jDistance[i][W-1];
                // }
            }
        }
        for(int i=0; i<W; i++){
            if(fireDistance[H-1][i]>jDistance[H-1][i]&&jDistance[H-1][i]!=-1){
                System.out.println("tr");
                min = jDistance[H-1][i];
                // System.out.println();
                // if(min>jDistance[H-1][i]){
                //     min = jDistance[H-1][i];
                // }
            }
            if(fireDistance[0][i]>jDistance[0][i]&&jDistance[0][i]!=-1){
                System.out.println("tr");
                min = jDistance[0][i];
                // if(min>jDistance[0][i]){
                //     min = jDistance[0][i];
                // }
            }
        }
        if(min == 10000 || min==-1 ){System.out.println("IMPOSSIBLE");}
        else{System.out.println(min+1);}
    }
    public static void main(String[] args) throws IOException{
        init(); 
        fBFS();
        jBFS();
        jjBFS();

        print2Darr(fireDistance);
        System.out.println();
        System.out.println();
        print2Darr(jDistance);
        //judge();
        
    }
    //bfs로 불의 distance 구하기 
    //bfs로 지훈이의 distance 구하기
    //모든 가장자리 순회   
        //불d>지훈d 
            //min값 업데이트 
    //min == 초기 초기화 값 -> impossible
    //     <             -> min 값 출력 

}
