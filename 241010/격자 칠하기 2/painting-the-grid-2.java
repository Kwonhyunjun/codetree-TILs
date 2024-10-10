import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], half, answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        half = (N * N + 1) / 2;
        answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        // 칸에 쓰인 숫자가 현재 칸의 숫자와 D 이하로 차이나는 상하좌우로 인접한 칸으로 이동해 색칠하는 것을 반복

        int left = 0; 
        int right = 1_000_000; 

        while(left <= right){
            int mid = left + (right-left)/2; 

            if(isPossible(mid)){
                right = mid - 1; 
                answer = Math.min(answer, mid); 
            }else{
                left = mid + 1; 
            }
        }

        System.out.println(answer); 
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1}; 
    static boolean[][] v; 

    static boolean isPossible(int mid){
        Queue<int[]> pq; 
        v = new boolean[N][N]; 

        // 시작 위치
        for(int sr = 0; sr<N; sr++){
            for(int sc = 0; sc<N; sc++){
                int cnt = 0; 

                pq = new ArrayDeque<>();

                // 첫시작
                pq.offer(new int[]{sr, sc});
                v[sr][sc] = true; 

                while(!pq.isEmpty()){
                    int[] cur = pq.poll();
                    cnt++; 

                    for(int d=0; d<4; d++){
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d]; 

                        if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if(v[nr][nc]) continue;
                        if(Math.abs(map[cur[0]][cur[1]] - map[nr][nc]) > mid) continue; 

                        pq.offer(new int[]{nr, nc});
                        v[nr][nc] = true; 
                    }
                }

                if(cnt >= half) return true; 
            }
        }
        return false; 
    }
}