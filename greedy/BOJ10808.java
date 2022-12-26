import java.util.Scanner;

public class BOJ10808{
    public static int func2(int[] arr, int length){
        int[] freq= new int[100];
        //배열에 전부 접근 
            //freq[100-접근값]==1인지 확인 
                //있으면 1반환 
                //없으면 freq[접근값]=1
        for(int data : arr){
            if(freq[100-data]==1){
                return 1;
            }else freq[data] =1;
        }return 0; 
    }
    public static void main(String[] args){
        System.out.println(func2(new int[]{1,52,48},3));
        System.out.println(func2(new int[]{50, 42},2));
        System.out.println(func2(new int[]{4,13,63,87},4));
    }
}