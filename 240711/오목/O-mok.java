import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        int[][] map = new int[19][19];

        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        int winner = 0; 
        boolean find = false; 
        int midR = 0; 
        int midC = 0; 

        for(int r=0; r<19; r++){
            for(int c=0; c<19; c++){
                // System.out.printf("map[%d][%d]\n", r, c);
                if(map[r][c] == 0) continue;
                if(find){
                    System.out.printf("%d\n%d %d", winner, midR, midC);
                    return;
                }

                int cur = map[r][c];
                // System.out.printf("시작 map[%d][%d] = %d\n", r, c, map[r][c]);

                for(int d =0; d<8; d++){
                    // System.out.printf("방향 : %d\n", d);
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    int cnt = 1;
                    while(check(nr, nc) && map[nr][nc] == cur){
                        cnt++;
                        
                        if(cnt >= 5) {
                            // System.out.printf("오목 map[%d][%d] = %d 방향(%d), cur:%d\n", r, c, map[r][c], d, cur);
                            winner = cur; 
                            find = true;
                            int reverseR = (dr[d] == 0) ? 0 : (dr[d] == 1)? -1 : 1;
                            int reverseC = (dc[d] == 0) ? 0 : (dc[d] == 1)? -1 : 1; 
                            // System.out.printf("nr(%d) nc(%d) dr(%d) reverseR(%d) dc(%d) reverseC(%d)\n", nr, nc, dr[d], reverseR, dc[d], reverseC);
                            midR = nr + reverseR * 2 + 1;
                            midC = nc + reverseC * 2 + 1; 
                            break;
                        }

                        nr = nr + dr[d];
                        nc = nc + dc[d];
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