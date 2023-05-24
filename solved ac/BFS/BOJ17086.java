package BFS;
import java.util.*; 

class Point{
	int x, y;
	
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public String toString() {
		return this.x+":"+this.y;
	}
}
public class BOJ17086 {
	static Scanner sc = new Scanner(System.in); 
	
	static int n; 
	static int m; 
	
	
	static int[] dx = {-1,0,1,0-1,-1,1,1,0};
	static int[] dy = {0,1,0,-1,1,-1,1,-1,0}; 
	
	static int map[][];
	
	static int distance[][];  
	
	static final int SHARK = 1;
	static final int BLANK = 0; 
		
	static int maxSafeDistance = 0; 
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt(); 
		
		map = new int[n][m]; 
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				map[x][y] = sc.nextInt();
				if(map[x][y]==SHARK) {
					sharks.add(new Point(x,y));
				}
			}
		}
	}
	static void distanceInit() {
		distance = new int[n][m];
		for(int[] dis: distance) {
			Arrays.fill(dis, -1);
		}
	}
	
	static boolean inRange(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<m&&distance[x][y]==-1;
	}
	static ArrayList<Point> sharks = new ArrayList<>(); 
	static int getSafeDistance() {
		int result = Integer.MAX_VALUE; 
		
		for(Point shark : sharks) {
			result = Math.min(distance[shark.x][shark.y],result);
		}
		
		return result;
		
		
		
	}
	
	static void print() {
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				System.out.print(distance[x][y]+" ");
			}System.out.println();
		}
	}
	
	static int bfs(int sX, int sY) {
		distanceInit();  
		Queue<Point> que = new LinkedList<>(); 
		que.add(new Point(sX, sY));
		distance[sX][sY] = 0; 
		
		
		while(!que.isEmpty()) {
			Point current = que.poll();
			
			for(int dir=0; dir<=7; dir++) {
				int nX = current.x+dx[dir];
				int nY = current.y+dy[dir]; 
				if(!inRange(nX, nY))continue;
				
				distance[nX][nY] = distance[current.x][current.y] +1; 
				que.add(new Point(nX, nY));
				
			}
		}
		
		return getSafeDistance(); 
		
	}
	
	public static void main(String[] args) {
		 
		
		init(); 
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				if(map[x][y] == BLANK) {
					maxSafeDistance = Math.max(maxSafeDistance, bfs(x,y));
				}
			}
		}
		
		System.out.println(maxSafeDistance); 
		
		//모든 맵에 대해 순회 
			//0일 때만 bfs 진행
				
		
		
		
	}
}
