import java.util.*; 
import java.io.*; 

public class BOJ9375 {
    //100
    static int T; 
    //의상 개수 최대 30개 
    static int N; 

    static HashMap<String, String> list = new HashMap<>(); 
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        // 의상의 이름과 종류가 공백으로 구분되어 주어짐 
        // 같은 종류의 의상은 하나만 
        //H -> 모자, 터번
        //E -> 선글라스 
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String value = tokens.nextToken();
            String key = tokens.nextToken(); 
            list.put(key, value); 
        }

        Set set = list.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(sb);
    }
}
