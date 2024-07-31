import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], count; 
    static boolean[][] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); 

        map = new int[N][N];
        v = new boolean[N][N];
         
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int bombCnt = 0; 
        int maxBlockCnt = 0; 

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(v[r][c]) continue; 

                count = 1;
                v[r][c] = true; 
                dfs(r, c, map[r][c]);  
                
                // System.out.printf("%d %d -> %d\n", r, c, count); 
                if(count >= 4) bombCnt++;
                maxBlockCnt = Math.max(maxBlockCnt, count);
                   
            }
        }
        
        System.out.println(bombCnt + " " +maxBlockCnt); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    public static void dfs(int r, int c, int num){
        
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            if(v[nr][nc]) continue; 
            if(map[nr][nc] != num) continue; 

            count++; 
            v[nr][nc] = true;
            dfs(nr, nc, num); 
        }
    }
}