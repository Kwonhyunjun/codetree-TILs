import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[19][19];

        for(int i=0; i<19; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        int winner = 0; 
        boolean find = false; 
        int midR = 0; 
        int midC = 0; 

        for(int r=0; r<19; r++){
            for(int c=0; c<19; c++){
                System.out.printf("시작 map[%d][%d]\n", r, c);
                if(map[r][c] == '0') continue;
                if(find){
                    System.out.printf("%d \n %d %d", winner-48, midR, midC);
                    return;
                }

                char cur = map[r][c];
                System.out.printf("시작 map[%d][%d] = %c\n", r, c, cur);

                for(int d =0; d<8; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    int cnt = 1;
                    while(check(nr, nc) && map[nr][nc] == cur){
                        cnt++;
                        
                        if(cnt >= 5) {
                            winner = cur-48; 
                            find = true; 
                            break;
                        }

                        nr = r + dr[d];
                        nc = c + dc[d];
                    }

                    if(find){
                        int reverseR = (dr[d] == 0) ? 0 : (dr[d] == 1)? -1 : 1;
                        int reverseC = (dc[d] == 0) ? 0 : (dc[d] == 1)? -1 : 1; 
                        midR = nr - reverseR * 2;
                        midC = nc - reverseC * 2; 
                    }
                }

            }
        }
    }

    static boolean check(int r, int c){
        if(r < 0 || c < 0 || r >= 19 || c >= 19){
            return false; 
        }
        return true;
    }
}