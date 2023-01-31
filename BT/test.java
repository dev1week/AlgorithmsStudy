import java.io.*;
import java.util.*; 

public class test {
    static int N; // 숫자의 개수 2~11 
    static int[] numbers;
    static int[] operations = new int[4]; //+, -, X, / 
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        N = Integer.valueOf(tokens.nextToken());
        tokens = new StringTokenizer(buffer.readLine());
        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.valueOf(tokens.nextToken());
        }
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<4; i++){
            operations[i] = Integer.valueOf(tokens.nextToken());
        }
        

    }

    static void BT(int k, int result){
        if(k==N-1){
            if(max<result){
                max = result;
            }
            if(min>result ){
                min =result;
            }
            return;
        }else{
            for(int i=0; i<4; i++){
                if(operations[i]==0){continue;}
                operations[i]-=1;
                if(i==0){
                    BT(k+1, result+numbers[k+1]);
                }else if(i==1){
                    BT(k+1, result-numbers[k+1]);
                }else if(i==2){
                    BT(k+1, result*numbers[k+1]);
                }else if(i==3){
                    BT(k+1, result/numbers[k+1]);
                }
                operations[i]+=1; 
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        BT(0, numbers[0]);
        
        System.out.println(max);
        System.out.println(min);
        
    }
}

