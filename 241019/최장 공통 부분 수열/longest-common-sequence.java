import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int N = str1.length; 
        int M = str2.length; 

        int[][] dp = new int[N][M]; 

        dp[0][0] = (str1[0] == str2[0]) ? 1 : 0;

        for(int i=1; i<N; i++){ 
            if(dp[i-1][0] == 1){
                dp[i][0] = 1; 
            }else{
                dp[i][0] = (str2[0] == str1[i]) ? 1 : 0; 
            }
        }

        for(int i=1; i<M; i++){ 
            if(dp[0][i-1] == 1){
                dp[0][i] = 1; 
            }else{
                dp[0][i] = (str2[i] == str1[0]) ? 1 : 0; 
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i])); 
        // }

        System.out.println(dp[N-1][M-1]);


    }
}