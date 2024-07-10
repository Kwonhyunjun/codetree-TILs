// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st; 

//         int N = Integer.parseInt(br.readLine());
//         int[][] points = new int[N][2];
//         int[] dist = new int[N-1]; 
//         for(int i=0; i<N; i++){
//             st = new StringTokenizer(br.readLine());
//             points[i][0] = Integer.parseInt(st.nextToken());
//             points[i][1] = Integer.parseInt(st.nextToken());

//             // dist[i-1] = Math.abs(points[i-1][0] - points[i][0]) + Math.abs(points[i-1][0] - points[i][0]); 
//         }

//         int total = 0;

//         for(int i=0; i<N-1; i++){
//             dist[i] = Math.abs(points[i+1][0] - points[i][0]) + Math.abs(points[i+1][1] - points[i][1]); 
//             total += dist[i];
//         }

//         int answer = Integer.MAX_VALUE;

//         int temp = 0;
//         for(int i=1; i<N-1; i++){
//             temp = total; 
//             temp -= dist[i-1]; 
//             temp -= dist[i]; 
//             temp += Math.abs(points[i+1][0] - points[i-1][0]) + Math.abs(points[i+1][1] - points[i-1][1]); 

//             answer = Math.min(answer, temp);
//         }

//         System.out.println(answer); 
        
        
        
//     }
// }

import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        // 각 i번째 체크포인트를 건너 뛰었을 때의 거리를 구해줍니다.
        int ans = INT_MAX;
        for(int i = 1; i < n - 1; i++) {
            // 거리를 구합니다.
            int dist = 0;
            int prevIdx = 0;
            for(int j = 1; j < n; j++) {
                if(j == i) continue;
                dist += Math.abs(x[prevIdx] - x[j]) + Math.abs(y[prevIdx] - y[j]);
                prevIdx = j;
            }
            
            // 가능한 거리 중 최솟값을 구해줍니다.
            ans = Math.min(ans, dist);
        }
        
        // 출력
        System.out.print(ans);
    }
}