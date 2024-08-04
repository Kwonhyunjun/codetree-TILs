import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 
        int[][] map = new int[N][N]; 
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][N-1] = map[0][N-1];

        for(int i=N-2; i>=0; i--){
            dp[0][i] = dp[0][i+1] + map[0][i]; 
        }

        for(int i=1; i<N; i++){
            dp[i][N-1] = dp[i-1][N-1] + map[i][N-1];
        }

       

        for(int r=1; r<N; r++){
            for(int c=N-2; c>=0; c--){
                dp[r][c] = Math.min(dp[r-1][c], dp[r][c+1]) + map[r][c];
            }
        }


        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i])); 
        // }

        System.out.println(dp[N-1][0]);
    }
}