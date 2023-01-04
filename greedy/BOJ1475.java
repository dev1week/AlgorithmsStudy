import java.util.Scanner;

public class BOJ1475 {
    static String line; 
    static int[] freq = new int[9]; 
    static void init(){
        Scanner sc = new Scanner(System.in); 
        line = sc.nextLine(); 
    }
    static void count(String line){
        for(int i =0; i<line.length();i++){
            int index = Integer.valueOf(line.charAt(i)-'0');
            if(index==6| index ==9){
                freq[6] +=1;
            }else freq[index]+=2;
            }
        }
    static int max(int[] arr){
        int max =0;
        for(int a: arr){
            if(a>max) max = a; 
        }
        int res = max/2;
        return res;
    }
    
    public static void main(String[] args){
        init(); 
        count(line);
        System.out.println(max(freq));
        //입력받아서 문자열 
        //문자열을 순회 
            //6이나 9일 경우 6과 9 모두 1씩 증가 
            //각 숫자의 인덱스에 맞게
        //배열을 돌면서 최대값을 추출 
    }
}
