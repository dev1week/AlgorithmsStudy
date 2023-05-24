package simulation;
import java.util.*; 

public class BOJ14381 {
	static int n; //200 
	static int T; //100
	static Scanner sc= new Scanner(System.in); 
	
	public static void main(String[] args) {
		T = sc.nextInt();
		 
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			HashSet<Integer> dict = new HashSet<>();
			int count = 1; 
			int tmp = 0;
			while(dict.size()<10) {
				if(n==0)break; 
				tmp = n*count; 
				String data = String.valueOf(tmp); 
				
				for(int i=0; i<data.length(); i++) {
					dict.add(data.charAt(i)-'0');
				}
				count++;
			}
			
			if(n==0) {
				System.out.println("Case #"+t+": INSOMNIA");
			}else {
				System.out.println("Case #"+t+": "+tmp);
			}
			// 곱한 수 순회 
				//곱한 수 일일히 쪼갠다. 
					//딕셔너리에 넣는다. 
				//딕셔너리의 크기가 10일 경우 somnia 출력후 break; 
			
		}
	}
	
}
