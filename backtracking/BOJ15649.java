import java.util.Scanner;

public class BOJ15649 {
    static int N;
    static int M; 
    static int[] res;
    static boolean[] issued;
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); 
        res = new int[M];
        issued = new boolean[N+1];
    }
    static void print(String data){
        System.out.print(data);

    }
    static void bt(int k){
        if(k==M){
            for(int re : res){
                print(re+" ");
            }print("\n");
            return; 
        }
        for(int i=1; i<=N; i++){
            if(!issued[i]){
                res[k]=i;
                issued[i] = true; 
                bt(k+1);
                issued[i]= false; 
            }
        }

    }
    public static void main(String[] args){
        init();
        bt(0);
    }
    
}
