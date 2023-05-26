package String;

import java.util.*; 

public class BOJ1764 {
	static Scanner sc = new Scanner(System.in);
	
	static HashSet<String> notListened = new HashSet<>(); 
	static HashSet<String> notSeened = new HashSet<>(); 
	
	static PriorityQueue<String> answer = new PriorityQueue<>(); 
	
	static int n;
	static int m; 
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		for(int i=0; i<n; i++) {
			notListened.add(sc.next());
		}
		
		for(int i=0; i<m; i++) {
			notSeened.add(sc.next());
		}
	}
	
	public static void main(String[] args) {
		
		//듣도 못한 사람 입력 
		//보도 못한 사람 입력 
		init();
		
		for(String name : notListened) {
			if(notSeened.contains(name)) {
				answer.add(name);
			}
		}
		
		
		System.out.println(answer.size()); 
		for(String name: answer) {
			System.out.println(name);
		}
		//N 
		//듣도 못한 사람 순회 
			//보도 못한 사람 목록에 있을 경우 1 
				//answer에 담기 
		
		//answer 정렬 
		
		
	}
}
