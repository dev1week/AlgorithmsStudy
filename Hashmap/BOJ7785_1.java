import java.io.*;

import java.util.*;

public class BOJ7785_1 {

    static Set people2 = new TreeSet((o1, o2) ->{
        Comparable c1 = (Comparable) o1;
        Comparable c2 = (Comparable) o2;
        return c2.compareTo(c1);
    });

    public static void findPeople(String name, String action){
        if(action.equals("enter")){
            people2.add(name);
        }else if(action.equals("leave")){
            people2.remove(name);
        }
    }

    public static void printPeopleQue(){
        Iterator it = people2.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        int numPeople = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<numPeople; i++){
            tokens = new StringTokenizer(buffer.readLine());
            String name = String.valueOf(tokens.nextToken());
            String action = String.valueOf(tokens.nextToken());
            findPeople(name, action);
        }
        printPeopleQue(); 

//제한사항
//1. 같은 입력은 주어지지 않는다. 
//2. 대소문자가 다른 경우에는 다른 이름이다. 
//3. 역순으로 출력한다. 

        //로직
        //입력받기
        //입력 받은 횟수에 대해 
            //첫번째값 입력 
            //두번째값 입력
            //두번째값 == enter
                // hashmap에 넣기
            //두번째값 == leave
                // hashmap에서 찾아 빼기 
        //정렬해야하므로 링크드 리스트로 변환 
        //콜렉션즈.정렬(링크드리스트, 역순) 
        //hashmap 이터레이터 가져오기 
        //hashmap 길이만큼 반복 
            //이터레이터.next(); 
    }

}

