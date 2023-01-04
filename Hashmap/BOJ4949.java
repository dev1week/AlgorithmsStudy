import java.util.*; 
import java.io.*; 
public class BOJ4949 {
    static Map Marks = new HashMap();
    


    static void createClosedMarkSet(){
        Marks.put("}", "{");
        Marks.put("]", "[");
        Marks.put(")", "(");
    }

    static void logic(char[] args){
        Stack stack = new Stack(); 

        for(int i=0; i<args.length; i++){
            //열린거
            if(Marks.containsValue(String.valueOf(args[i]))){
                System.out.println("추가됨");
                stack.add(args[i]);
            }
            //닫힌거 
            else if(Marks.containsKey(String.valueOf(args[i]))){
                if(stack.isEmpty()){
                    System.out.println("닫힌괄호 + 스택 없음 no " + args[i-1]);
                    return; 
                }
                else{
                    String firstStack = String.valueOf(stack.peek());
                    String inputMark = String.valueOf(Marks.get(args[i]));
                    System.out.println(stack.peek()+" "+ Marks.get(String.valueOf(args[i])) +" "+args[i]);
                    System.out.println(stack.peek().equals(Marks.get(args[i])));
                    if(firstStack.equals(inputMark)){
                        stack.pop(); 
                    }
                    else{
                        System.out.println("쌍이 안맞음 no "+args[i-1]);
                        return;
                    }

                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("yes");
        }
        else{
            System.out.println("다돌고 스택없음 no");
        }
        return; 
        //전체 문자배열에 대해 
            //열린괄호일 경우 
                // 스택에 넣는다. 
            //닫힌괄호일 경우
                //스택에 값이 없다 
                    //no 출력 
                //else
                    // 상단 값 == 들어온 닫힌 괄호 
                        // 스택에서 뺀다 
                    // 상단값 != 들어온 닫힌 괄호 
                        // no 출력 
        //stack에 값이 남았는가?   
            //no 출력 
        //else
            // yes 출력
        
    }
    static boolean inputProcessing() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine(), ".");
        String inputString = String.valueOf(tokens.nextToken()); 
        if(inputString.equals(".")){
            return false;
        }
        else{
            char[]charArray = inputString.toCharArray();
            logic(charArray);
            return true; 
        }
        
        //입력 받기 
            //. 이 들어왔을 경우 -> false 반환
            //로직에 넣어주기 

    }
    public static void main(String[] args) throws IOException{
        createClosedMarkSet();
     
     

        boolean flag = true; 
        while(flag){
            flag= inputProcessing();
        }
 
    }
}
