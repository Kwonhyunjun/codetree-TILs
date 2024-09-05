import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] temple = new int[N][3]; 
        int[][] dp = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                temple[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        // 초기화
        for(int i=0; i<3; i++){
            dp[0][i] = temple[0][i]; 
        }

        for(int i=1; i<N; i++){ // 층
            
            for(int j=0; j<3; j++){ // 현재 층 방의 방향
                
                for(int k=0; k<3; k++){ // 이전 층 방의 방향
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + temple[i][j]);
                }
            }

        }

        int answer = 0; 

        for(int i=0; i<3; i++){
            answer = Math.max(answer, dp[N-1][i]); 
        }

        System.out.println(answer); 
    }
    
}