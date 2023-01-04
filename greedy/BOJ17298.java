import java.util.Iterator;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args){
        int[] A = new int[]{3,5,2,7};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[4];
        for(int idx =0; idx<A.length; idx++){
            
            if(stack.isEmpty()){
                stack.add(idx);
                System.out.println("top : "+stack.peek()+"idx : "+idx);
            }
            else if(A[idx]>A[stack.peek()]){
                while(stack.isEmpty()){
                    System.out.println("top : "+stack.peek()+"idx : "+idx);
                    res[stack.pop()]=A[idx];
                }
            }stack.add(idx);
        }
        for(int a : res){
            System.out.println(a);
        }

        
    }
    
}
