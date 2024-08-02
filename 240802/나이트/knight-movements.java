import java.io.*;
import java.util.*;

public class Main {
    
    static int N, map[][], points[], answer; 
    static boolean[][] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 

        map = new int[N][N]; 
        v = new boolean[N][N]; 

        st = new StringTokenizer(br.readLine());
        points = new int[4]; 
        for(int i=0; i<4; i++){
            points[i] = Integer.parseInt(st.nextToken())-1;
        }

        bfs(points[0], points[1]); 

        System.out.println(answer);
    }

    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2}; 

    public static void bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();
        
        v[sr][sc] = true; 
        q.offer(new int[]{sr, sc, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == points[2] && cur[1] == points[3]){
                answer = cur[2]; 
                return; 
            }

            for(int d=0; d<8; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(v[nr][nc]) continue;

                v[nr][nc] = true; 
                q.offer(new int[]{nr, nc, cur[2]+1}); 
                
            }
        }
        
    }
}