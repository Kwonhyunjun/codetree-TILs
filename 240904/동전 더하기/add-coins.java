import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N]; 

        
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0; 
        int idx = N-1; 
        while(K > 0){
            // System.out.println(K); 
            
            answer += K / coins[idx]; 
            K %= coins[idx--]; 

        }

        System.out.println(answer); 

    }
}