package simulation;

import java.util.*;
public class BOJ1244 {
	
	static Scanner sc = new Scanner(System.in); 
	
	static final int MALE =1;
	static final int FEMALE = 2; 
	
	static boolean inRange(int pos) {
		return	pos>=1&&pos<=n;
	}
	
	static void changeFemale(int center) {
		//자기가 받은 수의 스위치를 중심, 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아 바꿈
		//항상 홀수개임 
		int point1  = center +1;
		int point2 = center -1; 
		
		while(inRange(point1)&&inRange(point2)) {
			if(isTurnOn[point1]!=isTurnOn[point2]) break;
			point1++;
			point2--; 
		}
		//point1과 point2가 유효할 때까지만 
			//다른가? 
				//break; 
			//point1++;
			//point2--;
		
		//point-1 ~ point2+1 까지 구간 전부 바꾸기 
		
		for(int change=point2+1; change<=point1+-1; change++) {
			isTurnOn[change] = !isTurnOn[change];
		}
		
	}
	static void changeMale(int pos) {
		int curPos = pos;
		while(inRange(curPos)) {
			isTurnOn[curPos] = !isTurnOn[curPos];
			curPos+=pos;
		}
	}
	
	static void process(int gender, int pos) {
		if(gender == MALE) {
			changeMale(pos);
		}else if(gender==FEMALE){
			changeFemale(pos);
		}
	}
	
	//남학생 
		//스위치 번호 == 자기 받은 수의 배수 
			//상태를 바꾼다. 
	//여학생 
		//자기가 받은 수의 스위치를 중심, 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아 바꿈
		//항상 홀수개임 
	
	static int n; 
	static boolean[] isTurnOn; 
	
	static void init() {
		n = sc.nextInt();
		isTurnOn = new boolean[n+1]; 
		
		for(int i=1; i<=n; i++) {
			if( sc.nextInt()==1) {
				isTurnOn[i] = true;
			};
		}
	}
	
	static void print() {
		
		for(int i=1; i<=n; i++) {
			if(isTurnOn[i]) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
			if(i%20==0) {
				System.out.println();
			}
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		init(); 
		
		
		int commandNum = sc.nextInt();
		for(int i=0; i<commandNum; i++) {
			int gender = sc.nextInt(); 
			int pos = sc.nextInt();
			
			
			process(gender, pos);
			
		}
		print();
	}

}
