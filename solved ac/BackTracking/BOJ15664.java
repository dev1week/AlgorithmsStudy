package BackTracking;
import java.util.*; 
public class BOJ15664 {
	static Scanner sc = new Scanner(System.in);
	static int n; 
	static int m; 
	
	static int[] numbers;
	
	static boolean[] isUsed; 
	
	static TreeSet<String> answers = new TreeSet<>(); 
	
	static int getDistance() {
		int result = 0; 
		
		for(int s: selecteds) {
			for(int 퍄)
		}
		
		return result; 
	}
	
	static void bt(int cur, String res, int last) {
		if(cur==m+1) {
			answers.add(res);
			//뽑아온 마을 좌표로 각 마을과 우체국 사이 거리 최소합 구하기 
			return; 
		}
		
		for(int i=last+1; i<n; i++) {
			if(isUsed[i])continue;
			isUsed[i] = true;
			String next = res+" "+numbers[i];
			if(cur==1) {
				next = numbers[i]+"";
			}
			bt(cur+1, next, i);
			isUsed[i] = false;
		}
	}
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		isUsed= new boolean[n];
		
		numbers = new int[n];
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers);
	}
	public static void main(String[] args) {
		init();
		bt(1, "", -1);
		
		print();
	}
	
	static void print() {
		for(String data : answers) {
			System.out.println(data);
		}
	}
	
	
}
