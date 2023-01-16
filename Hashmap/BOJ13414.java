import java.io.*;
import java.util.*; 

public class BOJ13414 {
    static int enableNum;// 100,000
    static int listNum; //500,000
    static StringBuilder sb = new StringBuilder(); 
    static LinkedHashSet<String> que = new LinkedHashSet<>();

    //자료구조에 입력을 받는다. 
    //중복일 경우 삭제한다. 
    //맨앞에서 정해진 숫자만큼만 출력한다. 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        enableNum = Integer.valueOf(tokens.nextToken());
        listNum = Integer.valueOf(tokens.nextToken());
        for(int num=0; num<listNum; num++){
            String code = buffer.readLine();
            if(que.contains(code)){
                que.remove(code);
                que.add(code);
            }else{
                que.add(code);
            }
        }
    }

    static void print(){
        Iterator<String> it = que.iterator();
        for(int i=0; i< enableNum; i++){
            sb.append(it.next()+"\n");
        }
    }
    
    public static void main(String[] args) throws IOException{
        init(); 
        print();
        System.out.println(sb);
        //입력받기 

        //출력하기 
        
    }
}
