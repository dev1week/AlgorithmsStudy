import java.util.*;



class Number implements Comparable<Number>{
    private String foreign;
    private int num;
    
    //행성의 숫자로 객체를 생성하면 생성자에서 자동으로 우리가 사용하는 숫자 체계로 바꾼다.
    public Number(String foreign) {
        this.foreign = foreign; 
         
        if(foreign.equals("ZRO")) {
            this.num = 0;
        }else if(foreign.equals("ONE")) {
            this.num = 1;
        }else if(foreign.equals("TWO")) {
            this.num = 2;
        }else if(foreign.equals("THR")) {
            this.num = 3;
        }else if(foreign.equals("FOR")) {
            this.num = 4;
        }else if(foreign.equals("FIV")) {
            this.num = 5;
        }else if(foreign.equals("SIX")) {
            this.num = 6;
        }else if(foreign.equals("SVN")) {
            this.num = 7;
        }else if(foreign.equals("EGT")) {
            this.num = 8;
        }else if(foreign.equals("NIN")) {
            this.num = 9;
        }
    }

    //comparable 인터페이스를 구현하여 객체 끼리의 비교기준을 만들어준다.      
    public int compareTo(Number n2) {
        return this.num - n2.num;
    }
     
    public String toString() {
        return this.foreign;
    }
     
}
 
class swea1221
{   
 
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
         
        int t = sc.nextInt();
        for(int testCase=1; testCase<=t; testCase++) {
            ArrayList<Number> answer = new ArrayList<>();
            
            //입력부
            String dummy = sc.next(); 
            int dataLength = sc.nextInt(); 

            //입력을 받을 때마다 Number 객체를 만들어 Number 객체 동적 배열을 만들어준다.
            for(int i=0; i<dataLength; i++) {
                String data = sc.next(); 
                answer.add(new Number(data));
            }

            //Number 객체를 우리 숫자 체계로 비교해준다. 
            Collections.sort(answer);
            
            
            //iterator 출력 
            System.out.println("#"+testCase);
            Iterator it = answer.iterator();
            while(it.hasNext()) {
                System.out.print(it.next()+" ");
            }
        }
 
    }
}