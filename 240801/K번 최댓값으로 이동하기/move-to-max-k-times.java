import java.io.*;
import java.util.*; 

/*
    K번 반복한 이후 위치를 구하는 프로그램을 작성해보세요
    
    해당 위치에서 인접한 작은 숫자가 적한 값으로만 이동할 수 있다.
*/

class Data implements Comparable<Data>{
    int r, c, n; 

    public Data(int r, int c, int n){
        this.r = r;
        this.c = c;
        this.n = n;
    }

    @Override
    public int compareTo(Data o1){
        if(this.n == o1.n){
            if(this.r == o1.r){
                return this.c - o1.c; 
            }
            return this.r - o1.r; 
        }
        return -(this.n - o1.n); 
    }
}

public class Main {

    static int N, K, map[][];
    static boolean[][] v; 

    static PriorityQueue<Data> pq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];
        v = new boolean[N][N]; 

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        st = new StringTokenizer(br.readLine()); 
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1; 
        // System.out.println(sr+" "+sc);
        
        
        for(int k=0; k<K; k++){
            // System.out.println("k :" + k);
            // 방문배열 초기화
            for(int i=0; i<N; i++){
                Arrays.fill(v[i], false); 
            }

            // PQ 초기화
            pq = new PriorityQueue<>(); 

            // BFS로 후보 찾기
            bfs(sr, sc, map[sr][sc]); 

            // System.out.println(pq.size());
            if(pq.size() == 0) break; 
            

            // PQ로 가장 적절한 후보 찾기
            Data next = pq.poll(); 
            // System.out.printf("map[%d][%d] = %d\n", next.r, next.c, next.n);

            // 시작점 만들기
            sr = next.r;
            sc = next.c; 
        }

        System.out.println((sr+1) + " " + (sc+1)); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static void bfs(int r, int c, int num){
        Queue<int[]> q = new ArrayDeque<>();
        
        v[r][c] = true;
        q.offer(new int[]{r, c}); 

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            // System.out.println(cur[0] + " " + cur[1]); 
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] >= num) continue; 
                if(v[nr][nc]) continue; 

                // System.out.printf("다음 %d %d \n", nr, nc);
                v[nr][nc] = true;
                pq.add(new Data(nr, nc, map[nr][nc])); 
                q.add(new int[]{nr, nc});
            }
        }
    }
}