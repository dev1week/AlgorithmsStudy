import java.io.*;
import java.util.*; 

public class BOJ10816_Hash {
    static StringBuilder sb = new StringBuilder(); 
    static int N; //500,000
    static int M; //500,000

    static HashMap<Integer, Integer> cards = new HashMap<>();
    static int[] querys;

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        N = Integer.valueOf(tokens.nextToken());
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<N; i++){
            int cardNum = Integer.valueOf(tokens.nextToken());
            if(cards.containsKey(cardNum)){
                cards.replace(cardNum, cards.get(cardNum)+1);
            }else{
                cards.put(cardNum, 1);
            }
        }
        tokens = new StringTokenizer(buffer.readLine());

        M = Integer.valueOf(tokens.nextToken());
        tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<M; i++){
            int q = Integer.valueOf(tokens.nextToken());
            
            if(cards.get(q)==null){
                sb.append(0+" ");
            }
            else{
                sb.append(cards.get(q)+" ");
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        init(); 
        System.out.println(sb);
    }
}
