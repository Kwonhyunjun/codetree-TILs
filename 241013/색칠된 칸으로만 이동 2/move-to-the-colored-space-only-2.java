import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][], point[][], sr, sc, total; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N]; 
        point = new int[M][N];
        int max = 0;  

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                point[i][j] = Integer.parseInt(st.nextToken());

                if(point[i][j] == 1){
                    sr = i;
                    sc = j; 
                    total++; 
                }
            }
        }

        int left = 0;
        int right = max; 
        int answer = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(mid)){
                right = mid - 1; 
                answer = Math.min(answer, mid);
            }else{
                left = mid + 1; 
            }
        }

        System.out.println(answer);

    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean isPossible(int mid){
        int cnt = 0; 
        boolean[][] v = new boolean[M][N];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        v[sr][sc] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            
            cnt += point[cur[0]][cur[1]];

            if(cnt == total) return true; 

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if(v[nr][nc]) continue;
                if(Math.abs(map[cur[0]][cur[1]] - map[nr][nc]) > mid) continue;

                q.offer(new int[]{nr, nc});
                v[nr][nc] = true; 
            }
        }

        return false;
    }
}