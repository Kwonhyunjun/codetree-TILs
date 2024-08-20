import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine()); 
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        for(int i=1; i<=N; i++){
            prefix[i] = prefix[i-1] + arr[i]; 
        }

        // System.out.println(Arrays.toString(prefix)); 

        int answer =0; 

        for(int i=1; i<=N; i++){
            // System.out.printf("i : %d \n", i); 
            for(int j=1; j<=N-i+1; j++){
                // System.out.printf("%d ", j); 
                // System.out.println(prefix[j] - prefix[i-1]); 
                if(prefix[j+i-1] - prefix[j-1] == K){
                    answer++; 
                }
            }

            // System.out.println(); 
        }

        System.out.println(answer); 
    }
}