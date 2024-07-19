import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken())-1;
        int C = Integer.parseInt(st.nextToken())-1;

        bomb(R, C);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]).append(" "); 
            }
            sb.append("\n"); 
        }

        System.out.println(sb);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1}; 
    static void bomb(int r, int c){
        int power = map[r][c]-1; 
        map[r][c] = 0; 
        for(int d=0; d<4; d++){
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 

            for(int i=0; i<power; i++){
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                map[nr][nc] = 0; 
                nr += dr[d];
                nc += dc[d]; 
            }
        }

        move(); 
    }

    static void move(){
        int[][] temp = new int[N][N];
        
        for(int c = 0; c < N; c++){
            int idx = N-1; 
            for(int r = N-1; r >= 0; r--){
                // System.out.println(c +" "+ r); 
                if(map[r][c] != 0){
                    temp[idx--][c] = map[r][c]; 
                }
            }
        }
        map = temp; 
    }
}