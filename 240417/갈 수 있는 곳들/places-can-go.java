import java.io.*; 
import java.util.*; 

public class Main {

    static int N; 
    static int ans, map[][];
    static boolean[][] v;
    static int[] dr = {0, -1, 0, 1}, dc = {1, 0, -1, 0}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        map = new int[N][N]; 
        v = new boolean[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            bfs(r, c); 

            // for(int d=0; d<4; d++){
            //     int nr = r + dr[d]; 
            //     int nc = c + dc[d]; 

            //     if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            //     if(map[nr][nc] == 1) continue; 
                
            //     ans++; 
            // }

        }

        System.out.println(ans); 

    }

    static void bfs(int sr, int sc){

        ArrayDeque<int[]> q = new ArrayDeque<>(); 
        
        if(!v[sr][sc]) ans++;

        q.offer(new int[]{sr, sc});
        v[sr][sc] = true;


        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0 ; d<4; d++){
                int nr = cur[0] + dr[d]; 
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] == 1) continue; 
                if(v[nr][nc]) continue;

                q.offer(new int[]{nr, nc}); 
                v[nr][nc] = true;
                ans++; 
            }
        }

    }
}