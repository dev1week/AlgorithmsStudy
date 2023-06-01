
package String;
import java.util.*; 

class Number implements Comparable<Number>{
	String converted; 
	int number; 
	
	public Number(String converted, int number) {
		this.converted = converted;
		this.number = number; 
	}
	
	public String toString() {
		return number+""; 
	}
	@Override
	public int compareTo(Number other) {
		int min = Math.min(this.converted.length(), other.converted.length());
		for(int i=0; i<min; i++) {
			if(this.converted.charAt(i)!=other.converted.charAt(i)) {
				return this.converted.charAt(i)-other.converted.charAt(i);
			}
		}
		return 1;
	}
}

public class BOJ1755 {
	static Scanner sc = new Scanner(System.in); 
	static int n; 
	static int m; 
	static HashMap<Integer, String> dict = new HashMap<>();
	
	static void init() {
		m = sc.nextInt();
		n = sc.nextInt();
		
		dict.put(0, "zero");
		dict.put(1, "one");
		dict.put(2, "two");
		dict.put(3, "three");
		dict.put(4, "four");
		dict.put(5, "five");
		dict.put(6, "six");
		dict.put(7, "seven");
		dict.put(8, "eight");
		dict.put(9, "nine");
		
	}
	
	static ArrayList<Number> answer = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
		for(int i=m; i<=n; i++) {
			
			String converted = String.valueOf(i);
			//숫자 입력 받기 
			//숫자 문자열로 바꾸기 
			String result = "";
			for(int si=0; si<converted.length(); si++) {
				int num = converted.charAt(si) - '0'; 
				result += (dict.get(num)+" ");
			}
			answer.add(new Number(result, i));
			//문자열 순회 
				//하나씩 숫자 -> 영어로 바꾸기 
			//출력 
		}
		Collections.sort(answer);
		
		print();
	}
	
	static void print() {
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+" ");
			if(i%10==9) {
				System.out.println();
			}
		}
	}
}
