import java.util.*; 

public class BOJ15991 {
    static long[] D = new long[100001]; 
    static void initDP(){
        D[1] = 1;
        D[2] = 2;
        D[3] = 2;
        D[4] = 3; 
        D[5] = 3; 

        for(int i=6; i<100001; i++){
            D[i] = (D[i-2]+D[i-4]+D[i-6])%1000000009;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        initDP();
        for(int i=0; i<T; i++){
            System.out.println(D[sc.nextInt()]);
        }
    }    
}
