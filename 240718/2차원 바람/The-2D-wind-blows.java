import java.io.*;
import java.util.*; 

public class Main {
    
    static int N, M, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        int Q = Integer.parseInt(st.nextToken()); 

        map = new int[N][M]; 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            // System.out.printf("%d %d %d %d\n", sr, sc, er, ec);
            blow(sr-1, sc-1, er-1, ec-1);
            average(sr-1, sc-1, er-1, ec-1); 
        }
        StringBuilder sb = new StringBuilder(); 

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void blow(int sr, int sc, int er, int ec){
        
        int temp = map[sr][sc]; 

        // 왼 
        // System.out.println("왼");
        for(int i=sr; i<=er-1; i++){
            // System.out.printf("map[%d][%d]\n", i, sc);
            map[i][sc] = map[i+1][sc]; 
        }

        // 아래 
        // System.out.println("아래");
        for(int i=sc; i<=ec-1; i++){
            map[er][i] = map[er][i+1];
            // System.out.printf("map[%d][%d]\n", er, i);
        }

        // 오른
        // System.out.println("오른");
        for(int i=er; i>=sr+1; i--){
            map[i][ec] = map[i-1][ec]; 
            // System.out.printf("map[%d][%d]\n", i, ec);
        }

        // 위
        // System.out.println("위");
        for(int i=ec; i>=sc+1; i--){
            map[sr][i] = map[sr][i-1];
            // System.out.printf("map[%d][%d]\n", sr, i);
        }

        map[sr][sc+1] = temp; 

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static void average(int sr, int sc, int er, int ec){
        int[][] temp = new int[N][M];

        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){
                
                int sum = map[r][c]; 
                int cnt = 1;
                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d]; 
                    
                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
                    sum += map[nr][nc]; 
                    cnt++; 
                }

                temp[r][c] = sum / cnt; 
            }
        }

        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){ 
                map[r][c] = temp[r][c]; 
            }
        }
        // System.out.println();
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
    }
}