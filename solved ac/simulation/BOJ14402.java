package simulation;
import java.util.*;
public class BOJ14402 {
	static Scanner sc = new Scanner(System.in); 
	
	//야근 
		//들어온 기록이 없는데 나온 기록이 있다면
		//들어가 있는데 퇴근시간까지 나온 기록이 없다면 
	
	static int n; 
	static HashMap<String, Integer> entered = new HashMap<>(); 
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		
		int result = 0; 
		for(int i=0; i<n; i++) {
			String name = sc.next();
			char command = sc.next().charAt(0);
			
			if( command=='+') {
				entered.put(name, entered.getOrDefault(name, 0)+1);
			}else if(command=='-') {
				if(entered.containsKey(name)) {
					if(entered.get(name)==1) {
						entered.remove(name);
					}else {
						entered.put(name, entered.get(name)-1);
					}
				}else {
					result++;
				}
			}
		}
		Set<String> keys = entered.keySet();
		for(String key : keys) {
			result += entered.get(key);
		}
		System.out.println(result);
		//입력 받기 
			//+-> 해쉬셋에 넣기
			//- -> 
				//해쉬셋에서 찾아본다 
					//=> 있으면 삭제
					//=> 없으면 야근 
		
		//야근횟수 += 해쉬셋 크기 
	}
}
