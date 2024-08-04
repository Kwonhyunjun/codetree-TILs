import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[20]; 
        
        dp[0] = 1; 
        dp[1] = 1; 
        dp[2] = 2; 

        for(int i=3; i<=N; i++){
            int res = 0;
            for(int j=1; j<=i; j++){
                // System.out.printf("%d %d\n", j-1, i-j); 
                res += dp[j-1] * dp[i-j]; 
            }
            dp[i] = res; 
        }

        System.out.println(dp[N]); 
    }
}