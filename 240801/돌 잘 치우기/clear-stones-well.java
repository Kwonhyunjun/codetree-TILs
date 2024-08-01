import java.io.*;
import java.util.*; 

public class Main {

    static int N, K, M,answer, map[][]; 
    static boolean[][] v; 
    static ArrayList<int[]> stones = new ArrayList<>();
    static ArrayList<int[]> sp = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        K = Integer.parseInt(st.nextToken()); // 시작점의 수
        M = Integer.parseInt(st.nextToken()); // 치워야 할 돌

        map = new int[N][N];
        v = new boolean[N][N]; 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken()); 
                map[i][j] = num;
                if(num == 1)
                    stones.add(new int[]{i, j}); 
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1; 
            int c = Integer.parseInt(st.nextToken())-1;

            sp.add(new int[]{r, c});
        }

        solve(0, 0);

        System.out.println(answer);
    }

    public static void solve(int idx, int start){
        if(idx == M){
            for(int i=0; i<N; i++){
                Arrays.fill(v[i], false); 
            }
            int cnt = countArea();
            answer= Math.max(answer, cnt); 
            return; 
        }

        for(int i=start; i<stones.size(); i++){
            int[] cur = stones.get(i); // 현재 없애려는 돌의 좌표
            map[cur[0]][cur[1]] = 0; 
            solve(idx+1, i+1);
            map[cur[0]][cur[1]] = 1; 
        }
    }

    public static int countArea(){
        int res = 0 ;

        for(int i=0; i<sp.size(); i++){
            int[] cur = sp.get(i); 

            if(v[cur[0]][cur[1]]) continue; // 이미 방문했다면

            res += bfs(cur[0], cur[1]); 
        }
        
        return res; 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static int bfs(int sr, int sc){
        int res = 0; 

        Queue<int[]> q = new ArrayDeque<>(); 

        v[sr][sc] = true;
        q.offer(new int[]{sr, sc});

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            res++; 

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] == 1) continue; 
                if(v[nr][nc]) continue; 

                v[nr][nc] = true;
                q.offer(new int[]{nr, nc}); 
            }
        }
        return res; 
    }
}