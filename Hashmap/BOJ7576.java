import java.util.*;
import java.io.*; 
public class BOJ7576 {
    static Queue<int[]> queue = new LinkedList<>(); 
    static int H; 
    static int W; 
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] distance; 
    static int max = 1; 
    static void BFS(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int dir=0; dir<4; dir++){

                int tmpX = cur[0]+dx[dir];
                int tmpY = cur[1]+dy[dir]; 
                if(tmpX<0||tmpY<0||tmpX>=H||tmpY>=W){continue;}
                if(map[tmpX][tmpY]!=0){ continue; }
                if(distance[tmpX][tmpY]>0){continue;}
                queue.add(new int[] {tmpX, tmpY});
                map[tmpX][tmpY]=1; 
                distance[tmpX][tmpY] = distance[cur[0]][cur[1]]+1; 
                if(distance[tmpX][tmpY]>max) max = distance[tmpX][tmpY]; 
            }
        }
    }

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        W = Integer.valueOf(tokens.nextToken());
        H = Integer.valueOf(tokens.nextToken()); 
        map = new int[H][W]; 
        distance = new int[H][W];
        for(int[] d: distance){
            Arrays.fill(d,0); 
        }
        for(int x=0; x<H; x++){
            tokens = new StringTokenizer(buffer.readLine()); 
            for(int y=0; y<W; y++){
                Integer value = Integer.valueOf(tokens.nextToken());
                map[x][y] = value; 
                if(value==-1)distance[x][y]=-1;
                if(value!=1)continue; 
                distance[x][y] =1; 
                queue.add(new int[] {x,y});
            }
        }
    }
        
    static void print2DArray(int[][] map){
        for(int[] l : map){
            for(int v : l){
                System.out.print("  "+v);
            }System.out.println(); 
        }
    }
    static void printQueue(Queue que){
        Iterator it = que.iterator();  
        while(it.hasNext()){
            int[] value = (int[]) it.next(); 
            System.out.println(value[0]+" "+value[1]);
        }
    }
    static void print(String data){
        System.out.println(data);
    }
    //BFS()
        //네 방향의 토마토는 익음 
        //큐에서 뺄때마다 날짜 카운트 
    static boolean isUnetableTomato(){
        for(int[] l : map){
            for(int v : l){
                if(v==0){return true;}
            }
        }return false; 
    }
    //isUnetableTomato()
        //전역 검사 
            // 하나라도 0 -> 1 리턴 
        // 0리턴 
    //init()
        //입력 받으면서 익은 부분의 좌표는 큐에 바로 넣어버린다. 
        //distance에도 1로 바꿔준다. 
        public static void main(String args[]) throws IOException{
            init();
            BFS(); 
            print2DArray(distance);
            if(isUnetableTomato()){System.out.print(-1);}
            else{System.out.println(max-1);};

    }
}
