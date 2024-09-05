// // import java.io.*;
// // import java.util.*; 

// // public class Main {
// //     public static void main(String[] args) throws Exception{
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
// //         int N = Integer.parseInt(br.readLine());

// //         int[][] dp = new int[N][10]; 


// //         // Arrays.fill(dp[0], 1);
// //         // dp[0][0] = 0; 
// //         for (int i = 1; i <= 9; i++) {
// //             dp[0][i] = 1;  // 첫 번째 자리는 1~9까지만 올 수 있음
// //         }


// //         for(int i=1; i<N; i++){
            
// //             for(int j=0; j<10; j++){
// //                 int down = (j == 0) ? 0 : dp[i-1][j-1]; 
// //                 int up = (j == 9) ? 0 : dp[i-1][j+1] ; 

// //                 dp[i][j] = (down + up) % 1000000007; 

// //             }
// //         }

// //         int answer = 0; 
// //         for(int i=0; i<10; i++){
// //             answer += (dp[N-1][i] % 1000000007); 
// //         }

// //         System.out.println(answer); 


// //     }
// // }

// import java.io.*;
// import java.util.*; 

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
//         int N = Integer.parseInt(br.readLine());
//         int MOD = 1000000007;

//         int[][] dp = new int[N][10]; 

//         // 첫 번째 자리는 1~9까지만 올 수 있음
//         for (int i = 1; i <= 9; i++) {
//             dp[0][i] = 1;
//         }

//         for(int i = 1; i < N; i++){
//             for(int j = 0; j < 10; j++){
//                 int down = (j == 0) ? 0 : dp[i-1][j-1]; 
//                 int up = (j == 9) ? 0 : dp[i-1][j+1]; 

//                 dp[i][j] = (down + up) % MOD;  // 모듈로 연산을 갱신 시점에 바로 적용
//             }
//         }

//         int answer = 0; 
//         for(int i = 0; i < 10; i++){
//             answer = (answer + dp[N-1][i]) % MOD;  // 결과를 더할 때도 모듈로 연산
//         }

//         System.out.println(answer);
//     }
// }


import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][10]; 


        Arrays.fill(dp[0], 1);
        dp[0][0] = 0; 

        for(int i=1; i<N; i++){
            
            for(int j=0; j<10; j++){
                int down = (j == 0) ? 0 : dp[i-1][j-1] % 1000000007; 
                int up = (j==9) ? 0 : dp[i-1][j+1] % 1000000007; 

                // dp[i][j] = down + up; 
                dp[i][j] = (down + up) % 1000000007; 

            }
        }

        int answer = 0; 
        for(int i=0; i<10; i++){
            // answer += (dp[N-1][i] % 1000000007); 
            answer = (answer + dp[N-1][i]) % 1000000007;  // 결과를 더할 때도 모듈로 연산
        }

        System.out.println(answer); 


    }
}