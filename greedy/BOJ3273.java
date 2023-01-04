import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int[] freq;
    static int[] arr;
    static int x; 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        int length = Integer.valueOf(tokens.nextToken());
        arr = new int[length];
        
        tokens = new StringTokenizer(buffer.readLine());
        for(int idx=0; idx<length; idx++){
            arr[idx] = Integer.valueOf(tokens.nextToken());
        }
        tokens = new StringTokenizer(buffer.readLine());
        x = Integer.valueOf(tokens.nextToken());
        freq = new int[x];
    }
    static int judge(){
        int count =0;
        for(int a: arr){
            if(x>a){
                if(freq[x-a]==1){
                    count+=1; 
                    freq[a]=1;
                }
                else{
                    freq[a]=1; 
                }
            }

        } 
        return count; 
    }
    public static void main(String[] args) throws IOException{
        init(); 
        System.out.println(judge());
    }
        //입력받기
        //freq 배열로 판정하기 
            //freq[x-data]가 있을 경우 
                //count1회 
            //freq[data]=true
    
}
