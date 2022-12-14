import java.io.*;

import java.util.*;

class Descending implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2; 

            return c2.compareTo(c1);
        }
        return -1; 
    }
}

public class BOJ7785 {
    static final int S = 5;
    static HashSet people = new HashSet(); 
    static Queue people2 = new PriorityQueue((o1, o2) ->{
        Comparable c1 = (Comparable) o1;
        Comparable c2 = (Comparable) o2; 
        return c2.compareTo(c1);
    });
    public static void findPeople(String name, String action){
        if(action.equals("enter")){
            people.add(name);
            people2.add(name);
        }else if(action.equals("leave")){
            people.remove(name);
            people2.remove(name);
        }
    }

    public static List sortingPeople(){
        List peopleList = new ArrayList(people);
        Collections.sort(peopleList, new Descending());
        return peopleList; 
    }
    
    public static void printPeopleQue(){
        Iterator peopleIterator = people2.iterator();
        while(peopleIterator.hasNext()){
            System.out.println(peopleIterator.next());
        }
    }
    public static void printPeople(){
        List peopleSortedList = sortingPeople();
        Iterator peopleIterator = peopleSortedList.iterator(); 
        while(peopleIterator.hasNext()){
            System.out.println(String.valueOf(peopleIterator.next()));
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
        printPeople(); 
        printPeopleQue(); 

//????????????
//1. ?????? ????????? ???????????? ?????????. 
//2. ??????????????? ?????? ???????????? ?????? ????????????. 
//3. ???????????? ????????????. 

        //??????
        //????????????
        //?????? ?????? ????????? ?????? 
            //???????????? ?????? 
            //???????????? ??????
            //???????????? == enter
                // hashmap??? ??????
            //???????????? == leave
                // hashmap?????? ?????? ?????? 
        //????????????????????? ????????? ???????????? ?????? 
        //????????????.??????(??????????????????, ??????) 
        //hashmap ??????????????? ???????????? 
        //hashmap ???????????? ?????? 
            //???????????????.next(); 
    }

}

