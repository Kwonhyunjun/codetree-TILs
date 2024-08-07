import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        int[] dp = new int[N]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.fill(dp, 1); 
        dp[0] = 1; 

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){

                if(map[j] < map[i]){
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