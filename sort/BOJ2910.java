import java.io.*;
import java.util.*; 

public class BOJ2910 {
    static int num;
    static int limit; 

    class Counter implements Comparable<Counter>{
        private int number;
        private int count;

        Counter(int number, int count){
            this.number = number;
            this.count = count; 
        }

        public void setCount(int data){
            this.count = data; 
        }

        public void setNumber(int data){
            this.number = data; 
        }

        public int getNumber(){
            return this.number; 
        }

        public int getCount(){
            return this.count;
        }

        
        @Override
        public int compareTo(Counter other){
            return this.count - other.count;
        }
    }

    static Counter[] list;
    static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args){

    }
    
}
