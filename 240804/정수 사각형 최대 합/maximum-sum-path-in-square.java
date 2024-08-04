import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int[][] map = new int[N][N]; 
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(i == 0 || j == 0){
                    dp[i][j] = map[i][j];
                }
            }
        }

        for(int i=1; i<N; i++){
            dp[i][0] = dp[i-1][0] + map[i][0]; 
        }
        
        for(int r=1; r<N; r++){
            for(int c=1; c<N; c++){
                dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]) + map[r][c]; 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i])); 
        // }

        System.out.println(dp[N-1][N-1]);
    }
}