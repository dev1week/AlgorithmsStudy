package Greedy;
import java.util.*; 
class Meeting implements Comparable<Meeting>{
	int start;
	int end; 
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end; 
	}
	
	public String toString() {
		return this.start+"~"+this.end;
	}
	
	@Override
	public int compareTo(Meeting other) {
		if(other.end==this.end) {
			return this.start-other.start;
		}
		return this.end-other.end; 
	}
	
	
}


public class boj1931 {
	
	static Scanner sc = new Scanner(System.in);
	static int n;
	
	static ArrayList<Meeting> candidates = new ArrayList<>(); 
	static ArrayList<Meeting> selecteds = new ArrayList<>();
	
	static void init() {
		n = sc.nextInt(); 
		for(int i=0; i<n; i++){
			int start = sc.nextInt();
			int end = sc.nextInt(); 
			
			candidates.add(new Meeting(start, end)); 
		}
	}
	
	public static void main(String[] args) {
		init(); 
		//종료시간 기준으로 정렬 
		Collections.sort(candidates);
		//selected에 처음 시간 넣기 
		
		int prevEnd = candidates.get(0).end; 
		int  count =1; 
		for(int i=1; i<n; i++) {
			if(prevEnd <= candidates.get(i).start) {
				count++; 
				prevEnd = candidates.get(i).end; 
			}
		}
		
		System.out.println(count); 
		//1~n까
			//전에 끝나는 시간 <= 후보군 시작 시간 비교 
				//가능하면 넣고 전에 끝나는 시간 갱신 
	}
	

}
