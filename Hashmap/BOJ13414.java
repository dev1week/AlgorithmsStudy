import java.io.*;
import java.util.*; 

public class BOJ13414 {
    static HashMap<String, Integer> enroll = new HashMap<>();
    static StringBuilder sb = new StringBuilder(); 
    static int enableNum;
    static int logNum; 
    static LinkedList<Map.Entry<String, Integer>> sortedList;
    

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        enableNum = Integer.valueOf(tokens.nextToken());
        logNum = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<logNum; i++){
            String data = buffer.readLine(); 
            if(enroll.containsKey(data)){
                enroll.replace(data, i);
            }
            else{
                enroll.put(data, i);
            }
        }
        sortedList = new LinkedList<>(enroll.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());
    }
    public static void main(String[] args) throws IOException{
        init(); 
        Iterator it = sortedList.iterator();

        if(enableNum >= sortedList.size() ){
            enableNum = sortedList.size(); 
        }

        for(int i=0; i<enableNum; i++){
            StringTokenizer result = new StringTokenizer(it.next().toString());
            sb.append(result.nextToken("=")+"\n");
        }
        System.out.println(sb);
    }

}
