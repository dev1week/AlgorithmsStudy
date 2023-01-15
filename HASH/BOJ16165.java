import java.io.*;
import java.util.*; 

public class BOJ16165 {
    //100 걸그룹의 수 
    static int N; 
    //100 문제의 수 
    static int M; 

    static HashMap<String, String> mtoG = new HashMap<>();
    static HashMap<String, Integer> gtoI = new HashMap<>(); 
    static TreeSet<String>[] list; 

    static StringBuilder sb = new StringBuilder(); 

    //멤버이름 -> 팀이름 //해시맵으로 처리 
    //
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        M = Integer.valueOf(tokens.nextToken());
        list = new TreeSet[N];

        for(int i=0; i<N; i++){
            list[i] = new TreeSet<>();
        }

        for(int i=0; i<N; i++){
            String group = buffer.readLine(); 
            gtoI.put(group,i);
            int numOfMember = Integer.valueOf(buffer.readLine());
            for(int m=0; m<numOfMember; m++){
                String name = buffer.readLine(); 
                list[i].add(name);
                mtoG.put(name, group);
            }
            //걸그룹 명수 입력받기 
            //명수만큼 반복 
                //멤버 이름 입력 받기 (소문자)
                //증복된 이름은 주어지지 않음 
        }

        for(int i=0; i<M; i++){
            String name = buffer.readLine();
            int query = Integer.valueOf(buffer.readLine());

            judge(name, query);
        }
    }

    static String judge(String name, int query){
        if(query==0){
            int idx = gtoI.get(name);
            for(String data : list[idx]){
                sb.append(data).append("\n");
            }
        }
        else if(query ==1){
            sb.append(mtoG.get(name)).append("\n");
        }
        // 0일 경우 
            //팀의 이름으로 멤버이름 전부 출력 
            //
        // 1일 경우 
            //멤버의 이름으로  팀 이름 출력
            //해시맵에서 찾기  
        return "d";

    }
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(sb);
    }
}
