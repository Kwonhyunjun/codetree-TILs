import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coins = new int[N]; 
        int[] dp = new int[M+1]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i=1; i<=M; i++){
            for(int j=0; j<N; j++){
                if(i-coins[j] >= 0){
                    if(dp[i-coins[j]] == Integer.MIN_VALUE) continue;

                    dp[i] = Math.max(dp[i], dp[i-coins[j]]+1); 
                }
            }
        }

        int answer = (dp[M] == Integer.MIN_VALUE) ? -1 : dp[M];
        System.out.println(answer);
    }
}