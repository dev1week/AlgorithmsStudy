import java.util.concurrent.PriorityBlockingQueue;

import java.io.*;
import java.util.*; 

public class BOJ13975 {
    static PriorityQueue<Integer> heap;
    static int T;
    static int N; 
    static StringBuilder sb = new StringBuilder(); 
    // sum = 60 

    // que  6 4

    // 3 3
    // 6 
    public static void main(String[] args) throws IOException{
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.valueOf(buffer.readLine());
        //T 입력 받기 
        for(int testCase=0; testCase<T; testCase++){
            heap = new PriorityQueue<>();
            int sum =0; 
            N = Integer.valueOf(buffer.readLine());
            StringTokenizer tokens = new StringTokenizer(buffer.readLine());
            //n입력 받기 
            for(int num=0; num<N; num++){
                heap.add(Integer.valueOf(tokens.nextToken())); 
            }

            while(!heap.isEmpty()){
                int tmp1= heap.poll();
                if(heap.size()<=1){continue;

                }
                int tmp2 = heap.poll(); 
                sum = sum + tmp1+ tmp2; 
                heap.add(tmp1+tmp2);
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }


}
