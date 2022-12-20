import java.io.*;
import java.util.*;

public class test {

    static Set people2 = new TreeSet();
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        int numPeople = Integer.valueOf(tokens.nextToken());
        for(int i=0; i<numPeople; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int name = Integer.valueOf(tokens.nextToken());
            people2.add(name);
        }
        System.out.println(people2);
}
}
