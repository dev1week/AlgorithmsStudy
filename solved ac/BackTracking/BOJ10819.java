package BackTracking;
import java.util.*;

public class BOJ10819 {
	static Scanner sc = new Scanner(System.in); 
	static int n; 
	static int[] arr;
	static boolean[] isUsed;
	
	static void init() {
		n = sc.nextInt();
		
		arr = new int[n];
		isUsed = new boolean[n]; 
		selecteds = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt(); 
		}
	}
	
	static int cal() {
		int sum = 0;
		for(int i=1; i<n; i++) {
			sum += Math.abs(selecteds.get(i)-selecteds.get(i-1));
		}
		return sum; 
	}
	
	static int result = Integer.MIN_VALUE; 
	static ArrayList<Integer> selecteds;
	
	static void bt(int cur) {
		if(cur==n+1) {
			
			result = Math.max(cal(), result);
			return; 
		}
		
		for(int next=0; next<n; next++) {
			if(isUsed[next])continue; 
			isUsed[next] = true;
			selecteds.add(arr[next]);
			bt(cur+1);
			selecteds.remove(selecteds.size()-1);
			isUsed[next] = false; 
		}
	}
	
	public static void main(String[] args) {
		init();
		bt(1);
		System.out.println(result);
		
		//bt로 n개 중에 n개 뽑는다. (중복 없이 순열  뽑고난 순열대로 수열 만들기 
	}
}
