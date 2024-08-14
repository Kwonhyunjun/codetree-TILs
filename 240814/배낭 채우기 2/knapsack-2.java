import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int[][] items = new int[N][2]; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            int w = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 

            items[i][0] = w; 
            items[i][1] = v; 
        }

        int[] dp = new int[M+1]; 
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; 

        for(int i=1; i<=M; i++){ // dp 무게
            
            for(int j=0; j<N; j++){
                int weight = items[j][0];
                int value = items[j][1]; 

                if(i - weight < 0) continue;
                if(dp[i-weight] == Integer.MIN_VALUE) continue; 

                dp[i] = Math.max(dp[i], dp[i-weight]+value);
            }
        }

        int answer = 0; 
        for(int i=0; i<=M; i++){
            answer = Math.max(answer, dp[i]); 
        }

        System.out.println(answer); 

    }
}