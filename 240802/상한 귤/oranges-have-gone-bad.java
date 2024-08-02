import java.io.*;
import java.util.*;

public class Main {

    static int N, K, map[][], answer[][];
    static boolean v[][]; 
    static ArrayList<int[]> rotten = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];
        answer = new int[N][N];
        v = new boolean[N][N];

        for(int i=0; i<N; i++){
            Arrays.fill(answer[i], Integer.MAX_VALUE); 
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    answer[i][j] = -1; 
                }else if(map[i][j] == 2){
                    rotten.add(new int[]{i, j});
                }
            }
        }

        for(int i=0; i<rotten.size(); i++){
            int[] cur = rotten.get(i); 
            bfs(cur[0] , cur[1]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int num = (answer[i][j] == Integer.MAX_VALUE)? -2 : answer[i][j]; 
                sb.append(num).append(" ");
            }
            sb.append("\n"); 
        }

        System.out.println(sb);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static void bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>(); 
        
        answer[sr][sc] = 0; 
        q.offer(new int[]{sr, sc, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(answer[nr][nc] < (cur[2]+1)) continue;

                answer[nr][nc] = cur[2]+1;
                q.offer(new int[]{nr, nc, cur[2]+1}); 
            }
        }
    }
}