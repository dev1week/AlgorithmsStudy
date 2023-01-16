import java.util.*;
import java.io.*; 


public class BOJ21939 {
    static int Q; 
    static StringBuilder sb = new StringBuilder(); 
    static TreeSet<Integer> levels = new TreeSet<>();
    static TreeSet<Integer>[] questions = new TreeSet[101];
    
    static HashMap<Integer, Integer> qTol= new HashMap<>(); //<문제번호, 난이도>


    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens; 

    static void init() throws IOException{
        tokens = new StringTokenizer(buffer.readLine());
        Q = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<101; i++){
            questions[i] = new TreeSet<>();
        }
        for(int i=0; i<Q; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int numQ = Integer.valueOf(tokens.nextToken());
            int level = Integer.valueOf(tokens.nextToken());
            // 문제번호 입력 2
            save(numQ, level);
        }
    }

    static void process() throws NumberFormatException, IOException{
        int commandNum = Integer.valueOf(buffer.readLine());
        for(int i=0; i<commandNum; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String command = tokens.nextToken(); 
            if(command.equals("add")){
                int question = Integer.valueOf(tokens.nextToken());
                int level = Integer.valueOf(tokens.nextToken());
                save(question, level);
            }else if(command.equals("recommend")){
                int level = Integer.valueOf(tokens.nextToken());
                recommend(level);
            }else if(command.equals("solved")){
                int question = Integer.valueOf(tokens.nextToken());
                solved(question);
            }
        }
        
    }

    static void save(int question, int level){
        questions[level].add(question);
        levels.add(level); 
        //문제 번호, 난이도 저장 
        //이미 있었으면 값을 갱신한다. 
        if(qTol.containsKey(question)){
            int lastL = qTol.get(question);
            qTol.replace(question, level);
            levels.remove(lastL);
            questions[lastL].remove(question);
        }
        else{
            qTol.put(question, level);

        }
    }
    static void solved(int question){
        int level = qTol.get(question);
        qTol.remove(question);
        questions[level].remove(question);
        levels.remove(level);
        // 난이도 가져온다 
        //qTol에서 삭제한다.
        // 난이도를 이용하여 문제 리스트에 접근한다 
        //문제리스트에서 문제를 삭제한다. 
    }


    static void recommend(int opt){
        if(opt==1){
            int hardL = levels.last();
            int numQ = questions[hardL].last();
            sb.append(numQ).append("\n");
        }
        else if(opt==-1){
            int easyL = levels.first(); 
            int numQ = questions[easyL].first(); 
            sb.append(numQ).append("\n");
        }
    }
    

    public static void main(String[] args) throws NumberFormatException, IOException{
        init();
        process();
        System.out.println(sb);
    }
    //명령어 종류 3가지 
    //recommend
        //1인 경우 
            //가장 어려운 문제 (난이도가 가장 큰 수)의 번호 출력 
            //여러개일 경우 문제 번호가 가장 큰 것으로 
        //-1인 경우 
            //가장 쉬운 문제 (난이도가 가장 작은 수)의 번호 출력 
            //여러개일 경우 문제 번호가 가장 낮은 것으로 
    //add P L 
        //난이도가 L인 문제번호 P 추가 
    //solved P 
        //추천 문제 리스트에서 문제번호 P 제거 


}
