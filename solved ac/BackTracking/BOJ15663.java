
package BackTracking;
import java.util.*; 
public class BOJ15663 {
	
	static Scanner sc = new Scanner(System.in);
	static int n; 
	static int m; 
	
	static int[] counts;
	static int maxValue = 0; 
	
	static ArrayList<Integer> answer = new ArrayList<>();
	static void print() {
		for(Integer a : answer) {
			System.out.print(a+" ");
		}System.out.println();
	}
	static void bt(int cur) {
		if(cur==m+1) {
			print();
			return; 
		}
		
		for(int i=1; i<=maxValue; i++) {
			if(counts[i]<1)continue; 
			counts[i] --;
			answer.add(i);
			bt(cur+1);
			counts[i]++;
			answer.remove(answer.size()-1);
			
		}
	}
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		counts = new int[10001];
		for(int i=0; i<n; i++)
		{	
			int data = sc.nextInt();
			counts[data] ++;
			maxValue = Math.max(maxValue, data);
		}
			
	}
	
	public static void main(String[] args) {
		init();
		bt(1);
	}

}
