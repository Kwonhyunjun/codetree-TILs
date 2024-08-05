import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int M = Integer.parseInt(st.nextToken()); // 무게의 합

        int[][] items = new int[N][2]; 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게 
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[][] dp = new int[N][10000001]; 
    
        // 초기화(첫 아이템)
        dp[0][items[0][0]] = items[0][1];

        for(int i=1; i<N; i++){ // 물건을 순회하면서

            // for(int k=0; k<N; k++){
            //     System.out.println(Arrays.toString(dp[k]));
            // }
            // System.out.println();
            int curW = items[i][0];
            int curV = items[i][1]; 

            for(int w=1; w<=M; w++){ // 해당 무게를 고려
                // 해당 물건을 넣었을 때
                if(w - curW >= 0){
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-curW] + curV); 
                }else { // 해당 물건을 넣지 않았을 때
                	dp[i][w] = dp[i-1][w]; 
                }
            }
        }

        // for(int i=0; i<N; i++){
        //         System.out.println(Arrays.toString(dp[i]));
        //     }
        //     System.out.println();

        int answer = -1; 

        for(int i=0; i<=M; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        System.out.println(answer); 

    }
}