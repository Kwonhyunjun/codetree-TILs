import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][];
    static boolean canEscape; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        
        map = new int[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()); 
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }

        canEscape = false; 
        dfs(0, 0); 

        int answer = (canEscape) ? 1 : 0;
        System.out.println(answer);
    }

    static int[] dr = {0, 1};
    static int[] dc = {1, 0}; 
    public static void dfs(int r, int c){
        if(canEscape) return; 
        
        if(r == N-1 && c == M-1){
            canEscape = true;
            return; 
        }

        for(int d = 0; d < 2; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
            if(map[nr][nc] != 1) continue; 

            dfs(nr, nc); 
        }
    }
}