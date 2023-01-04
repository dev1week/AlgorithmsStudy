import java.util.Scanner;

public class BOJ2577 {
    static int res =1; 
    static int[] freq = new int[10];


    static void init(){
        Scanner sc = new Scanner(System.in); 
        for(int i=0; i<3; i++){
            //System.out.println(sc.nextInt());
            res = res* sc.nextInt(); 
        }
    }
    static void judge(int data){
        String line= String.valueOf(data);
        for(int idx=0; idx<line.length(); idx++)
        {
            int freqIndex = Integer.valueOf(line.charAt(idx))-48;
            freq[freqIndex] +=1; 
        } 
    }
    static void print(int[] arr){
        for(int a : arr){
            System.out.println(a); 
        }
    }
    public static void main(String[] args){
        init();
        judge(res);
        print(freq); 
    }
}
