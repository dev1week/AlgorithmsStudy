import java.io.*;
import java.util.*; 
public class test {
    
    static class Student implements Comparable<Student>{

        public int kor;
        public int eng;
        public int math; 
        public String name;

        @Override
        public int compareTo(Student other){
            if(kor!=other.kor){
                return other.kor-kor;
            }
            else if(eng!=other.eng){
                return eng-other.eng;
            }
            else if(math!=other.math){
                return other.math - math;
            }
            else{
                return name.compareTo(other.name);
            }
        }
    }
    static Student[] list;
    static int N; 
    static Scanner sc = new Scanner(System.in);
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        list = new Student[N];
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(buffer.readLine());

            list[i] = new Student();
            list[i].name = tokens.nextToken();
            list[i].kor = Integer.valueOf(tokens.nextToken());
            list[i].eng =Integer.valueOf(tokens.nextToken());
            list[i].math =Integer.valueOf(tokens.nextToken());
        }
    }
    public static void main(String[] args) throws IOException{
        init(); 
        Arrays.sort(list);
        for(Student s : list){
            System.out.print(s.name);
        }
    }
    
}
