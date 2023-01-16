import java.nio.BufferOverflowException;

import java.io.*;
import java.util.*; 

public class BOJ1991{
    static int[] lc;
    static int[] rc; 
    static int N; 
    static StringBuilder sb = new StringBuilder(); 

    static void DFS1(int current){
        char data = (char) (current +'A');
        sb.append(data);
        if(lc[current]!=-1){DFS1(lc[current]);}
        if(rc[current]!=-1){DFS1(rc[current]);}
    }
    static void DFS2(int current){
        if(lc[current]!=-1){DFS2(lc[current]);}
        char data = (char) (current +'A');
        sb.append(data);
        if(rc[current]!=-1){DFS2(rc[current]);}
    }
    static void DFS3(int current){
        if(lc[current]!=-1){DFS3(lc[current]);}
        if(rc[current]!=-1){DFS3(rc[current]);}
        char data = (char) (current +'A');
        sb.append(data);
    }


    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        N = Integer.valueOf(tokens.nextToken());
        lc = new int[N];
        rc = new int[N];
        for(int i=0; i< N; i++){
            tokens = new StringTokenizer(buffer.readLine());
            char current = tokens.nextToken().charAt(0);
            char left = tokens.nextToken().charAt(0);
            char right = tokens.nextToken().charAt(0);
            int currentIdx= Integer.valueOf(current-'A');
            int leftIdx = Integer.valueOf(left-'A');
            int rightIdx = Integer.valueOf(right-'A');
            if(left =='.') leftIdx =-1; 
            if(right=='.') rightIdx = -1; 
            lc[currentIdx] = leftIdx; 
            rc[currentIdx] = rightIdx;
        }
    }
    static void printArr(int[] arr){
        sb.append("\n");
        for(int a: arr){
            sb.append(a+" ");
        }sb.append("\n");
    }
    public static void main(String[] args) throws IOException{
        init(); 
        DFS1(0);
        sb.append("\n");
        DFS2(0);
        sb.append("\n");
        DFS3(0);
        sb.append("\n");
        System.out.println(sb);

    }
}