import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300 {
    static int[] room= new int[13]; 
    static int maxPeople;
    //인덱스 = 성별 코드 * 6 + 학년 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        int peopleNum = Integer.valueOf(tokens.nextToken());
        maxPeople = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<peopleNum; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int gender = Integer.valueOf(tokens.nextToken());
            int grade = Integer.valueOf(tokens.nextToken());
            int index = gender*6+grade;
            room[index]+=1; 
        }
    }
    static void printMap(){
        for(int a : room){
            System.out.print(a+" ");
        }
    }
    static int judge(){
        int count=0; 
        for(int p : room){
            if(p>maxPeople){
                double value = (double) p/maxPeople;
                count+=(Math.ceil(value));
                
            } 
            else if(p>=1){count++;}
        }
        return count; 
    }
    public static void main(String[] args) throws IOException{
        init(); 
        System.out.println(judge());
        // int test = 3/2;
        // System.out.print(test);
        //입력받기 
        //받을 때 마다 인덱스 계산하여 room ++로 바꿔주기 
        //room 돌면서 요소 가져오기 
            //요소 > 최대 인원수 
                // count+=요소//최대인원수+1; 
            //요소 <= 최대 인원수 
                // count+=1; 
    }
    
}
