import java.io.*;
import java.util.*; 

public class BOJ1620 {
    static int num;
    static int numOfQ; 
    static String[] numToName; 
    static HashMap<String, Integer> nameToNum = new HashMap<>();
    static StringBuilder sb = new StringBuilder(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        num = Integer.valueOf(tokens.nextToken());
        numOfQ = Integer.valueOf(tokens.nextToken());
        numToName = new String[num+1];
        for(int idx=1; idx<=num; idx++){
            tokens = new StringTokenizer(buffer.readLine());
            String pokemon = tokens.nextToken(); 
            numToName[idx] = pokemon;
            nameToNum.put(pokemon, idx);
        }
        for(int idx=0; idx<numOfQ; idx++){
            String question = buffer.readLine(); 
            if('0'<=question.charAt(0)&&question.charAt(0)<='9'){
                Integer num = Integer.valueOf(question);
                sb.append(numToName[num]+"\n");
            }
            else{
                sb.append(nameToNum.get(question)+"\n");
            }

        }

        
    }

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(sb);
        //알파벳->숫자 
        //숫자 -> 알파벳 
    }
}
