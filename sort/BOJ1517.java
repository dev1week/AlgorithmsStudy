import java.util.Arrays;
import java.util.Scanner;

public class BOJ1517 {
    static int n; 
    static int[] a;
    static int[] p;
    static int[] b; 
    static boolean[] isUsed; 
    static Scanner sc = new Scanner(System.in);
    
    static void init(){
        n = sc.nextInt();
        a= new int[n];
        p = new int[n];
        b = new int[n];
        isUsed = new boolean[n];
        
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt(); 
        }
        for(int i=0; i<n; i++){
            a[i] =b[i];
        }
        for(int i=0; i<n; i++){
            p[i] =-1;
        }
        
    }

    static void printArr(int[] arr){
        for(int a: arr){
            System.out.print(a+" ");
        }System.out.println();
    }
    public static void main(String[] args){
        init();
        Arrays.sort(b);
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(b[y]!=a[x])continue; 
                if(p[x]!=-1)continue;
                if(isUsed[y])continue;
                isUsed[y]=true; 
                p[x] = y;  
            }
        }
        //a를 정렬하여 b에
        //a를 순회 x
            //b를 전부 순회하며 같은 값을 찾는다. y
            //같은 값을 찾았으면 해당 인덱스를 p[x] = b[y]
        printArr(a);
        printArr(b);
        printArr(p);
    }
    
}
