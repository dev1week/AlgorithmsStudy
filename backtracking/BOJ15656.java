import java.io.*;
import java.util.*; 

public class BOJ15656 {
    static int N;
    static int M; 
    static int[] inputNums;
    static int[] resultNums;
    static StringBuilder sb = new StringBuilder(); 
    //입력받는 함수 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        
        inputNums = new int[N];
        resultNums = new int[M]; 
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            inputNums[i] = Integer.valueOf(tokens.nextToken());
        }
    }
    static void print(String data){
        sb.append(data);
    }
    static void printArr(int[] arr){
        for(int a: arr){
            print(a+" ");
        }print("\n");
    }
    static void BT(int cur){
        if(cur==M){
            printArr(resultNums);
        }
        else{
            for(int index=0; index<N; index++){
                resultNums[cur] = inputNums[index]; 
                BT(cur+1); 
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //입력받기
        init(); 
        System.out.print("\n"); 
        //입력 배열 정렬하기
        Arrays.sort(inputNums); 
        
        BT(0); 
        System.out.print(sb); 
        //백트래킹(int 자릿수) 
            //베이스 컨디션 -> 결과 출력 
            //else
                //인덱스 < N 순회 
                    //결과[현재자릿수] = Input[index]
                
    }
}
