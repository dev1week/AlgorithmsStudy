import java.io.*;
import java.util.*;


class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	public String toString(){
		return this.x+" "+this.y; 
	}
}

public class Main {
	//백준15686 - 치킨 배달 
	
	//문제 풀기전 작성했던 수도 코드 + 예상 시간복잡도는 아래 주석을 참조해주세요 
	static final int BLANK = 0;
	static final int HOUSE = 1;
	static final int CHICKEN = 2; 
	
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens; 
	
	static int[][] map;
	
	static int n; // ~50 
	static int m; // ~13 
	
	static boolean[] isUsed; 
	
	static ArrayList<Point> houses = new ArrayList<>();
	static ArrayList<Point> chickens = new ArrayList<>(); 
	
	static void init() throws IOException{
		tokens = new StringTokenizer(buffer.readLine());
		
		int n= Integer.valueOf(tokens.nextToken());
		m = Integer.valueOf(tokens.nextToken()); 
		
		map = new int[n][n]; 
		
		for(int x=0; x<n; x++) {
			tokens = new StringTokenizer(buffer.readLine());
			for(int y=0; y<n; y++) {
				map[x][y] = Integer.valueOf(tokens.nextToken());
				if(map[x][y] == CHICKEN){
					chickens.add(new Point(x, y));
				}
				if(map[x][y] ==HOUSE) {
					houses.add(new Point(x,y));
				}
				
			}
		}
		isUsed = new boolean[chickens.size()]; 
		
	}
	
	//각각의 집은 치킨 거리를 가지고 있다. 
	//도시의 치킨 거리는 모든 치킨 거리의 합이다. 
	
	
	//조합, 중복 x 
	//m개의 치킨집을 선택한다 -> 백트래킹 
		// 전부 선택이 완료되었을 경우 
			// 해당 선택지로부터 치킨 거리를 구한다. => bfs돌려서 
				 
				
			//최소 치킨 거리를 갱신한다. 
	
	
	// 13C7 * (7*100) 
		//백트래킹 자체 시간 복잡도 * 다 고르고나서 치킨 거리 구하는 로직  
	static ArrayList<Point> selecteds =new ArrayList<>();
	static int result = Integer.MAX_VALUE; 
	
	static int getTotalDist() {
		
		int totalDist = 0; 
		
		for(Point house : houses) {
			int tmpDist = Integer.MAX_VALUE;
			for(Point chicken : selecteds) {
				tmpDist = Math.min(tmpDist, getDist(chicken, house)); 
			}
			totalDist += tmpDist; 
		}
		return totalDist; 
	}
	
	static void bt(int cur, int last) {
		if(cur==m+1) {
			result = Math.min(result, getTotalDist());
			return; 
		}
		
		for(int nextChicken =last+1; nextChicken<chickens.size(); nextChicken++) {
			if(!isUsed[nextChicken]) {
				isUsed[nextChicken] = true;
				selecteds.add(chickens.get(nextChicken));
				bt(cur+1, nextChicken); 
				selecteds.remove(selecteds.size()-1);
				isUsed[nextChicken] = false;
				
			}
			
			
		}
		
	}
	
	
	//임의의 두칸 사이 거리 
	static int getDist(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y); 
	}
	
	
	public static void main(String[] args) throws IOException{
		init(); 
		bt(1,-1);
		System.out.println(result); 
		
		
	}
}
