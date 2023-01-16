import java.io.*;
import java.util.*; 


public class BOJ2480{
    static int numSame = 1;
    static int[] dices = new int[3]; 
    static int score=0;
    static int max = -100; 
    static int sameDice=0; 

    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        for(int i=0; i<3; i++){
            Integer dice = Integer.valueOf(tokens.nextToken()); 
            dices[i] = dice; 
            if(dice>max){
                max = dice; 
            }
        }
    }

    static void isSame(){
        for(int i=1; i<3; i++){
            if(dices[i]==dices[i-1]){
                numSame ++;
                sameDice = dices[i] ;
            }
        }
        // 1~2까지 순회 
            // [i] [i-1]이 같은지 확인 
                //같으면 num 값     
    }

    public static void main(String[] args) throws IOException{
        init();
        isSame();
        if(numSame==1){
            score = max*100; 
        }else if(numSame==2){
            score = 1000+100*sameDice;
        }else if(numSame==3){
            score = 10000+1000*sameDice;
        }
        System.out.println(score);
        //3개가 전부 같음 -> 10000+값*1000
        //2개가 같음 -> 1000+값x100 
        //모두 다른 눈이 나옴 -> 가장 큰 눈x100 
    }
}