import java.io.*;
import java.util.*; 

public class Main {

    static int N; 
    static int[][] map; 
    static boolean[][] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 맵 크기
        int M = Integer.parseInt(st.nextToken()); // 금 가격
        int answer = 0; 
        map = new int[N][N];
        int total = 0; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] == 1)
                    total += M; 
            }
        }

        int K = 1; 
        while(true){
            if((K * K + (K+1) * (K+1)) > total){
                break;
            }
            K++; 
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                // int dist = 1;
                // while(true){
                //     v = new boolean[N][N]; 
                //     int gold = bfs(r, c, dist); // 개수
                //     // 만약 채굴 비용이 더 높다면 break
                //     if((dist * dist + (dist+1) * (dist+1)) > gold * M) break; 
                //     answer = Math.max(answer, gold);
                //     System.out.printf("map[%d][%d] -> %d dist(%d)\n",r, c, gold, dist);
                //     dist++; 
                // }
                for(int k=0; k<K+1; k++){
                    v = new boolean[N][N];
                    int gold = bfs(r, c, k); // 개수
                    if((k * k + (k+1) * (k+1)) <= gold * M){
                        answer = Math.max(answer, gold);
                    }
                    // if(r > 2)
                        // System.out.printf("map[%d][%d] -> %d dist(%d)\n",r, c, gold, k);
                }
                
            }
        }

        System.out.println(answer);
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int bfs(int sr, int sc, int dist){
        int result = 0;

        Queue<int[]> q = new ArrayDeque<>(); 
        q.add(new int[] {sr, sc, 0}); 
        v[sr][sc] = true; 

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            
            // if(sr == 3 && sc == 3 && dist == 2){
            //     System.out.println("cur : " + Arrays.toString(cur));
            // }

            if(map[cur[0]][cur[1]] == 1){
                result++; 
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(cur[2]+1 > dist) continue; 
                if(v[nr][nc]) continue;

                q.add(new int[]{nr, nc, cur[2]+1}); 
                v[nr][nc] = true; 
                //  if(sr == 3 && sc == 3 && dist == 2){
                //     System.out.printf("next : %d %d %d\n", nr, nc, cur[2]+1);
                // }
            }
        }

        // if(sr == 3 && sc == 3){
        //     for(boolean[] b : v){
        //         System.out.println(Arrays.toString(b));
        //     }
        // }

        return result; 
    }
}