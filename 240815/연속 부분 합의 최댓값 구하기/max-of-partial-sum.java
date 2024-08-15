import java.util.*;
import java.io.*;

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

        dp[0] = arr[0];

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }
        
        int answer = Integer.MIN_VALUE; 
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]); 
        }
        System.out.println(answer);
    }
}