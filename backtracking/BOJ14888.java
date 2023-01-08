import java.io.*;
import java.util.*; 

public class BOJ14888 {
    static int[] operations = new int[5];
    static int[] nums;
    static int[] orders;
    static int N;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(buffer.readLine());
        nums = new int[N+1];
        orders= new int[N+1];
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        for(int i=1; i<=N; i++){
            nums[i] = Integer.valueOf(tokens.nextToken());
        }
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=1; i<=4; i++){
            operations[i] = Integer.valueOf(tokens.nextToken());
        }

    }

    static void pinrtArr(int[] arr){
        sb.append("\n");
        for(int a : arr){
            sb.append(a+" ");
        }sb.append("\n");
    }
    static int calculator(){
        int value = nums[1];
        for(int i=1; i<=N-1; i++){
            if(orders[i]==1){
                value += nums[i+1];
            }
            else if(orders[i]==2){
                value -= nums[i+1];
            }
            else if(orders[i]==3){
                value *= nums[i+1];
            }
            else if(orders[i]==4){
                value /= nums[i+1];
            }
        }
        return value;
    }

    static void BT(int M){
        //order 1~n-1에 연산자들이 순서대로 저장 
        if(M==N){
            int tmp = calculator();
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }else{
            //4가지 연산자 중 무엇을 쓸건지 재귀호출 
            for(int idx=1; idx<=4; idx++){
                if(operations[idx]==0){continue;}
                operations[idx]-=1; 
                orders[M] = idx; 
                BT(M+1);
                operations[idx]+=1; 
                orders[M] = 0; 
            }
        }

    }
    public static void main(String[] args) throws IOException{
        init();
        BT(1);
        sb.append(max+" "+min);
        System.out.println(sb);
        //최대 11개의 수 
        //최대 10개의 연산자
        // 숫자 사이에 연산자를 어떻게 배열할 것인가? (중복 혀용)

    }
    
}
