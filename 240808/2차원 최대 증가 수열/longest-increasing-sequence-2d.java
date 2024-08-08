import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int[][] map = new int[N][M]; 
        int[][] dp = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1; 

        for(int r=1; r<N; r++){
            for(int c=1; c<N; c++){
                
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(dp[i][j] == Integer.MIN_VALUE) continue;

                        if(map[r][c] > map[i][j]){
                            dp[r][c] = Math.max(dp[r][c], dp[i][j] + 1); 
                        }
                    }
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i])); 
        // }

        int answer = 0; 
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                answer = Math.max(answer, dp[i][j]); 
            }
        }

        System.out.println(answer); 
    }
}