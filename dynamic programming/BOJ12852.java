import java.util.*;

public class BOJ12852 {
    static int N; 

    static int[] D; 

    static int[] log; //log[i] = k // i가 된 후 k로 간다. 
     
    //D[i] = i를 1로 만드는 연산 최소 횟수 
    //D[1] = 0;
    //D[2] = 1;
    //D[3] = 1;
    //D[4] = 2; 4->2->1
    //D[i] = Math.min(D[i-1], D[i/2], D[i/3])+1

    //n을 1로 만드는 방법 최소 연산횟수
    //n을 1로 만드는 방법 로그찍기

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 

        D = new int[1000005];
        log = new int[1000005];
    }

    static void DP(){
        D[1] =0;
        D[2] =1;
        D[3] =1;
        log[0] =1;
        log[1] =1; 
        log[2] = 1;
        log[3] =1; 
        for(int i=4; i<=N; i++){
            D[i] = D[i-1]+1; 
            log[i] = i-1; 
            if(i%2==0 && D[i]>D[i/2]){
                D[i] = D[i/2]+1; 
                log[i] = i/2;
            }
            if(i%3==0 && D[i]>D[i/3]){
                D[i] =  D[i/3]+1; 
                log[i] = i/3; 
            }
        }sb.append(D[N]).append("\n");
    }

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        init();
        DP(); 
        int idx = N; 
        sb.append(N+" ");
        while(true){
            
            if(idx==1){
                break; 
            }
            sb.append(log[idx]+" ");
            idx = log[idx];
            
        }
        System.out.println(sb);
    }
}
