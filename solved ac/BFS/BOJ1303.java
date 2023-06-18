package BFS;
import java.io.*;
import java.util.*; 

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y =y; 
	}
}

public class BOJ1303 {
	

	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	static int n; 
	static int m; 
	
	static final char WHITE = 'W'; 
	static final char BLACK = 'B'; 
	
	static char[][] map; 
	static boolean[][] isVisited; 
	
	static void init() throws IOException{
		StringTokenizer tokens = new StringTokenizer(buffer.readLine()); 
		
		n = Integer.valueOf(tokens.nextToken()); 
		m = Integer.valueOf(tokens.nextToken());
		
		map= new char[m][n]; 
		isVisited = new boolean[m][n];
		for(int x=0; x<m; x++) {
			String line = buffer.readLine();
			for(int y=0; y<n;y++ ) {
				map[x][y] = line.charAt(y); 		
			}
		}
	}
	
	static void printMap() {
		for(char[] ma : map) {
			for(char m : ma) {
				System.out.print(m);
			}System.out.println(); 
		}
	}
	
	static int calPower(int number) {
		return number*number; 
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1}; 
	
	static int bfs(Point start, char color) {
		int count = 1; 
		
		Queue<Point> que = new LinkedList<>();
		isVisited[start.x][start.y] = true; 
		que.add(start); 
		
		while(!que.isEmpty()) {
			Point cur = que.poll(); 
			
			for(int dir=0; dir<4; dir++) {
				int nX= cur.x+ dx[dir]; 
				int nY = cur.y+dy[dir]; 
				
				if(canGo(nX, nY, color)) {
					isVisited[nX][nY] = true; 
					count++;
					que.add(new Point(nX, nY)); 
				}
			}
		}	
		
		return calPower(count);
	}
	
	
	static boolean canGo(int nX, int nY, char color) {
		if(color==BLACK) {
			return isValid(nX, nY)&&!isVisited[nX][nY]&&map[nX][nY]==BLACK;
		}else {
			return isValid(nX, nY)&&!isVisited[nX][nY]&&map[nX][nY]==WHITE;
		}
	}
	
	static boolean isValid(int x, int y) {
		return x>=0&&y>=0&&x<m&&y<n; 
	}
	
	public static void main(String[] args) throws IOException{
		
		init(); 
		
		
		int blackPower = 0; 
		//검은색 파워 세기 
		for(int x=0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(map[x][y]==BLACK&&!isVisited[x][y]) {
					
					blackPower += bfs(new Point(x, y), BLACK); 
				}
			}
		}
		
		int whitePower =0; 
		//흰색 파워세기 
		for(int x=0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(map[x][y]==WHITE&&!isVisited[x][y]) {
					
					whitePower += bfs(new Point(x, y), WHITE); 
				}
			}
		} 
		System.out.println(whitePower+" "+blackPower);
	}
}
