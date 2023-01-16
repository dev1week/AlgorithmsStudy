public class debug {
    static int sum(int num) {
        int total = 0;
        for (int i = 0; i < num; i++) {
          total += i;
          printTotal(total);
        }
        return total;
      }
      
      static void printTotal(int num) {
       System.out.println(num);
      }
      public static void main(String[] args){
        int result = sum(2);
        System.out.println(result);
      }
      
}
