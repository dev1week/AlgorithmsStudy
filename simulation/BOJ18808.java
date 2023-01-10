import java.io.*;
import java.util.*; 


public class BOJ18808 {
    static StringBuilder sb = new StringBuilder(); 
    public static class Sticker{
        public int[][] map; 
        
        public void rotate(){

        }
    }
    static int H;
    static int W; 
    static int numOfSticker; 
    static ArrayList<Sticker> stickerList = new ArrayList<>(); 
    static int[][] notebook;
    
    static boolean isPastable(int currentX, int currentY, Sticker sticker){
        return true; 
    }
    static void paste(int currnetX, int crrentY, Sticker sticker){

    }
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        H = Integer.valueOf(tokens.nextToken());
        W = Integer.valueOf(tokens.nextToken());
        numOfSticker = Integer.valueOf(tokens.nextToken()); 
        notebook = new int[H][W];
        for(int i=0; i<numOfSticker; i++){
            tokens = new StringTokenizer(buffer.readLine());
            Sticker sticker = new Sticker();
            int sH =Integer.valueOf(tokens.nextToken());
            int sW =Integer.valueOf(tokens.nextToken());
            sticker.map = new int[sH][sW];
            for(int sX=0; sX<sH; sX++){
                tokens = new StringTokenizer(buffer.readLine());
                for(int sY=0; sY<sW; sY++){
                    sticker.map[sX][sY] = Integer.valueOf(tokens.nextToken());
                }
            }
            stickerList.add(sticker);
        }
    }   

    static void printSticker(Sticker st){
        sb.append("\n");
        int[][] map = st.map;
        for(int[] ma : map){
            for(int m : ma){
                sb.append(m +" ");
            }sb.append("\n");
        }
    }
    static void printStickerList(){
        for(Sticker st: stickerList){
            printSticker(st);
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        
        System.out.println(sb);
    // for(Sticker sticker : stickerList){
    //     for(int x=0; x<H; x++){
    //         for(int y=0; y<W; y++){
    //             if(isPastable(x, y, sticker)){paste(x,y,sticker);}
    //             else{
    //                 for(int i=0; i<3; i++){
    //                     sticker.rotate();
    //                     if(isPastable(x, y, sticker)){
    //                         paste(x, y, sticker);
    //                         break;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }
    
    //스티커 전체에 대해 조회 
        //왼쪽 위부터 순회 
            //스티커를 붙일 수 있는가? 
                //있다 -> 선택한 위치에 스티커를 붙인다. 
                //없다 -> 90도 180도 270도 회전해가면서 붙일 수 있는가?
                    //있다 -> 붙인다 
                    //없다 -> 버린다. 

    }
    
}
