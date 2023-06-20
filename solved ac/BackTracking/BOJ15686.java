package BackTracking;
import java.io.*; 
import java.util.*;

class Point{
	int x, y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return this.x+":"+this.y; 
	}
}

public class BOJ15686 {
	static int n;
	static int m; 
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	static ArrayList<Point> chickens;
	static ArrayList<Point>  houses;
	
	static final int BLANK=0;
	static final int HOUSE = 1;
	static final int CHICKEN = 2; 
	
	static boolean[] isUsed; 
	
	static void init()throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
		n = Integer.valueOf(tokens.nextToken()); 
		m = Integer.valueOf(tokens.nextToken()); 
		
		chickens = new ArrayList<>();
		houses = new ArrayList<>(); 
		selecteds = new ArrayList<>(); 
		
		
		for(int x=1; x<=n; x++) {
			tokens = new StringTokenizer(buffer.readLine());
			for(int y=1; y<=n; y++) {
				int map = Integer.valueOf(tokens.nextToken());
				if(map==CHICKEN) {
					chickens.add(new Point(x, y)); 
				}else if(map==HOUSE) {
					houses.add(new Point(x, y)); 
				}
			}
		}
		isUsed = new boolean[chickens.size()]; 
		
	}
	
	
	//치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리 
	
	
	//전체 치킨집 중 m개 뽑기 => 조합
		// 집 순회 
			//뽑은 치킨집 중 최소값의 치킨 거리 구하기 
		//총합 반환 
	
	//치킨집 개수 최대 : 13
	//집의 개수 최대 : 100
	//
	// (13)C7 * 13 * 집의 개수100
	static ArrayList<Point> selecteds; 
	static int result = Integer.MAX_VALUE;
	
	static int getCDistance(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y); 
	}
	
	static void bt(int cur, int last) {
		if(cur==m+1) {
			int cityTotalDistance = 0; 
			
			
			for(Point house : houses) {
				int chickenDistance= Integer.MAX_VALUE;
				for(Point selected : selecteds) {
					chickenDistance = Math.min(chickenDistance, getCDistance(house, selected));
				}cityTotalDistance += chickenDistance;
			}
			result = Math.min(result, cityTotalDistance);

			return; 
		}
		
		for(int next=last+1; next<chickens.size(); next++) {
			if(isUsed[next])continue; 
			isUsed[next] = true;
			selecteds.add(chickens.get(next));
			bt(cur+1, next);
			selecteds.remove(selecteds.size()-1); 
			isUsed[next] = false; 
		}
	}
	
	public static void main(String[] args)throws IOException{
		init();
		bt(1,-1); 
		System.out.println(result); 
		
	}
}
