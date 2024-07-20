import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        StringBuilder sb = new StringBuilder(); 

        while(true){
            // 방향 정하기
            int num = map[r][c]; 
            sb.append(num).append(" "); 
            int nd = -1; 
            // System.out.printf("r: %d, c : %d\n", r, c); 
            for(int d=0;d<4;d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                // System.out.printf("nr: %d, nc : %d\n", nr, nc); 

                if(nr < 0 || nc < 0 || nr >=N || nc >=N) continue; 
                if(map[nr][nc] > num){
                    num = map[nr][nc];
                    // System.out.printf("이동 %d, %d방향\n", num, nd); 
                    nd = d; 
                    break;
                }
            }
            if(nd == -1){
                break; 
            }
            // 이동
            r += dr[nd];
            c += dc[nd];
        }

        System.out.println(sb); 
        
    }
}