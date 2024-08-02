import java.io.*;
import java.util.*; 

public class Main {

    static int N, K, answer, points[], map[][];
    static boolean[][] v; 
    static ArrayList<int[]> walls = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] == 1)
                    walls.add(new int[]{i, j}); 
            }
        }

        points = new int[4];
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine()); 
            points[i*2] = Integer.parseInt(st.nextToken())-1;
            points[i*2+1] = Integer.parseInt(st.nextToken())-1;
        }

        answer = Integer.MAX_VALUE; 
        destroy(0, 0);
        
        answer = (answer == Integer.MAX_VALUE)? -1 : answer;

        System.out.println(answer); 
    }

    public static void destroy(int idx, int start){
        if(idx == K){
            for(int i=0; i<N; i++){
                Arrays.fill(v[i], false); 
            }
             
            answer = Math.min(answer, bfs(points[0], points[1])); 
            return; 
        }

        for(int i=start; i<walls.size(); i++){
            int[] cur = walls.get(i);
            int r = cur[0];
            int c = cur[1];

            map[r][c] = 0;
            destroy(idx+1, i+1); 
            map[r][c] = 1; 
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static int bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>(); 

        v[sr][sc] = true; 
        q.offer(new int[]{sr, sc, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == points[2] && cur[1] == points[3]){
                return cur[2]; 
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] == 1) continue; 
                if(v[nr][nc]) continue; 

                v[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2]+1}); 
            }
        }

        return Integer.MAX_VALUE; 
    }
}