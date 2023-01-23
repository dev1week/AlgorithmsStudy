import java.io.*;
import java.util.*; 

public class BOJ9375 {
    static int T; // 100 
    static int N; // 의상 갯수 
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static HashMap<String, Integer> closet; 
    //옷종류, 가지고 있는 갯수
    //같은 이름의 의상은 존재하지 않는다. 

    static void init() throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String data1 = tokens.nextToken();
            String data2 = tokens.nextToken(); 
            if(closet.containsKey(data2)){
                closet.replace(data2, closet.get(data2)+1);
            }else{//처음 들어가는 경우 
                closet.put(data2, 1);
            }
        }
        int result =process();
        System.out.println(result);
    }

    static int process(){
        int result =1; 
        for(String colthe: closet.keySet()){
            //옷을 입지 않은 경우도 포함 
            result = result*(closet.get(colthe)+1);
        }
        //모두 안뽑는 경우의 수 
        return result-1;

    }

    public static void main(String[] args) throws IOException{
        T=Integer.valueOf(buffer.readLine());
        for(int testCase=0; testCase<T; testCase++){
            closet = new HashMap<>(); 
            init(); 
        }
    }
}
