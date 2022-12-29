import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int N;
    static int M; 
    static int[] inputNums;
    static boolean[] isUsed; 
    static int[] resultNums; 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());

        inputNums = new int[N];
        resultNums = new int[M];
        isUsed = new boolean[N];
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            inputNums[i] = Integer.valueOf(tokens.nextToken());
        }
    }
    static void printArr(int[] arr){
        for(int ar: arr){
            print(ar+" ");
        }print("\n");
    }

    static void print(String data){
        System.out.print(data);
    }
    static void BT(int cur){
        if(cur==M){
            printArr(resultNums);
        }
        else{
            for(int index=0; index<N; index++){
                if(isUsed[index])continue; 
                isUsed[index]=true; 
                resultNums[cur] = inputNums[index];
                BT(cur+1);
                isUsed[index]=false; 
            }
        }
    }
    public static void main(String[] args) throws IOException{
        init(); 
        Arrays.sort(inputNums);
        BT(0);
        //입력받기 
        //정렬해놓기 
        //백트래킹
            //베이스 컨디션 -> 정답 배열 출력하기 
            //아닐 경우 
                //정렬해 놓은 입력 배열 인덱스 순회 
                    //해당 인덱스 사용했다면 -> 컨티뉴 
                    //아닐경우 
                        //사용인덱스 표시
                        //정답배열[cur] = 입력배열[인덱스]
                        // 백트래킹 
                        //사용인덱스 표시해제 
    }
}
