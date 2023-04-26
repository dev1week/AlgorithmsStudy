import java.util.*; 

public class BOJ1593 {
    static int wlen; 
    static int slen; 

    static String W;
    static String S;
    static char[] se;

    static HashSet<String> answer = new HashSet<>();
    static ArrayList<Integer> selecteds = new ArrayList<>(); 
    static boolean[] isUsed;

    static String makeWord(){
        String result = "";

        for(int i : selecteds){
            result +=se[i];
        }
        return result;
    }
    static int count = 0;

    static void bt(int cur){
        if(cur==wlen+1){
            String word = makeWord();
            
            if(answer.contains((word))){
                System.out.println(word);
                count++;
            }
            return;
        }

        for(int i=1; i<=slen; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true; 
            selecteds.add(i);
            bt(cur+1);
            selecteds.remove(selecteds.size()-1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        wlen = sc.nextInt();
        slen = sc.nextInt();

        se = new char[slen+1];

        W = sc.next();

        S = sc.next();

        for(int i=1; i<=S.length(); i++){
            se[i] = S.charAt(i-1);
        }

        answer.add(W);

        isUsed = new boolean[slen+1];
        //S 중에서 w개수 만큼 뽑기 
        bt(1);

        System.out.println(count);

    }
    
}
