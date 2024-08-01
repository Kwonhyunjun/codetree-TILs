import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer[], map[][];
    static boolean[][] v;  
    static ArrayList<int[]> ices; 
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        map = new int[N][M];
        v = new boolean[N][M];
        answer = new int[2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        while(true){
            // visted 배열 초기화
            for(int i=0; i<N; i++){
                Arrays.fill(v[i], false); 
            }

            // 얼음 초기화
            ices = new ArrayList<>(); 

            bfs(0, 0);

            if(ices.size() == 0) break;

            // 시간 갱신
            answer[0]++; 
            int cnt = 0;
            for(int i=0; i<ices.size(); i++){
                int[] cur = ices.get(i); 
                if(map[cur[0]][cur[1]] == 0) continue;
                map[cur[0]][cur[1]] = 0; 
                cnt++; 
            }

            // 녹은 빙하의 크기 갱신 
            answer[1] = cnt;

            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(map[i]));
            // }
            // System.out.println();
        }

        System.out.printf("%d %d\n", answer[0], answer[1]); 
    }

    public static void bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>(); 

        v[sr][sc] = true; 
        q.offer(new int[]{sr, sc}); 

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            // System.out.printf("%d %d\n", cur[0], cur[1]);

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
                if(v[nr][nc]) continue;
                if(map[nr][nc] == 1) {
                    //  System.out.printf("녹을 빙하 %d %d\n", nr, nc);
                    ices.add(new int[]{nr, nc});
                    v[nr][nc] = true;
                    continue;
                }

                v[nr][nc] = true;
                q.offer(new int[]{nr, nc}); 
            }
        }
    }
}