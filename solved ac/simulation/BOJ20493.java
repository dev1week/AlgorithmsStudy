package simulation;
import java.util.*;
import java.io.*; 


class Player{
	int x, y;
	int dir; 
	

	static int[] dx = {1,0,-1,0};
	static int[] dy= {0,-1,0,1};
	
	public Player(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir; 
	}
	
	public void turnRight() {
		this.dir++;
		if(this.dir>=4) {
			this.dir = 0; 
		}
	}
	
	public void turnLeft() {
		this.dir--; 
		if(this.dir<0) {
			this.dir = 3; 
		}
	}
	
	public String toString() {
		return this.x+" "+this.y; 
	}
	
	public void move(int dist) {
		this.x += dx[this.dir]*dist; 
		this.y += dy[this.dir]*dist; 
	}
}
public class BOJ20493 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
	
	
	static final String RIGHT = "right";
	static final String LEFT = "left";
	
	public static void main(String[] args)throws IOException {
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		int n = Integer.valueOf(tokens.nextToken());
		int T = Integer.valueOf(tokens.nextToken());
		
		
		
		Player player = new Player(0,0,0);
		
		
		int currentTime = 0; 
		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(buffer.readLine());
			int time = Integer.valueOf(tokens.nextToken()); 
			String command = tokens.nextToken();
			
			player.move(time-currentTime);
			
			if(command.equals(LEFT)) {
				player.turnLeft();
			}else if(command.equals(RIGHT)) {
				player.turnRight(); 
			}
			
			currentTime = time; 
			
		}
		
		if(T>currentTime) {
			player.move(T-currentTime);
		}
		System.out.println(player);
		//남은 거리 해당 방향 이동 
		
		
	}
}
