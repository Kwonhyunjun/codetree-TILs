import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[][] prefix = new int[N+1][N+1];


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + map[i][j]; 
            }
        }

        // for(int i=0; i<=N; i++){
        //     System.out.println(Arrays.toString(prefix[i])); 
        // }


        int answer = -1; 

        for(int i=K; i<=N; i++){
            for(int j=K; j<=N; j++){
                // System.out.printf("%d %d\n", i, j); 

                int cur = prefix[i][j] - prefix[i-K][j] - prefix[i][j-K] + prefix[i-K][j-K]; 
                // System.out.println(cur); 
                answer = Math.max(answer, cur); 
            }
        }

        System.out.println(answer); 

    }
}