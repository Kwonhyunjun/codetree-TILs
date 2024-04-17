import java.io.*; 
import java.util.*; 

public class Main {

    static int N, M; 
    static int[][] map;
    static boolean[][] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; 
        v = new boolean[N][M]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        System.out.println(bfs()); 

    }

    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1}; 
    static int bfs(){
        
        ArrayDeque<int[]> q = new ArrayDeque<>(); 
        q.add(new int[]{0, 0}); 
        v[0][0] = true; 

        while(!q.isEmpty()){
            
            int[] cur = q.poll(); 

            if(cur[0] == N-1 && cur[1] == M-1){
                return 1; 
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d]; 
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(v[nr][nc]) continue; 
                if(map[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc}); 
                v[nr][nc] = true;
            }

        }
        return 0; 
    }
}