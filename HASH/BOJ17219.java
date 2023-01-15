import java.io.*;
import java.util.*; 

public class BOJ17219{
    static StringBuilder sb = new StringBuilder();

    //100,000
    static int numOfSite; 
    //100,000
    static int numOfQ; 
    static HashMap<String, String> list = new HashMap<>(); 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 

        numOfSite = Integer.valueOf(tokens.nextToken());
        numOfQ =  Integer.valueOf(tokens.nextToken());

        for(int i=0; i<numOfSite; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String site = tokens.nextToken();
            String pw = tokens.nextToken(); 

            list.put(site, pw);

        }
        for(int i=0; i<numOfQ; i++){
            String site = buffer.readLine();
            sb.append(list.get(site)+"\n");
        }

        //사이트는 중복되지 않음 
        //사이트는 알파벳 대소문자 대시 마침표 
        //비밀번호는 알파벳 대문자로 
        // 각 길이는 최디 20자 

        //

    }
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(sb);
    }
}