import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[10000];
        int min_idx = 10001;
        int max_idx = 0;
        int answer = 0;
        int total = 0; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int score = ("G".equals(st.nextToken())) ? 1 : 2;
            min_idx = Math.min(idx, min_idx);
            max_idx = Math.max(idx, max_idx); 
            arr[idx] = score;
            total += score; 
        }

        if((max_idx - min_idx) <= K){
            System.out.println(total);
            return; 
        }

        for(int i=min_idx; i<=max_idx - K; i++){
            int temp = 0;
            for(int j=0; j<=K; j++){
                // System.out.printf("arr[%d] = %d ", i+j, arr[i+j]); 
                temp += arr[i+j]; 
            }
            // System.out.println();
            System.out.println(temp); 
            answer = Math.max(answer, temp); 
        }

        System.out.println(answer); 

    }
}