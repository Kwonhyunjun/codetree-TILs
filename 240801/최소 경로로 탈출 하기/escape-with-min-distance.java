/*
    시작점으로부터 최단거리를 저장해 줄 step이라는 이름의 2차원 배열을 더 만들어줌
    Push함수에 step값에 대한 갱신부분을 추가
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer, map[][], step[][]; 
    static boolean[][] v; 
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        step = new int[N][M];
        v = new boolean[N][M]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        bfs(0, 0); 

        answer = (step[N-1][M-1] > 0)? step[N-1][M-1] : -1; 

        System.out.println(answer); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    
    public static void bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, 0});
        v[sr][sc] = true; 

        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            step[cur[0]][cur[1]] = cur[2]; 

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
                if(map[nr][nc] == 0) continue; 
                if(v[nr][nc]) continue; 

                v[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2]+1}); 
            }
            
        }

    }

}