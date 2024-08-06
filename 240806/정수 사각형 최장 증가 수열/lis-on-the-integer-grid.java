import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], memo[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 

        map = new int[N][N]; 
        memo = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(memo[i], -1);  
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int answer = -1; 
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(memo[r][c] == -1){
                    answer =Math.max(solve(r, c), answer);
                }
            }
        }
        
        System.out.println(answer);

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(memo[i])); 
        // }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    public static int solve(int r, int c){
        // System.out.printf("%d %d\n", r, c);
        if(memo[r][c] != -1) return memo[r][c]; 

        int max = 1; 
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            if(map[nr][nc] <= map[r][c]) continue; 
            max = Math.max(max, solve(nr, nc)+1); 
        }

        memo[r][c] = max; 
        return max;
    }
}