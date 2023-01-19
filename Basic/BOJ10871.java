import java.io.*;
import java.util.*; 

public class BOJ10871 {
   

     
    static StringBuilder sb = new StringBuilder();
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 


    public static void main(String[] args) throws IOException{
        for(int i=0; i<3; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int count =0; 
            for(int j=0; j<4; j++){
                int data = Integer.valueOf(tokens.nextToken());
                if(data==0){
                    count++; 
                }
            }
            if(count==0){
                sb.append("E\n");
            }else if(count==1){
                sb.append("A\n");
            }else if(count==2){
                sb.append("B\n");
            }else if(count==3){
                sb.append("C\n");
            }else if(count==4){
                sb.append("D\n");
            }
        }
        System.out.println(sb);
        
   

    }
    
}
