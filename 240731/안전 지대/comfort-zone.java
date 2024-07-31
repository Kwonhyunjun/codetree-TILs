import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer[], map[][], maxHeight; 
    static boolean[][] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; 
        v = new boolean[N][M];
        answer = new int[2];  

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()); 
            for(int c=0; c<M; c++){
                int n = Integer.parseInt(st.nextToken()); 
                map[r][c] = n;
                maxHeight = Math.max(maxHeight, n); 
            } 
        }

        // 안전지대 찾기
        int safeZone = 0; 
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c] <= 1) continue; // 물에 잠겨있다면
                if(v[r][c]) continue; // 이미 방문했다면
                safeZone++;
                dfs(r, c, 1); 
            }
        }

        // 안전지대 갱신
        answer[0] = 1;
        answer[1] = safeZone; 

        for(int i=2; i<maxHeight; i++){ // 빗물양
            // 방문배열 초기화
            for(int r=0; r<N; r++){
                Arrays.fill(v[r], false); 
            }

            // 안전지대 찾기
            safeZone = 0; 
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(map[r][c] <= i) continue; // 물에 잠겨있다면
                    if(v[r][c]) continue; // 이미 방문했다면
                    safeZone++;
                    dfs(r, c, i); 
                }
            }

            // 안전지대 갱신
            if(answer[1] < safeZone){
                answer[0] = i;
                answer[1] = safeZone; 

            }
        }

        System.out.println(answer[0] + " " + answer[1]); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    public static void dfs(int r, int c, int rain){
        
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
            if(map[nr][nc] <= rain) continue; 
            if(v[nr][nc]) continue; 

            v[nr][nc] = true; 
            dfs(nr, nc, rain); 
        }
    }

}