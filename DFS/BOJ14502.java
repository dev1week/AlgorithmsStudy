import java.io.*;
import java.util.*;

public class BOJ14502 {
    static StringBuilder sb = new StringBuilder();
    static int max = Integer.MIN_VALUE;
    static int N, M, blockCnt, ans;
    static int[][] map, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //칸을 막을 수 있는 모든 경우의 수 4만 1000가지 

    static boolean isValid(int x, int y){    
        return x<1||y<1||x>N||y>M;
    }
    
    

    static void bfs(){
        Queue<Integer> que = new LinkedList<>(); 
        int cnt=0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                visit[i][j] = false;
                if(map[i][j]==2){
                    que.add(i);
                    que.add(j);
                    visit[i][j] = true; 
                }
            }
        }

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll(); 

            for(int[] direction : dir ){
                int nextX = direction[0];
                int nextY = direction[1];
                if(isValid(x, y)){continue;}
                if(visit[nextX][nextY]){continue;}
                if(map[nextX][nextY] !=1 ){continue;}
                visit[nextX][nextY] = true; 
                que.add(nextX);
                que.add(nextY);
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(map[i][j]==0 && !visit[i][j]){cnt++;}
                ans = Math.max(ans, max);
                }
            }
        }
    }

    // 벽을 직접 다 세워본다. 
    //idx 칸에 벽을 세울지 말지 결정 
    static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            bfs();
            return ;
        }else{

        }
        if(idx > blockCnt) return; //더 이상 세울 수 있는 벽이 없는 상태 
        //벽을 세우는 경우의 수 탐색 
        map[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx+1, selected_cnt+1);

        //벽을 세우지 않는 경우의 수 탐색 
        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx+1, selected_cnt);
    }
    // 탐색을 통해서 바이러스로부터 안전한 구역 확인하기 


    static void process(){
        //모든 벽의 위치를 모아놓자 
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j]==0){
                    blockCnt ++;
                    blank[blockCnt][0] = i;
                    blank[blockCnt][1] = j; 
                }
            }
        }
        //blank에 저장된 세울 수 있는 벽의 위치 중 랜덤으로 3개 뽑는다. 

    }
}
