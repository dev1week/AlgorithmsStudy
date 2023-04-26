import java.util.*;
public class BOJ1759 {

    static int L;
    static int C; 

    static char[] elements ;

    static ArrayList<Integer> selecteds = new ArrayList<>(); 


    static void bt(int cur, int last){
        if(cur==L+1){
            //aeiou 1개 이상 있는지 검사 
            //전체 길이 - 모음 길이가 2개 이상인지 검사 
            //암호출력 
            return;
        }

        for(int next=last+1; next<=C; next++){

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        elements = new char[C+1];

        for(int i=1; i<=C; i++){
            elements[i] = sc.next().charAt(0);
        }

        Arrays.sort(elements);

        for(char el : elements){
            System.out.print(el+" ");
        }System.out.println();
    }
    
}
