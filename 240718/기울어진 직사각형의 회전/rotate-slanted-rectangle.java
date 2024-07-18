import java.io.*;
import java.util.*; 

public class Main {

    static int N, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()); 
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        solve(sr-1, sc-1, m1, m2, m3, m4, dir); 

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n"); 
        }

        System.out.println(sb);
    }

    static void solve(int sr, int sc, int m1, int m2, int m3, int m4, int dir){
        int temp = map[sr][sc]; 

        int[] dr = new int[]{-1, -1, 1, 1}; 
        int[] dc = (dir == 0) ? new int[]{-1, 1, 1, -1} : new int[]{1, -1, -1, 1};
        int[] dist = (dir == 0) ? new int[]{m4, m3, m2, m1} : new int[]{m1, m2, m3, m4}; 

        int curR = sr;
        int curC = sc; 
        for(int d=0; d<4; d++){
            for(int i=0; i<dist[d]; i++){
                // System.out.printf("%d %d\n", curR, curC);

                map[curR][curC] = map[curR+dr[d]][curC+dc[d]];

                curR += dr[d];
                curC += dc[d];
            }
        }

        if(dir == 0){
            map[sr-1][sc+1] = temp;
        }else{
            map[sr-1][sc-1] = temp; 
        }

    } 
}