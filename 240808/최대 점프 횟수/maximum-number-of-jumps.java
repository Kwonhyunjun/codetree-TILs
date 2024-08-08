import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; 
        int[] dp = new int[N]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; 

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(dp[j] == Integer.MIN_VALUE) continue;

                if(j+arr[j] >= i){
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }
        }

        // System.out.println(Arrays.toString(dp)); 
        int answer = 0; 
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer); 
    }
}