import java.util.Scanner;
import java.util.Stack;
import java.util.*; 



public class BOJ10773 {
    static Stack<Integer> stack= new Stack<>();
    static int stackSum(){
        int sum=0; 
        Iterator<Integer> it = stack.iterator();
        while(it.hasNext()){
            sum += it.next();
        }
        return sum; 
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); 
        for(int i=0; i<num; i++){
            int data = sc.nextInt();
            if(data==0){stack.pop();}
            else{stack.add(data);}
        }
    }
    public static void main(String[] args){
        init(); 
        System.out.println(stackSum()); 
    }
}
