import java.util.Arrays;
import java.util.Scanner;

public class BOJ10825 {
    static int N; 
    static Student[] list; 
    static Scanner sc = new Scanner(System.in);
    static class Student implements Comparable<Student>{
        public int kor;
        public int math;
        public int eng;
        public String name;


        @Override 
        public int compareTo(Student other){
            if(kor != other.kor)return other.kor - kor;
            if(eng != other.eng)return eng - other.eng;
            if(math != other.math)return other.math - math;
            return name.compareTo(other.name);
        }
    }
    static void input(){
        N = sc.nextInt();
        list = new Student[N];
        for(int i=0; i<N; i++){
            list[i] = new Student();
            list[i].name = sc.next();
            list[i].kor = sc.nextInt();
            list[i].eng = sc.nextInt();
            list[i].math = sc.nextInt();
        }
    }
    public static void main(String[] args){
        input();
        Arrays.sort(list);
        for(int i=0; i<list.length; i++){
            System.out.println(list[i].name);
        }
    }
    
}
