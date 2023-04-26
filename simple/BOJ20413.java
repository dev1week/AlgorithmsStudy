import java.util.*; 

public class BOJ20413{
    //등급 5종류 
        // b s g p d 
    //현재달 + 지난 달 과금액으로 결정 
    //한달에 최대 d 등급 기준액까지만 과금
    //1만원 단위로만 과금 


    static int n; // 게임을 플레이한 개월 수 n 
    static HashMap<Character ,Integer> limit = new HashMap<>();

    static char[] log; 
    static int[] pay;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        limit.put('B', sc.nextInt()-1);
        limit.put('S', sc.nextInt()-1);
        limit.put('G', sc.nextInt()-1);
        limit.put('P', sc.nextInt()-1);
        limit.put('D', limit.get('P')+1);

        log = new char[n];
        pay = new int[n];
        
        String logData = sc.next();
        for(int i=0; i<n; i++){
            log[i] = logData.charAt(i);
        }

        pay[0] = limit.get(log[0]);
        for(int i=1; i<n; i++){
            int beforePay = pay[i-1];
            int currentTarget = limit.get(log[i]);
            int currentPay = currentTarget- beforePay; 
            if(log[i]=='D'){
                currentPay = limit.get('D');
            }
            pay[i] = currentPay; 
        }
        int result = 0;
        for(int p : pay){
            result += p;
            
        }

        System.out.println(result);

    }
}
