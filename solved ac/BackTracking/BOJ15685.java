package BackTracking;
import java.util.*; 

public class BOJ15685 {
	static Scanner sc = new Scanner(System.in); 
	
	static int[] numbers;
	static int n; 
	static int[] operands = new int[4]; 
	
	static final int PLUS = 0;
	static final int MINUS = 1;
	static final int MUL =2;
	static final int DIV = 3; 
	
	//중복순열
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void bt(int cur, int res) {
		if(cur==n) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return; 
		}
		
		for(int opt=0; opt<4; opt++) {
			if(operands[opt]<1)continue;
			operands[opt]--; 
			if(opt==PLUS) {
				bt(cur+1, res+numbers[cur]);
			}else if(opt==MINUS) {
				bt(cur+1, res-numbers[cur]);
			}else if(opt==MUL) {
				bt(cur+1, res*numbers[cur]);
			}else if(opt==DIV) {
				bt(cur+1,res/numbers[cur]);
			}
			operands[opt]++; 
			
			
		}
	}
	static void init() {
		n = sc.nextInt(); 
		numbers = new int[n];
		operands = new int[4]; 
		
		for(int i=0; i<n; i++) {
			numbers[i] =sc.nextInt(); 
		}
		
		for(int i=0; i<4; i++) {
			operands[i]=sc.nextInt(); 
		}
		
	}
	
	
	public static void main(String[] args) {
		init();
		bt(1, numbers[0]);
		System.out.println(max);
		System.out.println(min); 
	}
	

}
