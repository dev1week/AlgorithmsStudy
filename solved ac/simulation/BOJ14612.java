package simulation;
import java.util.*; 

class Order implements Comparable<Order>{
	int tableNum, orderTime;
	
	public Order(int tableNum, int orderTime) {
		this.tableNum = tableNum;
		this.orderTime = orderTime; 
	}
	
	@Override
	public int compareTo(Order other) {
		if(this.orderTime==other.orderTime) {
			return this.tableNum - other.tableNum; 
		}
		return this.orderTime - other.orderTime;
	}
	
	public String toString() {
		return tableNum+"";
	}
}

public class BOJ14612 {
	static Scanner sc = new Scanner(System.in); 
	
	static int n; 
	static int m; 
	
	static ArrayList<Order> postitList = new ArrayList<>(); 
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
	}
	
	static void remove(int target) {
		for(int i=0; i<postitList.size(); i++) {
			if(postitList.get(i).tableNum==target) {
				postitList.remove(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		
		for(int i=0; i<n; i++) {
			String command = sc.next();
			
			if(command.equals("order")) {
				int tableNum = sc.nextInt();
				int orderTime = sc.nextInt();
				postitList.add(new Order(tableNum, orderTime));
			}else if(command.equals("sort")){
				Collections.sort(postitList);
			}else if(command.equals("complete")) {
				int findTime = sc.nextInt(); 
				remove(findTime);
			}
			if(postitList.isEmpty()) {
				System.out.println("sleep");
			}else {
				print();
			}
			
					
		}
	}
	
	static void print() {
		for(Order post : postitList) {
			System.out.print(post+" ");
		}System.out.println();
	}
}
