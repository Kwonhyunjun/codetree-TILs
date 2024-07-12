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
        int total = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            arr[idx] += candy; 
            total += candy;
        }

        if(K > 100){
            System.out.println(total);
            return; 
        }

        for(int i = 0; i<=100-K ; i++){
            int temp = 0;
            
            for(int j= i-K; j <= i+K; j++){
                if(j < 0 || j > 100) continue;
                temp += arr[j]; 
            }
            // System.out.println(temp);
            answer = Math.max(temp, answer); 
        }

        System.out.println(answer);
    }
}