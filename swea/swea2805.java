import java.util.*;
class swea2805
{
    static int[][] map; //
    static int n; //1~49
    static int T; // 테스트 케이스 갯수 
     
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        //입력부 
        T=sc.nextInt();
        for(int t=0; t<T; t++){
            n = sc.nextInt();
            map = new int[n][n]; 
            for(int x=0; x< n; x++){
                String data = sc.next();
                for(int y=0; y<n; y++){
                    map[x][y] = Integer.valueOf(data.charAt(y)-'0');
                }
            }
 
            //맵의 중심점 찾기 
            int centerX = n/2;
            int centerY = n/2; 
            int size = n/2; 
            
            
            int result = map[centerX][centerY]; 

            //중심점을 기점으로 마름모 모양으로 탐색하기 
            //49*49 칸내 마름모 모양만 완전탐색하므로 시간복잡도 1억 안으로 들어온다. 
            for(int l=1; l<=size; l++){
                int cX = centerX + l; 
                int cY = centerY; 
                for(int dir=0; dir<4; dir++){
                    for(int i=1; i<=l; i++){
                        cX += dx[dir];
                        cY += dy[dir];
                        //System.out.println(cX+" "+cY);
                        result += map[cX][cY];
                    }   
                }
            }
            System.out.println("#"+(t+1)+" "+result);
        }
    }
 
    static int[] dx = {-1,-1,1,1};
    static int[] dy = {1,-1,-1,1};
}