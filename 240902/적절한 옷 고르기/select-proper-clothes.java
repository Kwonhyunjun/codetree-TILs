import java.io.*;
import java.util.*; 

public class Main {
    
    static int N, M, clothes[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 옷의 개수
        M = Integer.parseInt(st.nextToken()); // 일수

        clothes = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                clothes[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(clothes[i])); 
        // }

        int[][] dp = new int[M+1][N];
        
        for(int i=0; i<N; i++){
            if(!wearable(i, 1)){
                dp[1][i] = Integer.MIN_VALUE; 
            }
        }

        // System.out.println(Arrays.toString(dp[1])); 

        for(int i=2; i<=M; i++){ // 날짜
            // System.out.printf("day : %d\n", i);
            for(int j=0; j<N; j++){ // 오늘 입을 옷
                if(wearable(j, i)){
                    // System.out.printf("오늘 입을 수 있는 옷 : %d ->", j);
                    for(int k=0; k<N; k++){ // 어제 입은 옷
                        if(dp[i-1][k] == Integer.MIN_VALUE) continue;
                        // System.out.printf(" %d ", k);
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Math.abs(clothes[j][2] - clothes[k][2]));
                    }
                }else{
                    dp[i][j] = Integer.MIN_VALUE; 
                }
                // System.out.println();
            }
            // System.out.println(Arrays.toString(dp[i])); 
        }

        int answer = 0; 
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[M][i]);
        }

        System.out.println(answer); 

    }
    
    public static boolean wearable(int num, int day){
        if(day >= clothes[num][0] && day <= clothes[num][1]){
            return true; 
        }

        return false; 
    }
}