import java.io.*;
import java.util.*; 
public class BOJ11652 {
    static long[] cards;
    static int N; 
    static int currentCount=1; 
    static long maxCard; ;
    static int maxCount=1;
    static Scanner sc = new Scanner(System.in);
    
    static void init(){
        N = sc.nextInt();
        cards=new long[N];
        for(int i=0; i<N; i++){
            cards[i] = sc.nextLong();
        }
    
    } 
    static void print(long[] cards2){
        for(long a: cards2){
            System.out.print(a +" ");
        }System.out.println(); 

    }
    static void process(){
        for(int idx=1; idx<N; idx++){
            if(cards[idx-1]==cards[idx]){
                currentCount++; 
                //-1 0 0 반례 해결을 위해 추후에 리팩토링하기
                if(maxCount<currentCount){
                    maxCard = cards[idx-1];
                    maxCount= currentCount;
                }
            }
            else{
                //-1 0 0 반례 해결을 위해 
                if(maxCount<currentCount){
                    maxCard = cards[idx-1];
                    maxCount= currentCount;
                }currentCount=1; 
            }
        }
    }
    public static void main(String[] args){
        init();
        Arrays.sort(cards);
        maxCard= cards[0];
        if(cards.length<2){
            System.out.println(maxCard);
        }
        else{
            
            process();
            System.out.println(maxCard);
        }
        
        
        

        //수열을 입력으로 받는다. 
        //수열을 정렬한다. 
        //수열을 순회한다. 1~마지막
            //전값과 비교해서 같으면 
                //-> 카운트 1회 증가 
            // 다르면 
                //-> 최빈 카운트<현재 카운트
                    // 최빈 카운트 = 현재 카운트 
                    //최빈값 = 현재 값 

    }
}
