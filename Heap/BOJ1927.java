import java.io.*;
import java.util.*; 

public class BOJ1927{
    static PriorityQueue<Integer> heap = new PriorityQueue<>();
    static int N; 
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<N; i++){
            int data = Integer.valueOf(buffer.readLine());
            if(data == 0){
                if(heap.isEmpty()){sb.append(0+"\n");}
                else{
                    sb.append(heap.poll()+"\n");
                }
            }
            else{
                heap.add(data);
            }
        }
        System.out.println(sb);
        //입력이 자연수 -> 넣기 
        //입력이 0 ->작은 값 출력 후 제거 

    }
}