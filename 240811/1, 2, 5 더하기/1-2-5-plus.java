import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int N = Integer.parseInt(br.readLine()); 

        int[] dp = new int[N+1]; 
        int[] num = {1, 2, 5}; 
        dp[0] = 1; 

        for(int i=1; i<=N; i++){
            for(int j=0; j<3; j++){
                if(i - num[j] >= 0){
                    dp[i] += dp[i - num[j]]; 
                }
            }

            dp[i] %= 10007;
        }

        // System.out.println(Arrays.toString(dp)); 
        System.out.println(dp[N]); 
    }
}