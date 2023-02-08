import java.io.*;
import java.util.*; 

class State{
    int[] state;
    State(int[] x){
        state = new int[3];
        for(int i=0; i<3; i++){
            state[i] =  x[i];
        }
    }

    State move(int from, int to, int[] limit){
        int[] nextState = new int[]{state[0], state[1], state[2]};
        //to가 전부 차는 경우 
        if(state[from]+state[to]>=limit[to]){
            nextState[to] = limit[to];
            //남아있는 양을 뺀만큼 채운다. 
            nextState[from] -= limit[to] - state[to];
        }else{
            //to를 전부 못 채우는 경우
            nextState[to] += state[from];
            nextState[from] = 0; 
        }
        
        return new State(nextState);
    }
}

public class BOJ2251{
    static int[] limit; 
    static boolean[] possible; 
    static boolean[][][] visit; 
    // A가 비어있을 때 C에 담겨있을 수 있는 물의 양을 구해내기 
    static void bfs(int x1, int x2, int x3){
        Queue<State> que = new LinkedList<>(); 
        visit[x1][x2][x3] = true; 
        que.add(new State(new int[] {x1, x2, x3}));
        while(!que.isEmpty()){
            State current = que.poll();
            if(current.state[0]==0){possible[current.state[2]]=true; }
            for(int from =0; from<2; from++){
                for(int to=0; to<2; to++){
                    State next = current.move(from, to, limit);
                    if(visit[next.state[0]][next.state[1]][next.state[2]])continue; 
                    visit[next.state[0]][next.state[1]][next.state[2]] = true;
                    que.add(next);
                }
            }
            
        }


    }
    
    // 각 부피가 A,B,C 리터인 세개의 물통 ~200 
    // A, B는 비어있음 
    // C는 가득 차있음 
    // 한물통이 비거나, 다른 한물통이 가득찰 때까지 물을 부음 
    
    
    public static void main(String[] args){
        
    }
}