import java.io.*;
import java.util.*;

public class Main {

    static int N, K, u, d, answer, map[][];
    static boolean[][] v;
    static ArrayList<Integer> selected = new ArrayList<>(); 


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        K = Integer.parseInt(st.nextToken()); // 고를 도시의 수
        u = Integer.parseInt(st.nextToken()); // 높이차 기준
        d = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];
        v = new boolean[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        solve(0, 0);

        System.out.println(answer);

    }

    public static void solve(int cnt, int start){
        if(cnt == K){
            // 방문 기록 초기화
            for(int i=0; i<N; i++){
                Arrays.fill(v[i], false); 
            }

            int total = 0;
            for(int i=0; i<selected.size(); i++){
                int idx = selected.get(i);
                int r = idx / N;
                int c = idx % N;
                // System.out.printf("%d -> %d %d\n", idx, r, c);
                if(v[r][c]) continue;
                int n = bfs(r, c);
                total += n;
                // System.out.println(n); 
            }
            
            answer = Math.max(answer, total); 
            return; 
        }

        for(int i=start; i<N*N; i++){
            selected.add(i);
            solve(cnt+1, i+1); 
            selected.remove(selected.size()-1); 
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    public static int bfs(int sr, int sc){
        int res = 0;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc});
        v[sr][sc] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            // System.out.printf("현재위치 map[%d][%d] = %d\n", cur[0], cur[1], map[cur[0]][cur[1]]);
            res++;

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(v[nr][nc]) continue; 
                if(!canGo(map[cur[0]][cur[1]], map[nr][nc])) continue;

                // System.out.printf("다음위치 map[%d][%d] = %d\n", nr, nc, map[nr][nc]);
                v[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        // System.out.printf("bfs 결과[%d][%d] : %d\n", sr, sc, res);
        return res; 
    }

    public static boolean canGo(int prev, int next){
        
        int diff = Math.abs(prev - next); 
        // System.out.printf("%d-%d = %d\n", prev, next, diff);

        if(diff >= u && diff <= d) {
            // System.out.println("Ok");
            return true; 
        }

        return false; 
    }
}