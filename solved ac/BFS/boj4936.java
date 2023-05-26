package BFS;
import java.awt.Point;
import java.util.*;

class Point2{
	int x, y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y; 
		
	}
	public String toString() {
		return this.x+":"+this.y; 
	}
}

public class boj4936 {
	static Scanner sc = new Scanner(System.in); 
	
	static int[][] map;
	static boolean[][] isVisited; 
	
	static final int OCEAN=0; 
	static final int GRD = 1;
	
	static int w=1;
	static int h=1;
	
	static void init() {
		w = sc.nextInt();
		h = sc.nextInt(); 
		map = new int[h][w];
		isVisited = new boolean[h][w];
		for(int x=0; x<h; x++) {
			for(int y=0; y<w; y++) {
				map[x][y] = sc.nextInt();
			}
		}
	}
	
	static boolean inRange(int x, int y) {
		return x>=0&&y>=0&&x<h&&y<w;
	}
	static boolean canGo(int x, int y) {
		return inRange(x, y)&&map[x][y] ==GRD&&!isVisited[x][y];
	}
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,-1,0,1,1,-1,1,-1};
	static void bfs(int sX, int sY) {
		Queue<Point> que = new LinkedList<>();
		isVisited[sX][sY] = true; 
		
		que.add(new Point(sX, sY));
		
		while(!que.isEmpty()) {
			Point current = que.poll();
			for(int dir=0; dir<8; dir++) {
				int nX = current.x+dx[dir];
				int nY = current.y+dy[dir];
				
				if(canGo(nX, nY)) {
					que.add(new Point(nX, nY));
					isVisited[nX][nY] = true;
				}
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		while(w!=0&&h!=0) {
			init(); 
			int count = 0;
			for(int x=0; x<h; x++) {
				for(int y=0; y<w; y++) {
					if(!isVisited[x][y]&&map[x][y]==GRD) {
						bfs(x,y);
						count++;
					}
				}
			}
			if(w!=0&&h!=0) {
				System.out.println(count);
			}
			
		}
	}
}
