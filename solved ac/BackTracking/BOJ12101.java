package BackTracking;

import java.util.*;
public class BOJ12101 {
	static Scanner sc = new Scanner(System.in); 
	
	static int n; 
	static int k;
	static int[] numbers = new int[] {1,2,3}; 
	static ArrayList<Integer> selecteds = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> log = new ArrayList<>();
	static void init() {
		n = sc.nextInt();
		k = sc.nextInt(); 
	}
	static int count = 0;
	static boolean isPossible = false;
	
	static void print() {
		for(int i=0; i<selecteds.size()-1; i++) {
			System.out.print(selecteds.get(i)+"+");
		}
		System.out.print(selecteds.get(selecteds.size()-1));
		System.out.println();
	}
	static void bt( int result) {
		
		if(result>=n) {
			if(result==n) {
				count ++;
				if(count==k) {
					print();
					isPossible = true;
				}
				
				
				//log에 등록하기
			}
			return;
		}
		for(int number: numbers) {
			selecteds.add(number);
			bt(result+number);
			selecteds.remove(selecteds.size()-1);
		}
		
		
	}
	 
	public static void main(String[] args) {
		init();
		bt(0);
		if(!isPossible) {
			System.out.println(-1);
		}
		
		
	}
}
