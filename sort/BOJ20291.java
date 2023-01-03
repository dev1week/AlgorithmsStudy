import java.util.*;
import java.util.Map.Entry;
import java.io.*; 

public class BOJ20291 {
    static int N ; 
    static Map<String, Integer> extenstions = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();
    static void listAdd(String ext){
        if(extenstions.containsKey(ext)){
            int count = extenstions.get(ext);
            extenstions.replace(ext,count+1);
        }else{
            extenstions.put(ext, 1);
        }
    }
    static void init() throws NumberFormatException, IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        
        for(int i=0; i<N;i++){
            tokens = new StringTokenizer(buffer.readLine(), ".");
            String extention = String.valueOf(tokens.nextToken());
            extention = tokens.nextToken();
            listAdd(extention);
            //트리 맵에 존재 한다면 
                //카운트를 1회 올려준다.
            //없다면 
                //add(확장자, 1)
        }
        
    }
    static void printMap(){
        for(Entry<String, Integer> entry : extenstions.entrySet()){
            sb.append(entry.getKey()+" "+ entry.getValue()+"\n");
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        init(); 
        printMap(); 
        System.out.print(sb);
    }
    
}
