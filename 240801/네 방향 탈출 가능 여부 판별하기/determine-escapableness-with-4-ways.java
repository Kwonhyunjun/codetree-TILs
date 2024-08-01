/*
    그래프 탐색 알고리즘의 2가지 대원칙
        1. 시작점으로부터 연결된 모든 정점을 전부 방문해야한다.
        2. 이미 방문한 정점은 다시는 방문하지 않는다.
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][], answer;
    static boolean[][] v; 


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()); 
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }

        bfs(0, 0); 

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

            if(cur[0] == N-1 && cur[1] == M-1){
                answer = 1;
                return; 
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] == 0) continue;
                if(v[nr][nc]) continue; 

                v[nr][nc] = true; 
                q.offer(new int[]{nr, nc}); 
            }
        }
    }
}