import java.io.*;
import java.util.*; 


public class BOJ11478 {
    static String S;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> result = new HashSet<>(); 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        S = buffer.readLine(); 

    }

    public static void main(String[] args) throws IOException{
        init(); 
        int Size = S.length(); 
        for(int i=0; i<Size; i++){
            String tmp = "";
            for(int j=i; j<Size; j++){
                sb.append(i+","+j+"\n");
                tmp += S.charAt(j);
                sb.append(tmp+"\n");
                result.add(tmp);
            }
            sb.append(tmp +"\n");
            result.add(tmp);
        }
        System.out.println(result.size());
    }
    
}
