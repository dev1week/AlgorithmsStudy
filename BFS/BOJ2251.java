import java.io.*;
import java.util.*;


class State{
    int[] current;
    State(int[] inputs){
        current = new int[3];
        for(int i=0; i<3; i++)current[i] = inputs[i];
    } 

    State move(int start, int end, int[] limit){
        int[] next = new int[]{current[0],current[1],current[2]};
        //붓다가 end가 먼저 차는 경우 
        if(current[start]+current[end]>limit[end]){
            next[end] = limit[end];
            next[start] -= limit[end];  
             
        }else{
            next[end]+=next[start]; 
            next[start]= 0; 
        }//붓다가 start가 먼저 비는 경우 현재 start에 남아있는 양 + end에 남아있는 양 > limit[start]
        return new State(next);            
    }
    
}
public class BOJ2251 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] limit= new int[3];
    static boolean[] possible = new boolean[205];
    static boolean[][][] visit = new boolean[205][205][205];


public static void main(String[] args){


    static void bfs(int a, int b, int c){
        Queue<State> Q = new LinkedList<>(); 
        visit[a][b][c] = true;
        Q.add(new State(new int[]{a,b,c}));

        while(!Q.isEmpty()){
            State currentState = Q.poll();
            if(currentState.current[0]==0){possible[currentState.current[2]]=true;}
            for(int start=0; start<3; start++){
                for(int end=0; end<3; end++){
                    if(start==end)continue; 
                    State nextState = currentState.move(start, end, limit); 
                    if(nextState.current[0]>0&&nextState.current[1]>0&&nextState.current[2]>0)continue;
                    if(visit[nextState.current[0]][nextState.current[1]][nextState.current[2]])continue; 
                    visit[nextState.current[0]][nextState.current[1]][nextState.current[2]]=true; 
                    Q.add(nextState);
                }
            }
        }
    }

    static void process(){
        bfs(0,0,limit[2]);
        for(int water=0; water<limit[2]; water++){
            if(possible[water]==true){
                sb.append(water).append(" ");
            }
        }System.out.println(sb);
    }

    static void init(){
        for(int i=0; i<3;i++){
            limit[i]= sc.nextInt(); 
        }
    }
    public static void main(String[] args){
        init(); 
        process();
        
    }
    
}
