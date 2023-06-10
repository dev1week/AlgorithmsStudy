package PriorityQue;
import java.util.*;
import java.io.*;

class Doc implements Comparable<Doc>{
	int name;
	int prior; 
	
	public Doc(int name, int prior) {
		this.name = name;
		this.prior = prior; 
	}
	
	@Override 
	public int compareTo(Doc other) {
		if(this.prior==other.prior) {
			return this.name - this.prior;
		}
		return other.prior- this.prior; 
	}
	
	public String toString() {
		return this.name+"의 우선순위는 "+this.prior+"입니다.";
	}
	
}

public class BOJ1966 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	//프린터	
		//현재 큐의 가장 앞에 있는 문서의 중요도 확인 
		//나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있으면 
			//뒤에 재배치
		//없으면 인쇄 
	static int T; 
	static int n; 
	static int q; 
	static ArrayList<Doc> printerQue;
	static PriorityQueue<Doc> priorQue;
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		n = Integer.valueOf(tokens.nextToken());
		q = Integer.valueOf(tokens.nextToken());
		printerQue = new ArrayList<>(); 
		priorQue = new PriorityQueue<>();
		tokens = new StringTokenizer(buffer.readLine());
		for(int i=0; i<n; i++) {
			int prior = Integer.valueOf(tokens.nextToken());
			printerQue.add(new Doc(i, prior));
			priorQue.add(new Doc(i, prior));
		}
		
	}
	public static void main(String[] args) throws IOException{
		T = Integer.valueOf(buffer.readLine());
		
		while(T-->0) {
			init();
			int printCount = 0; 
			while(!printerQue.isEmpty()) {
				Doc currentDoc = printerQue.get(0); 
				//앞의 문서의 중요도 확인
				if(currentDoc.prior == priorQue.peek().prior) {
					printerQue.remove(0);
					priorQue.poll(); 
					printCount ++;
					if(currentDoc.name == q) {
						break;
					}
				}else {
					printerQue.remove(0);
					printerQue.add(currentDoc);
				}
			}
			System.out.println(printCount);
			

			
			//나머지 문서들중 현재문서보다 중요도가 높은 문서가 하나라도 있는가? 
				//있다 -> 뒤로 보내 
				//없다 -> 인쇄 
					//인쇄 카운트 
					//인쇄한 것이 q인가?
						//break 후 인쇄 카운트 출력 
			
		}
	}
}
