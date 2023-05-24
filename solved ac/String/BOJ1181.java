package String;

import java.util.*; 
class Word implements Comparable<Word>{
	String data ;
	public Word(String data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(Word other) {
		if(other.data.length()==this.data.length()) {
			for(int i=0; i<other.data.length(); i++) {
				if(other.data.charAt(i)!=data.charAt(i)) {
					return this.data.charAt(i) - other.data.charAt(i);
				}
			}
		}
		return this.data.length()-other.data.length();
	}
	
	public String toString() {
		return this.data;
	}
}
public class BOJ1181 {
	
	static Scanner sc = new Scanner(System.in); 
	static ArrayList<Word> answer = new ArrayList<>();
	static HashSet<String> no = new HashSet<>();
	static int n; 
	public static void main(String[] args) {
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String data = sc.next(); 
			no.add(data);
		}
		
		for(String word : no) {
			answer.add(new Word(word));
		}
		
		Collections.sort(answer);
		
		for(Word word:answer) {
			System.out.println(word);
		}
	}
}
