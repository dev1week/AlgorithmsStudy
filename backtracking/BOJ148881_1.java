import java.io.*; 
import java.util.*; 

public class BOJ148881_1 {
    static int[] operations = new int[5]; 
    static int[] nums;
    static int[] orders;
    static int N; 
    static StringBuilder sb = new StringBuilder(); 
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    //계산 로그를 남겨 N==M 달성 후 다시 돌아나올 때 value값을 초기화할 수 있게 함 
    static int tmp[];

    static void BT(int M, int value){
        if(M==N){
            min = Math.min(min, value);
            max = Math.max(max, value);
            
            //정렬된 상태를 찾음 
            //최종 밸류 값 계산하여 반환하기 

        }
        else{
            for(int next =1; next<=4; next++){
                if(operations[next]==0){continue;} // 해당 연산자는 쓸 수 없는 상태 -> 스킵
                operations[next]--; // 남은 연산자 사용가능횟수 차감 
                orders[M] = next; //m번째 연산자 값 남기기 
                //계산 로직 
                if(next ==1){
                    value += nums[M+1];
                }else if(next ==2){
                    value -= nums[M+1];
                }
                else if(next ==3){
                    value *= nums[M+1];
                }else if(next ==4){
                    value /= nums[M+1];
                }
                tmp[M]=value;
                BT(M+1, value);
                operations[next]++; 
                orders[M]=0; 
                value = tmp[M-1];
            }
        }
    }

    //연산자 덧셈, 뺄셈, 곱셈, 나눗셈 
    //각 정수는 1에서 100사이 
    //중복 있게 연산자의 순서만 정해주면 된다. 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(buffer.readLine());
        nums = new int[N+1];
        orders = new int[N+1]; 
        tmp = new int[N+1];

        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        for(int i=1; i<=N; i++){
            nums[i] = Integer.valueOf(tokens.nextToken());
        }
        tokens = new StringTokenizer(buffer.readLine());

        for(int i=1; i<=4; i++){
            operations[i] =Integer.valueOf(tokens.nextToken());
        }
    }

    static void printArr(int[] arr){
        sb.append("\n");
        for(int a: arr){
            sb.append(a+" ");
        }sb.append("\n");
    }

    public static void main(String[] args) throws IOException{
        init();
        tmp[0] = nums[1];
        BT(1, nums[1]);
        sb.append(max +"\n"+min+"\n");
        System.out.println(sb);

    }

}
