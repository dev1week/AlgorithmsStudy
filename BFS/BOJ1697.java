import java.io.*;
import java.util.*; 
public class BOJ1697 {
    static int S;
    static int D;
    static int[] distance= new int[100001];
    static int min = 10000000; 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        S=Integer.valueOf(tokens.nextToken());
        D=Integer.valueOf(tokens.nextToken());
        Arrays.fill(distance,-1);
    }
    static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(S);
        while(!que.isEmpty()){
            int cur = que.poll(); 
            int[] dirs = {cur+1, cur-1, cur*2};
            //distance[cur]=0;
            for(int dir : dirs){
                System.out.print(dir +" ");
            }System.out.print("\n");
            for(int next: dirs){
                
                if(next<0||next>100000)continue;
                if(distance[next]>-1)continue; 
                System.out.println(next);
                distance[next] = distance[cur]+1; 
                que.add(next);
                if(next==D){System.out.println(distance[next]+1); return;}
            }

        }

        //s를 큐에 넣기 
        //큐가 다 빌때까지 
            //for( s+1, s-1, 2*s)
                //next 계산 
                //방문안함
                //distance[next] = distance[cur]+1;  
                //최소에 있는 숫자보다 작음||n==s
                    //최소에 넣어준다. 
    }
    public static void main(String[] args) throws IOException{
        init();
        if(S==D){
            System.out.println(0);
        }
        else BFS();
        //입력받기
        //bfs 모든 경우의 수 탐색 
        
    }    
}
