import java.util.Scanner;

public class BOJ9663 {
    static int Size;

    static int res = 0;
    static boolean[] isPossibleCol;
    static boolean[] isPossibleDR;
    static boolean[] isPossibleDL;
    static void init(){
        Scanner sc = new Scanner(System.in);
        Size = sc.nextInt();

        isPossibleCol= new boolean[Size + 1];
        isPossibleDR = new boolean[2*Size];
        isPossibleDL = new boolean[2*Size];
    }
    static void print(String data){
        System.out.print(data);

    }
    static void bt(int curLow){
        if(curLow==Size){
                res++;
            return;
        }
        for(int can=0; can<Size; can++){
            if(isPossibleCol[can]||isPossibleDR[can+curLow]||isPossibleDL[curLow-can+Size-1])continue;
            isPossibleCol[can] = true;
            isPossibleDR[curLow+can] = true;
            isPossibleDL[curLow-can+Size-1] = true;
            bt(curLow+1);
            isPossibleCol[can] = false;
            isPossibleDR[curLow+can] = false;
            isPossibleDL[curLow-can+Size-1] = false;

        }

    }
    public static void main(String[] args){
        init();
        bt(0);
        System.out.println(res);
    }
}
