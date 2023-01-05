import java.io.*;
import java.util.*; 



public class BOJ188088 {
    public static class Sticker{
        public int[][] map; 

        public void Rotate(){
            int[][] tmp=  new int [12][12];
            int orginalH =this.map.length;
            int orginalW = this.map[0].length;
            int newW = this.map.length;
            int newH = this.map[0].length;
            for(int x=0; x<this.map.length;x++){
                for(int y=0; y<this.map[x].length; y++){
                    tmp[x][y] = this.map[x][y];
                }
            }
            this.map = new int[newH][newW];
            for(int x=0; x<newH; x++){
                for(int y=0; y<newW; y++){
                    this.map[x][y] = tmp[orginalH-1-y][x];
                }
            }

        }
    }
    static int[][] noteBook;
    static int H; 
    static int W; 
    static int numOfSticker; 
    static StringBuilder sb = new StringBuilder(); 
    static Sticker[] stickerList; 
    //주어진 좌표가 유효한 좌표인지 확인함 
    static boolean isOut(int x, int y){
        return x<0||y<0||x>=H||y>=W;
    }
    
    //현재 위치에서 스티커를 붙일 수 있는지 확인 
    static boolean isPastable(int x, int y, int[][] sticker){
        for(int dx=0; dx<sticker.length; dx++){
            for(int dy=0; dy<sticker[dx].length; dy++){
                int nextX = x+ dx;
                int nextY = y + dy;
                if(isOut(nextX, nextY))continue; 
                System.out.println(nextX+" "+nextY+" "+dx+" "+dy);
                if(noteBook[nextX][nextY]==1&&sticker[dx][dy]==1){return false;}
            }
        }
        return true; 
    }
    //현재 위치 x, y 에 스티커를 붙인다. 
    static void paste(int x, int y, int[][] sticker){
        for(int dx=0; dx<sticker.length; dx++){
            for(int dy=0; dy<sticker[dx].length; dy++){
                int nextX = x+ dx;
                int nextY = y + dy;
                if(isOut(nextX, nextY))continue; 
                if(noteBook[nextX][nextY]==0&&sticker[dx][dy]==1){
                    //붙인다
                    noteBook[nextX][nextY]=1; 
                }
            }
        }
    }

    //데이터 입력 받기 
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());
        W = Integer.valueOf(tokens.nextToken());
        H = Integer.valueOf(tokens.nextToken());
        numOfSticker = Integer.valueOf(tokens.nextToken());
        noteBook = new int[H][W];
        stickerList= new Sticker[numOfSticker];
        for(int i=0; i<numOfSticker; i++){
            tokens = new StringTokenizer(buffer.readLine());
            int stickerH= Integer.valueOf(tokens.nextToken());
            int stickerW = Integer.valueOf(tokens.nextToken());
            stickerList[i] = new Sticker(); 
            Sticker sticker = stickerList[i];
            sticker.map = new int[stickerH][stickerW];
            //스티커 만들기 + 추가하기
            for(int x=0;x<stickerH; x++){
                tokens = new StringTokenizer(buffer.readLine());
                for(int y=0; y<stickerW; y++){
                    sticker.map[x][y] = Integer.valueOf(tokens.nextToken());
                }
            }
        }
    }
    
    //2차원 배열 출력 
    static void print2D(int[][] arr){
        for(int[] ar: arr){
            for(int a : ar){
                sb.append(a).append(" ");
            }sb.append("\n");
        }
    }

    //sticker list 출력 
    static void printStickers(Sticker[] stickerList){
        for(Sticker sticker : stickerList){
            print2D(sticker.map); 
            sb.append("\n").append("\n");
        }

    }
    public static void main(String[]args) throws IOException{
        init();
        for(Sticker sticker : stickerList){
            sb.append("회전 전\n");
            print2D(sticker.map);
            sb.append("회전 후\n");
            sticker.Rotate();
            print2D(sticker.map);
            // for(int currentX=0; currentX<H; currentX++){
            //     for(int currentY=0; currentY<W; currentY++){
            //         while(isPastable(currentX, currentY, sticker.map)){
            //             //0~270까지 돌린다. 
                            
            //         }
            //     }
            // }
        }
        
        System.out.println(sb);
    }
    
}
