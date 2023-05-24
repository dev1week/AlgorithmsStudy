package String;
import java.util.*; 
public class BOJ1235 {
	static Scanner sc = new Scanner(System.in); 
	static int n; 
	static String[] students; 
	static int length;
	
	static void init() {
		n = sc.nextInt(); 
		students = new String[n]; 
		
		for(int i=0; i<n; i++) {
			students[i] = sc.next(); 
		}
		length = students[0].length();
	}
	
	public static void main(String[] args) {
		
		init(); 
		int result = 0;
		//k<length로 설정하여 
		//3
		//12345
		//22345
		//32345에서 반례 발생함 
		//항상 엣지 케이스 생각하자 
		for(int k=1; k<=length; k++) {
			HashSet<String> list = new HashSet<>();
			for(int student=0; student<n; student++) {
				String tmp = students[student].substring(length-k,length);
				list.add(tmp);
				
			}
			if(list.size()==n) {
				result = k; 
				break;
			}
		}
		
		System.out.println(result);
		//k:1~최대길이 
			//뒤에서 k개 문자 가져오기 
			//해쉬에 넣기 
			//해쉬 길이랑 n이랑 같은가?
				//같으면 result = k; 
				//break; 
	}
}
