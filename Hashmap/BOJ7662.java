import java.io.*;
import java.util.*; 

public class BOJ7662 {
    //T개의 테스트 데이터 
    static int T;
    //k개의 연산 
    static int k; 
    //TreeMap<Key, Count>
    //TreeSet<Pair<Key, Index>>
    
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[]args) throws IOException{
        //이중 우선순위 큐 -> 정수만 저장 

        /// 삽입연산, 중복해서 넣는 것을 허용함 
        //삭제 연산 
            //우선순위가 가장 높은 것을 삭제 -> 최대값 삭제
            //우선순위가 가장 낮은 것을 삭제 -> 최솟값 삭제 
            //중복된 값이 있을 경우 하나만 삭제된다. 

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
        T = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<T; i++){
            TreeMap<Integer, Integer> que = new TreeMap<>();
            k = Integer.valueOf(buffer.readLine());
            for(int j =0; j<k; j++){
                tokens = new StringTokenizer(buffer.readLine()); 
                String operator = tokens.nextToken();
                int value = Integer.valueOf(tokens.nextToken()); 
                if(operator.equals("D")){
                    if(que.isEmpty()){continue;}
                    if(value ==1){
                        int maxKey = que.lastKey();
                        int count = que.get(maxKey);
                        //sb.append("이전 : " +count).append("\n");
                        count-=1; 
                        que.put(maxKey, count);
                        //sb.append("이후 : "+count).append("\n");
                        //sb.append(maxKey+" 1회 삭감 "+ count).append("\n");
                        if(count==0){
                            que.remove(maxKey);
                            //sb.append(maxKey+" 삭제됨").append("\n");
                        }
                    }
                    else if(value==-1){
                        int minKey = que.firstKey();
                        int count = que.get(minKey);
                        //sb.append("이전 : " +count).append("\n");
                        count-=1; 
                        que.put(minKey, count);
                        //sb.append("이후 : "+count).append("\n");
                        //sb.append(minKey+" 1회 삭감 "+count).append("\n");
                        if(count==0){
                            que.remove(minKey);
                           //sb.append(minKey+" 삭제됨").append("\n");
                        }
                    }
                }else if (operator.equals("I")){

                    //삽입 로직 구현 
                    // 중복 값인지 확인 
                        //중복값이면 count값 증가시켜서 저장함 
                        //없으면 count=1로 저장함 
                    if(que.containsKey(value)){
                        int count = que.get(value);
                        count+=1;
                        que.put(value, count);
                        //sb.append(value+" 1회 증가 "+count).append("\n");
                    }
                    else{
                        que.put(value, 1);
                        //sb.append(value+" 처음 삽입").append("\n");
                    }

                }
            }
            if(que.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(que.lastKey()+" "+ que.firstKey()).append("\n");
            }
            
        }
        
        //T회 반복 
            //k번 반복 -> 입력받기 
        System.out.println(sb);        
    }
    
}
