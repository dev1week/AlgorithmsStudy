package simulation;
import java.util.*;
class BOJ8896{
    static Scanner sc = new Scanner(System.in);

    static int k; // 라운드 수  
    //각 로봇이 가진 문자열의 길이 
    //라운드에서 패배할 경우 다음 라운드 참가 불가능 
    //로봇이 하나 남을 때까지 진행한다. 
    //k라운드가 지난 후에 로봇이 2개 이상이라면 무승부임 

    //가위는 S, 바위는 R 보는 P 

    static int T; // 테스트 개수 
    static int n; //로봇의 개수 

    static String[] robots;
    static HashSet<Integer> survivals;
    
    static HashSet<Integer> rPlayers; 
    static HashSet<Integer> sPlayers;
    static HashSet<Integer> pPlayers;

    static void init(){
        n = sc.nextInt(); 
        survivals = new HashSet<>();
        robots = new String[n+1]; 
        for(int i=1; i<=n; i++){
            robots[i] = sc.next();
            survivals.add(i);
        }
        k = robots[1].length();
    }
    static void remove(HashSet<Integer> players) {
    	for(int player : players) {
    		if(survivals.contains(player)) {
    			survivals.remove(player);
    		}
    		
    	}
    }
    static void judge() {
        
        //가위가 이겼을 때 
        if(sPlayers.size()!=0&&pPlayers.size()!=0&&rPlayers.size()==0) {
        	remove(pPlayers);
        	
        }//주먹이 이겼을 때 
        else if(rPlayers.size()!=0&&sPlayers.size()!=0&pPlayers.size()==0) {
        	remove(sPlayers);
        }//보자기가 이겼을 때 
        else if(pPlayers.size()!=0&&rPlayers.size()!=0&&sPlayers.size()==0) {
        	remove(rPlayers);
        }

    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder(); 
        T = sc.nextInt();
        for(int i=0; i<T; i++){
            init(); 
            
            
            for(int round=0; round<k; round++){
            	
                rPlayers = new HashSet<>(); 
                sPlayers =  new HashSet<>();
                pPlayers = new HashSet<>();

                
                for(int robot : survivals){
                    if(robots[robot].charAt(round)=='R'){
                        rPlayers.add(robot);
                    }else if(robots[robot].charAt(round)=='P'){
                        pPlayers.add(robot);
                    }
                    else if(robots[robot].charAt(round)=='S'){
                        sPlayers.add(robot);
                    }
                }
                
                judge();
            }
            if(survivals.size()==1) {
            	for(int survival : survivals) {
            		System.out.println(survival);
            	}
            }else {
            	System.out.println(0);
            }
            
        }
        
        
        //라운드 순회 
            //로봇이 가진 문자열 순회 
                //가위바위보 판단 
                    //가위 가지고 있음
                    //보 가지고 있음 
                    //주먹 가지고 있음 
                //해쉬셋 길이로 승패 판단하기 
                    //진쪽의 리스트를 바탕으로 survival 해쉬셋 조정하기  

    }
}