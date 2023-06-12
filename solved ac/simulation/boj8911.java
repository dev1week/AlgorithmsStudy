package simulation;

import java.io.*;
import java.util.*;

class Robot{
	int x;
	int y;
	int dir; 
	
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public Robot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
	void turnRight(){
		this.dir++;
		if(this.dir>=4) {
			this.dir = 0;
		}
	}
	
	void turnLeft() {
		this.dir--;
		if(this.dir<0) {
			this.dir = 3; 
		}
	}
	
	void move() {
		this.x += dx[this.dir];
		this.y += dy[this.dir];
	}
	void back() {
		this.x -= dx[dir];
		this.y -= dy[dir];
	}
	
	public String toString() {
		return this.x+":"+this.y;
	}
}

public class boj8911 {
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	
	static int cal(int minX, int maxX, int minY, int maxY) {
		return Math.abs(maxX-minX) * Math.abs(maxY-minY);
	}
	
	static int T; 
	
	public static void main(String[] args) throws IOException{
		T = Integer.valueOf(buffer.readLine());
		StringBuilder result = new StringBuilder();
		for(int t=0; t<T; t++) {
			String data = buffer.readLine();
			
			Robot robot = new Robot(0,0,0);
			
			int minX = 0;
			int minY = 0;
			int maxX = 0;
			int maxY = 0;
			
			for(int i=0; i<data.length(); i++) {
				char command = data.charAt(i);
				
				if(command == 'F') {
					robot.move();
				}else if(command =='R') {
					robot.turnRight();
				}else if(command == 'L') {
					robot.turnLeft();
				}else if(command =='B') {
					robot.back();
				}
				
				minX = Math.min(robot.x, minX);
				minY = Math.min(robot.y, minY);
				maxX = Math.max(robot.x, maxX);
				maxY = Math.max(robot.y, maxY);
				
			}
			result.append(cal(minX, maxX, minY, maxY)+"\n");
		}
		System.out.println(result);
		
	}
}
