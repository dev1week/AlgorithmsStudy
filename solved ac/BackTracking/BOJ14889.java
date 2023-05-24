package BackTracking;

import java.util.*;

public class BOJ14889 {
static Scanner sc = new Scanner(System.in); 
	
	static int[][] w;
	static boolean[] isUsed; 
	static int n; 
	
	static int result;
	
	static void init() {
		n = sc.nextInt(); 
		
		w = new int[n][n]; 
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				w[x][y] = sc.nextInt();
				
			}
		}
		isUsed= new boolean[n];
		result = Integer.MAX_VALUE; 
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();
	}
	
	static ArrayList<Integer> teamA;
	static ArrayList<Integer> teamB; 
	
	static int getTeamScore(ArrayList<Integer> team) {
		int sum = 0;
		
		for(int i=1; i<n/2; i++) {
			
			sum += (w[team.get(i)][team.get(i-1)]+w[team.get(i-1)][team.get(i)]);
		}
		
		if(team.size()>2) {
			sum+= (w[team.get(0)][team.get(team.size()-1)]+w[team.get(team.size()-1)][team.get(0)]); 
		}
		return sum; 
	}
	
	static void makeTeamB() {
		for(int i=0; i<n; i++) {
			if(isUsed[i])continue; 
			else {
				teamB.add(i);
			}
		}
	}
	
	static void bt(int cur, int last) {
		if(cur==n/2+1) {
			teamB = new ArrayList<>();
			
			
			makeTeamB();
			System.out.println(teamA);
			System.out.println(teamB);
			int teamAScore = getTeamScore(teamA); 
			int teamBScore = getTeamScore(teamB); 
			
			result = Math.min(result, Math.abs(teamBScore-teamAScore));
			System.out.println(result);
			//팀 a의 스코어 계산 
			//팀 b의 스코어 계산 
			return;
		}
		
		for(int next=last+1; next<n; next++) {
			 if(isUsed[next])continue;
			 isUsed[next] = true;
			 teamA.add(next);
			 bt(cur+1, next);
			 teamA.remove(teamA.size()-1);
			 isUsed[next] = false; 
		}
	}
	
	public static void main(String[] args) {
		init();
		bt(1,-1);
		System.out.println(result);
		//bt로 경로 정하기 n개 n개 뽑기 
			
	}
}
