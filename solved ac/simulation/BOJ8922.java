package simulation;
import java.util.*;

public class BOJ8922 {
	static Scanner sc = new Scanner(System.in);
	
	static Queue<int[]> que;
	
	
	static int T; 
	static int n; //15
	
	static HashSet<int[]> log = new HashSet<>();
	
	static void init() {
		n = sc.nextInt(); 
		int[] arr = new int[n];
		que = new LinkedList<>();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt(); 
		}
		que.add(arr);
	}
	
	static boolean isAllSame(int[] arr) {
		for(int i=1; i<n; i++) {
			if(arr[i-1]!=arr[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			init();
			boolean flag=false;
			for(int i=0; i<1001; i++) {
				int[] currentArr = que.poll();
				
				if(isAllSame(currentArr)) {
					flag = true;
					break;
				}
				
				int[] newArr = new int[n];
				
				
				for(int idx=0; idx<n-1; idx++) {
					newArr[idx] = Math.abs(currentArr[idx]-currentArr[idx+1]);
				}
				
				newArr[n-1] = Math.abs(currentArr[0]-currentArr[n-1]);
				if(log.contains(newArr))break;
				que.add(newArr);
				log.add(newArr);
				
				
			}
			if(flag) {
				System.out.println("ZERO");
			}else {
				System.out.println("LOOP");
			}
			
		
			
		}
		//1000회 반복 
			//큐에서 수열 가져오기 
			//전부 같은가? //break;  
			//인접항 빼줘서 다음 수열 만들기 
			//다음 수열 큐에 넣기 
		
	}
	
	static void print(Integer[] arr) {
		for(Integer a: arr) {
			System.out.print(a+" ");
		}System.out.println();
	}
}
