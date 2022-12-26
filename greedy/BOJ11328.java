import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11328 {
    static String data1; 
    static String data2; 
    static boolean[] occur;

    static void init(BufferedReader buffer) throws IOException{
        
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        data1 = tokens.nextToken();
        data2 = tokens.nextToken(); 
        
    }
    static void isStrfry(String data1, String data2){
        occur = new boolean[100000];
        for(int i=0; i<data1.length(); i++){
            occur[Integer.valueOf(data1.charAt(i)-'a')] = true; 
        }
        for(int i=0; i<data2.length(); i++){
            if(!occur[Integer.valueOf(data2.charAt(i)-'a')]){
                System.out.println("Impossible");
                return; 
            }
        }System.out.println("Possible");
        return; 
        //data1 순회 
            //occur[아스키코드]=true 
        //data2 순회 
            // occur[아스키코드] == ture 
                //print 임파서블 
        //프린트 파서블 
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in); 
        int num = sc.nextInt(); 
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
        for(int i=0; i<num; i ++){
            init(buffer); 
            isStrfry(data1, data2);
        }


    }
}
