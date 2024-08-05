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

        Arrays.fill(dp, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // dp 테이블 정의 : 금액의 총합이 i일때, 최소 동전 수
        dp[0] = 0;

        for(int i=1; i<=M; i++){
            for(int j=0; j<N; j++){
                if(i - coins[j] >=0){
                    if(dp[i-coins[j]] == Integer.MAX_VALUE) continue; 
                    
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);            
                }
            }
        }
        
        int answer = (dp[M] == Integer.MAX_VALUE) ? -1 : dp[M];
        System.out.println(answer);
    }
}