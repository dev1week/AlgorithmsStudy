package String;

import java.util.*;

public class BOJ25178 {
	static Scanner sc = new Scanner(System.in);
	
	
 
 
 
	
	//세 조건을 만족하면 Yes 아니면no 를 출력한다. 
	
	//한 단어를 재배열해 다른 단어를 만들 수 있어야한다. 
		//카운팅 배열을 활용해 일일히 검사한다. 
	static boolean isOverSect(String d1, String d2) {
		int[] dict1 = new int[40];
		int[] dict2 = new int[40];
		
		
		for(int i=0; i<n; i++) {
			char c1 = d1.charAt(i);
			int idx1 = c1-'a';
			char c2 = d2.charAt(i);
			int idx2 = c2-'a';
			dict1[idx1]++;
			dict2[idx2]++; 
		}
		
		for(int i=0; i<40; i++) {
			if(dict1[i]!=dict2[i]) {
				return false;
			}
		}
		return true;
	}
	
	//두 단어의 첫글자와 마지막 글자는 서로 동일해야한다.
	static boolean isSameLastChar(String d1, String d2) {
		return (d1.charAt(n-1)==d2.charAt(n-1))&&d1.charAt(0)==d2.charAt(0);
	}
	


	
    
	
	static boolean isAEIOU(char c) {
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
	}
	
	//aeiou를 제외한 문자열은 동일해야한다.
	static boolean isSameWithoutA(String d1, String d2) {
		String convert1 ="";
		String convert2 = "";
		
		for(int i=0; i<n; i++) {
			char c1 = d1.charAt(i);
			char c2 = d2.charAt(i);
			
			if(!isAEIOU(c1)) {
				convert1+=c1;
			}
			
			if(!isAEIOU(c2)) {
				convert2+=c2; 
			}
		}
		
		return convert1.equals(convert2);
	}
	//일일히 변환하는 것보다는 정규식을 써서 변환하는 것이 더 좋다. 
//	private boolean isRule3Satisfied() {
//        String replacedA = a.replaceAll("[aeiou]", "");
//        String replacedB = b.replaceAll("[aeiou]", "");
//        return replacedA.equals(replacedB);
//    }
	static int n; 
	
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		
		String data1 = sc.next();
		String data2 = sc.next();
		boolean flag = true; 
		if(!isOverSect(data1, data2)) {
			flag = false;
		}
		if(!isSameLastChar(data1, data2)) {
			flag = false; 
		}
		if(!isSameWithoutA(data1, data2)) {
			flag = false;
		}
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		
		
	}
}
