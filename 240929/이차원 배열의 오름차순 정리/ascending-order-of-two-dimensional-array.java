import java.io.*;
import java.util.*; 

public class Main {

    static int N, K, answer; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        N = Integer.parseInt(br.readLine()); 
        K = Integer.parseInt(br.readLine());

        int left = 1; 
        int right = N * N; 
        int answer = Integer.MAX_VALUE; 

        while(left <= right){
            // System.out.printf("%d ~ %d\n", left, right); 
            int mid = left + (right - left) / 2; 

            if(check(mid) >= K){
                right = mid - 1; 
                answer = Math.min(answer, mid); 
            }else{
                left = mid + 1;
            }
        }


        System.out.println(answer); 
        
    }

    static int check(int mid){
        int res = 0;

        for(int i=1; i<=N; i++){

            int cnt = mid / i; 

            if(cnt == 0) continue;
            // System.out.println(cnt); 

            res += (cnt > N) ? N : cnt;            

        }

        // System.out.printf("mid(%d) => %d\n", mid, res); 
        return res; 
    }

}