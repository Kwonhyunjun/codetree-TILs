import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        int total = 0;
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            total += arr[i];
        }

        if(total % 2 != 0){
            System.out.println("No");
            return; 
        }

        boolean[][] dp = new boolean[N][total+1]; 

        dp[0][0] = true;
        dp[0][arr[0]] = true;

        for(int i=1; i<N; i++){
            
            for(int j=0; j<=total; j++){
                if(dp[i-1][j] || (j-arr[i] >= 0 && dp[i-1][j-arr[i]])) dp[i][j] = true;
            }
        }
        
        String answer = (dp[N-1][total/2])? "Yes" : "No"; 
        System.out.println(answer); 
    }
}