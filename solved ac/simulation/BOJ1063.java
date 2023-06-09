package simulation;
import java.util.*;
import java.io.*;


public class BOJ1063 {
	
					// r l  b t 
	static int dx[] = {1,-1,0,0,1,-1,1,-1};
	static int dy[] = {0,0,-1,1,1,1,-1,-1};
	
	static HashMap<String, Integer> convert = new HashMap<>();
	static int n; 
	static King king;
	static Stone stone;
	
	static void init() throws IOException {
		convert.put("R", 0);
		convert.put("L", 1);
		convert.put("B", 2);
		convert.put("T", 3);
		convert.put("RT", 4);
		convert.put("LT", 5);
		convert.put("RB", 6);
		convert.put("LB", 7);
		
		StringTokenizer tokens = new StringTokenizer(buffer.readLine());
		
		String kingPos = tokens.nextToken(); 
		String stonePos = tokens.nextToken();
		n = Integer.valueOf(tokens.nextToken());
		
		king = new King(Integer.valueOf(kingPos.charAt(0)-'A'), Integer.valueOf(kingPos.charAt(1)-'0'));
		stone = new Stone(Integer.valueOf(stonePos.charAt(0)-'A'), Integer.valueOf(stonePos.charAt(1)-'0'));
	}
	
	
	
	static class King{
		int x;
		int y;
		
		public King(int x, int y) {
			this.x = x;
			this.y = y; 
		}
		
		public void move(int nX, int nY) {
			this.x = nX;
			this.y = nY;
		}
		
		public String toString() {
			return Character.toString(this.x+'A')+this.y;
		}
		
	}


	static class Stone{
		int x;
		int y; 
		
		public Stone(int x, int y) {
			this.x= x;
			this.y = y;
		}
		public void move(int nX, int nY) {
			this.x = nX;
			this.y = nY;
		}
		
		public String toString() {
			
			return Character.toString(this.x+'A')+this.y; 
			
		}
		
	}
	
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	static final int SIZE = 8; 
	
	
	
	public static void main(String[] args) throws IOException{
		init();
		
		for(int i=0; i<n; i++) {
			String command = buffer.readLine();
			int kingNx = king.x+dx[convert.get(command)]; 
			int kingNy = king.y+dy[convert.get(command)];
			int stoneNx = stone.x;
			int stoneNy = stone.y;
			if(stone.x==kingNx&&stone.y==kingNy) {
				stoneNx +=dx[convert.get(command)];
				stoneNy +=dy[convert.get(command)];
			}
			
			
			if(isValid(kingNx, kingNy)&&isValid(stoneNx, stoneNy)) {
				king.move(kingNx, kingNy);
				stone.move(stoneNx, stoneNy);
			}
			
			//명령어 입력 
			//왕의 예상위치 계산 
			//해당 예상위치에 돌이 있는가?
				//있으면 돌을 옮긴다. 
			//예상 돌의위치와 예상 왕의 위치가 전부 유효한 경우에만 클래스에 반영한다. 
			
			
		}
		System.out.println(king);
		System.out.println(stone);
	}
	static boolean isValid(int x, int y) {
		return x>=0&&x<SIZE&&y>0&&y<=SIZE;
	}
	

}
