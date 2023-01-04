import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class recursion {
    static long func1(int a, int b, int m){
        long value =1; 
        while(b>0){
            value= value*a%m;
            b--; 
        }return value; 
    }

    static long func2(long a, long b, long m){
        //base condition 
        if(b==1)return a%m;
        // a^b/2 mod m 계산 
        long value = func2(a,b/2,m) ;
        value = value*value%m; 
        if(b%2==0) return value;
        ///b가 홀수일 때 val에 a를 한번더 곱해야함 
        //b가 7이면 b/2는 3이니 a^6 mod m의 값이 들어감 
        return value * a % m; 
    }
    static int fibo(int n){
        if(n==1){return 1;}
        if(n==0){return 0;}
        return fibo(n-2)+fibo(n-1);
    }

    static void hanoi(int start, int end, int numOfPlate){
        if(numOfPlate==1){System.out.println(numOfPlate+"가 "+start+"에서 "+end+"로 이동한다."); return;}
        hanoi(start, 6-start-end, numOfPlate-1);
        System.out.println(numOfPlate+"가 "+start+"에서 "+end+"로 이동한다.");
        hanoi(6-start-end, end, numOfPlate-1);
    }

    static int z (int n, int r, int c){
        if(n<=0)return 0; 
        int half =  (int) Math.pow(2,n-1);
        System.out.println(half);
        if(r<half || c< half) return z(n-1, r,c);
        if(r<half||c>=half) return half*half+z(n-1,r,c-half);
        if(r>=half||c<half) return 2*half*half+z(n-1,r-half,c);
        //if(r>=half||c>=half)추가하면 일반적인 조건에서의return 문이 나오지 않아 컴파일러 인식불가능 
        return 3*half*half +z(n-1, r-half, c-half);
    }
    public static void main(String[] args) throws IOException{
        // BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        // int a = Integer.valueOf(tokens.nextToken());
        // int b = Integer.valueOf(tokens.nextToken());
        // int m = Integer.valueOf(tokens.nextToken());
        
        System.out.println(z(3,7,7)); 

    }
    
}
