import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 

        int[] arr = new int[N+1];
        int[] dp = new int[N+1]; 

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        // System.out.println(Arrays.toString(arr)); 

        Arrays.fill(dp, 1);
        dp[0] = 0; 

        for(int i=1; i<=N; i++){
            // System.out.printf("i : %d\n", i); 
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j]){
                    // System.out.printf("     j : %d\n", j);
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }
        }

        // System.out.println(Arrays.toString(dp)); 
        int answer = 0; 
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, dp[i]); 
        }

        System.out.println(answer);
    }
}