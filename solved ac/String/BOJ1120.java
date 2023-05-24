package String;
import java.util.*; 
public class BOJ1120 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String a = sc.next();
		String b = sc.next(); 
		int n = b.length();
		int k = a.length();
		int result = Integer.MAX_VALUE; 
		
		if(a.length()==b.length()) {
			int count = 0; 
			for(int i=0; i<n; i++) {
				if(a.charAt(i)!=b.charAt(i)) {
					count++;
				}
			}
			result = Math.min(count, result);
		}else {
			for(int i=0; i<n-k+1; i++) {
				int count = 0; 
				for(int j=0; j<k; j++) {
					if(a.charAt(j)!=b.charAt(i+j)){
						count++;
					}
				}
				
				result = Math.min(result, count);
			}
		}
		System.out.println(result);
		
		
		//길이가 같으면 
			//바로 계산 
		
		//길이가 짧으면 
			//하나씩 붙여보면서 최소값 계산 
		
		
		//b순회 
			//a글자 개수만큼 쪼개면서 보기 
	}
}
