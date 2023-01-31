import java.util.*;
import java.util.Map.Entry;
import java.io.*; 

public class BOJ9375 {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 
    static int T; // testcase 
    static int N; // ~30 의상수 
    //같은 종류의 의상은 하나만 입을 수 있음 
    //(종류1 내 개수)*(종류2 내 개수)-1
    static StringBuilder sb = new StringBuilder(); 
    //이름, 종류를 입력으로 받음 
    //같은 종류의 의상은 하나만 
    static void process(){
        int result =1; 
        for(Integer value : closet.values()){
            result *=(value+1); 
        }
        sb.append(result-1+"\n");
    }

    static HashMap<String, Integer> closet;
    static void init() throws NumberFormatException, IOException{
        closet = new HashMap<>(); 
        N = Integer.valueOf(buffer.readLine());
        for(int i=0; i< N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String dummy = tokens.nextToken();
            String name = tokens.nextToken(); 

            if(closet.containsKey(name)){
                closet.replace(name, closet.get(name)+1);
            }else{
                closet.put(name, 1);
            }
            

        }
        //종류, 개수를 넣는다. 
        // 종류가 list 없을 경우 
            // 종류, 1을 넣어준다. 
        // 종류가 list에 있을 경우 
            // 종류, 원래값 +=1 로 바꿔준다. 
    }

    public static void main(String[] args) throws NumberFormatException, IOException{
        T = Integer.valueOf(buffer.readLine());
        for(int t=0; t<T; t++){
            init(); 
            process();
        }
        System.out.println(sb);
    }
}
