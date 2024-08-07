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

        dp[0][0] = map[0][0];
        
        for(int i=1; i<N; i++){
            dp[i][0] = Math.max(dp[i-1][0], map[i][0]);
            dp[0][i] = Math.max(dp[0][i-1], map[0][i]);
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                dp[i][j] = Math.max(map[i][j], Math.min(dp[i-1][j], dp[i][j-1])); 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.println(dp[N-1][N-1]);

        
    }
}