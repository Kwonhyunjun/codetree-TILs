import java.io.*;
import java.util.*; 

public class Main {
   public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int[] arr = new int[N]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1]; 
        dp[0] = 0; 

        for(int i=0; i<N; i++){
            
            for(int j=1; j<=N; j++){
                if(i+j >= N+1) continue; 

                dp[i+j] = Math.max(dp[i+j], dp[i] + arr[j-1]);
            }
        }
        
        System.out.println(dp[N]); 
    }
}