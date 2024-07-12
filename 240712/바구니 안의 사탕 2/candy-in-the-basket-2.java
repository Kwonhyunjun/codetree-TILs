import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[101]; 

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            arr[idx] += candy; 
        }

        // System.out.println(arr[33]);

        for(int i = K+1; i<=100-K ; i++){
            // System.out.printf("i(%d) : ", i);
            int temp = 0;
            for(int j= i-K; j <= i+K; j++){
                // if(i==42)
                    // System.out.printf("%d(%d) ", j, arr[j]);
                temp += arr[j]; 
            }
            // System.out.println(temp);
            answer = Math.max(temp, answer); 
        }

        System.out.println(answer);
    }
}