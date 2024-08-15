import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int[][] quest = new int[N][2];

        int total = 0; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            quest[i][0] = Integer.parseInt(st.nextToken()); 
            quest[i][1] = Integer.parseInt(st.nextToken());
            total += quest[i][1];
        }

        int[][] dp = new int[N][total+1]; 
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE); 
        }

        dp[0][0] = 0;
        dp[0][quest[0][1]] = quest[0][0]; 

        for(int i=1; i<N; i++){
            int exp = quest[i][0];
            int time = quest[i][1]; 

            for(int j=0; j<total+1; j++){
                if(j-time >= 0){

                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time]+exp);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i])); 
        // }

        int answer = -1;
        for(int i=0; i<=total; i++){
            if(dp[N-1][i] >= M){
                answer = i; 
                break; 
            }
        }

        System.out.println(answer); 
        
        
    }
}