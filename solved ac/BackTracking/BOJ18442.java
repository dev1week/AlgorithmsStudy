package BackTracking;
import java.util.*; 
public class BOJ18442 {
	static Scanner sc = new Scanner(System.in);
	
	static int p; //지으려는 우체국 개수 
	static int v; //마을 개수 
	static long l; //큰 길 둘레의 길이 
	
	static long[] villages;
	
	static boolean[] isUsed;
	
	static void init() {
		v = sc.nextInt();
		p = sc.nextInt();
		l = sc.nextLong();
		
		villages = new long[v];
		isUsed = new boolean[v];
		
		for(int i=0; i<v; i++) {
			villages[i] = sc.nextLong(); 
		}
		
		
	}
	
	static long getDistance(long x, long y) {
		return Math.min(Math.abs(x-y), l-Math.abs(x-y));
	}
	
	
	static long getTotalDistance() {
		long sum = 0;
		long[] distances = new long[v]; //distances[i] = 우체국과의 거리 중 최소 길이 
		Arrays.fill(distances, Integer.MAX_VALUE);
		for(long selected : selecteds) {
			for(int i=0; i<v; i++) {
				long tmpDistance = getDistance(selected, villages[i]);
				distances[i] = Math.min(distances[i], tmpDistance);
			}
		}
		
		for(int i=0; i<v; i++) {
			sum += distances[i];
		}
		
		return sum; 
	}
	//v개 중 p개 뽑기 
	static ArrayList<Long> selecteds = new ArrayList<>(); 
	static ArrayList<Long> answer = new ArrayList<>(); 
	static long answerDistance = Long.MAX_VALUE;
	static void bt(int cur, int last) {
		if(cur==p+1) {
			long tmp = getTotalDistance(); 
			if(answerDistance>tmp) {
				answer = new ArrayList<>();
				for(int i=0; i<p; i++) {
					answer.add(selecteds.get(i));
				}
				answerDistance = tmp;
			}
			//갱신하기 
			return;
		}
		
		
		for(int i=last+1; i<v; i++) {
			if(isUsed[i])continue; 
			isUsed[i] = true; 
			selecteds.add(villages[i]);
			bt(cur+1, i);
			selecteds.remove(selecteds.size()-1);
			isUsed[i] = false;
		}
		
	}
	static void printP() {
		for(long p : answer) {
			System.out.print(p+" ");
		}System.out.println();
	}
	
	public static void main(String[] args) {
		init();
		bt(1, -1);
		System.out.println(answerDistance);
		printP();
		
	}
}
