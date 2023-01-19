import java.io.*;
import java.util.*; 

public class BOJ11286 {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Integer> count = new HashMap<>(); //절대값, count; 
    static PriorityQueue<Integer> heap = new PriorityQueue<>();
    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(buffer.readLine());
        for(int i=0; i<N; i++){
            int data = Integer.parseInt(buffer.readLine());
            if(data==0){
                int min = heap.peek();
                sb.append(min+"\n");
                int c =count.get(min);
                if(c==1){
                    count.remove(min);
                }else if(c>1){
                    count.replace(min, c-1);
                }
            }else{
                if(data<0){data = data*(-1);}
                if(count.containsKey(data)){
                    count.replace(data, count.get(data)+1);
                }else{
                    count.put(data, 1);
                    heap.add(data);
                }
            }
        }
        //정수를 입력 받는다. 
        //0일 경우 
            //힙에서 가장 처음 값을 가져온다. 
            //해시가 가지고 있는지 확인한다 
                //카운트가 1일 경우 
                    //해시에서 삭제한다. 
                    //힙에서 삭제한다. 
                //카운트가 1보다 클 경우
                    //카운트를 1회 감소시킨다.  
        //0이 아닐경우
            //음수이면 
                //양수로 바꾼다.  
            //입력값이 해시맵에 있는지 확인한다 
                //있으면 카운트를 1회 늘려준다. 
                //없으면 해시맵에 1로 넣어준다. 
                    ////입력값를 힙에 넣어준다.
        

    }
    
}
