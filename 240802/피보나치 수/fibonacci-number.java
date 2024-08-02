import java.io.*;
import java.util.*; 

public class Main {

    static int N; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        memo = new int[N+1]; 
        Arrays.fill(memo, -1); 
        
        System.out.println(fibbo(N));   
    }

    static int[] memo;
    public static int fibbo(int n){
        if(n <= 2){
            return 1; 
        }

        if(memo[n] != -1) return memo[n]; 

        int res = fibbo(n-2) + fibbo(n-1); 
        memo[n] = res; 
        return res; 
    }
}

// public class Main {
    
//     static int N, dp[]; 

//     public static void main(String[] args) throws Exception{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());
//         dp = new int[N+10];

//         dp[1] = 1;
//         dp[2] = 1;

//         for(int i=3; i<=N; i++){
//             dp[i] = dp[i-2] + dp[i-1]; 
//         }

//         System.out.println(dp[N]);
//     }
// }