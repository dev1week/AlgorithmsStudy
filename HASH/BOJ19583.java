import java.util.*;
import java.io.*; 

public class BOJ19583 {
    static StringBuilder sb = new StringBuilder(); 

    static String startEvent;
    static String endEvent;
    static String endStreaming; 

    //출석 인원 <이름, 카운트> 
    static HashSet<String> startList = new HashSet<>();

    //퇴장 인원 <이름, 카운트> 
    static HashSet<String> endList = new HashSet<>(); 
    //전체 참여인원(중복 x) 
    static HashSet<String> totalList = new HashSet<>();

    static void enter(){
        sb.append("\n");
    }



    //입력받은 시각 <= 개강총회 시작 
    static boolean isAttendance(String input){
        StringTokenizer logToken = new StringTokenizer(input,":");
        StringTokenizer startToken = new StringTokenizer(startEvent, ":");
        int logHour = Integer.valueOf(logToken.nextToken());
        int logMin = Integer.valueOf(logToken.nextToken());
        int startHour = Integer.valueOf(startToken.nextToken());
        int startMin = Integer.valueOf(startToken.nextToken());

        //채팅기록 <= 개강총회 시작 
        //채팅기록 시각 > 개강총회 시각 
            //false
        //채팅기록 시각 == 개강총회 시각 
            //채팅기록 분<=개강총회 분 
                //true; 
            //else
                //false 
        //채팅기록 시각 < 개강총회 시각 
            //true 
        if(logHour>startHour){
            return false; 
        }else if( logHour==startHour){
            if(logMin<=startMin){
                return true;
            }else{
                return false; 
            }
        }
        return false;
    }
    //입력 받은 시각=>개강총회 종료시각 
    static boolean isExit1(String input){
        StringTokenizer logToken = new StringTokenizer(input,":");
        StringTokenizer endToken = new StringTokenizer(endEvent, ":");
        int logHour = Integer.valueOf(logToken.nextToken());
        int logMin = Integer.valueOf(logToken.nextToken());
        int endHour = Integer.valueOf(endToken.nextToken());
        int endMin = Integer.valueOf(endToken.nextToken());

        //채팅기록 => 개강총회 시작 
        //채팅기록 시각 < 개강총회 시각 
            //false
        //채팅기록 시각 == 개강총회 시각 
            //채팅기록 분<=개강총회 분 
                //true; 
            //else
                //false 
        //채팅기록 시각 < 개강총회 시각 
            //true 
        if(logHour<endHour){
            return false; 
        }else if( logHour==endHour){
            if(logMin>=endMin){
                return true;
            }else{
                return false; 
            }
        }
        return false;
    }
    //&& 입력받은 시각<=스트리밍 종료시각 
    static boolean isExit2(String input){
        StringTokenizer logToken = new StringTokenizer(input,":");
        StringTokenizer streamingToken = new StringTokenizer(endStreaming, ":");
        int logHour = Integer.valueOf(logToken.nextToken());
        int logMin = Integer.valueOf(logToken.nextToken());
        int streamingHour = Integer.valueOf(streamingToken.nextToken());
        int streamingMin = Integer.valueOf(streamingToken.nextToken());

        //채팅기록 <= 개강총회 시작 
        //채팅기록 시각 > 개강총회 시각 
            //false
        //채팅기록 시각 == 개강총회 시각 
            //채팅기록 분<=개강총회 분 
                //true; 
            //else
                //false 
        //채팅기록 시각 < 개강총회 시각 
            //true 
        if(logHour>streamingHour){
            return false; 
        }else if( logHour==streamingHour){
            if(logMin<=streamingMin){
                return true;
            }else{
                return false; 
            }
        }
        return false;
    }
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        startEvent = tokens.nextToken();
        endEvent = tokens.nextToken();
        endStreaming = tokens.nextToken(); 

        
        String chatLog;
        while((chatLog = buffer.readLine()) != null){
            
            tokens = new StringTokenizer(chatLog);
            String timeLog = tokens.nextToken();
            String name = tokens.nextToken(); 
            sb.append(timeLog + name).append("\n");
            chatLog = buffer.readLine();
        }
    }
    public static void main(String[] args) throws IOException{
        int count =0; 
        init();
        // 줄마다 입력을 받는다. 
            //시각 입력 
            //이름 입력 
            //입력을 HashSet에 넣어준다. 
            //입력 받은 시각<=개강총회 시작 전이거나
                //startList에 넣는다. 
            //입력 받은 시각=>개강총회 종료시각 && 입력받은 시각<=스트리밍 종료시각 
                //end list에 넣는다. 
        // for(String name : totalList){
        //     if(startList.contains(name)&&endList.contains(name)){
        //         count++;
        //     }
        // }
        // sb.append(count);
        //totalList를 순회 
            //출석리스트에 있는가? && 퇴장리스트에있는가? 
                //카운트 1회 
            
        // isFirst("20:30", "21:30");
        System.out.println(sb);
    }
    
}
