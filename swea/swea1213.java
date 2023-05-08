
import java.util.*; 
import java.io.*;

class Solution
{	
	static int T = 10;
	
	static boolean inRange(int i, int len) {
		return i>=0&&i<=len;
	}
	
	static int count(String search, String data) {
		int count = 0;
		
		for(int i=0; i<data.length(); i++) {
			if(!inRange(i+search.length(), data.length()))continue;
			String part = data.substring(i, i+search.length());
			//System.out.println(part); 
			if(part.equals(search)) {
				
				count ++;
			}
		}
		
		
		return count ;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		for(int testCase=1; testCase<=T; testCase++) {
			int dummy = sc.nextInt();
			
			String search = sc.next();
			String data = sc.next(); 
			
			System.out.println("#"+testCase+" "+count(search, data));
		}
	}
}