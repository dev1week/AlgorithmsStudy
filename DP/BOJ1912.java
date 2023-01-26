import java.io.*;
import java.util.*; 

public class BOJ1912 {
    static int[] numbers;
    static int Size; 
    static StringBuilder sb = new StringBuilder();
    static int[] D;

    //D[i] = i번째 수를 더할 때 최대값 
    //D[1] = numbers[1];
    //D[2] = Max(D[i-1] + numbers[2], numbers[2]) 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        Size = Integer.valueOf(tokens.nextToken());

        numbers = new int[Size+1];
        D = new int[Size+1];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=1; i<=Size; i++){
            numbers[i] =Integer.valueOf(tokens.nextToken());
        }
        D[1] = numbers[1];
        for(int i=2; i<=Size; i++){
            D[i] = Math.max(numbers[i], D[i-1]+numbers[i]);
        }
        //D[i] i번째에서의 최대값 Math.max(D[i-1], D[i-1]+numbers[i])

    }
    public static void main(String[] args) throws IOException{
        int max = Integer.MIN_VALUE;
        init();
        for(int i=1; i<=Size; i++){
            if(D[i]>max){
                max = D[i];
            }
        }
        System.out.println(max);
    }
}
