import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][], answer; 
    static boolean[][] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        M = Integer.parseInt(st.nextToken()); // 시작점의 수

        map = new int[N][N]; 
        v = new boolean[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()); 
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 

            int r = Integer.parseInt(st.nextToken())-1; 
            int c = Integer.parseInt(st.nextToken())-1; 

            if(v[r][c]) continue; 
            bfs(r, c);
        }

        System.out.println(answer); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static void bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc}); 
        v[sr][sc] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            // System.out.printf("%d, %d\n", cur[0], cur[1]);
            answer++; 

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] != 0) continue; 
                if(v[nr][nc]) continue;

                v[nr][nc] = true; 
                q.offer(new int[]{nr, nc});
            }

        }

        
    }
}