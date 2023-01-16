import java.io.*;
import java.util.*;  


public class BOJ2075 {
    static PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());    
    static int N; 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            for(int j =0; j<N; j++){
                Integer data = Integer.valueOf(tokens.nextToken());
                heap.add(data);
            }
        }
        for(int i=0; i<N-1; i++){
            heap.poll();
        }
        sb.append(heap.poll());
        System.out.println(sb);

    }
    //전체 순회 돌면서 큐애 넣기
    //n-1회 돌면서 힙 상단값 빼버리기 
    //마지막 값 출략
    
}
