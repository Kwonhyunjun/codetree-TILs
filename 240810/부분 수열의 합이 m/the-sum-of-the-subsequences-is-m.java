import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[M+1]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0] = 0; 

        for(int i=0; i<N; i++){
            int cur = arr[i];     
        
            for(int j=M; j>=cur; j--){
                if(dp[j-cur] == Integer.MAX_VALUE) continue;

                dp[j] = Math.min(dp[j], dp[j-cur]+1);
            }
        }

        int answer = (dp[M] == Integer.MAX_VALUE) ? -1 : dp[M]; 
        System.out.println(answer); 

    }
}