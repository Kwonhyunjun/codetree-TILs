import java.io.*;
import java.util.*; 

public class Main {

    static int N, K, answer; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        N = Integer.parseInt(br.readLine()); 
        K = Integer.parseInt(br.readLine());

        long left = 1; 
        long right = (long) N * N; 
        long answer = right; 

        while(left <= right){
            // System.out.printf("%d ~ %d\n", left, right); 
            long mid = left + (right - left) / 2; 

            if(check(mid) >= K){
                right = mid - 1; 
                answer = mid; 
            }else{
                left = mid + 1;
            }
        }


        System.out.println(answer); 
        
    }

    static long check(long mid){
        long res = 0;

        for(int i = 1; i <= N; i++){
            long cnt = (int) (mid / i); // cnt 계산

            res += Math.min(cnt, N); 
        }

        // System.out.printf("mid(%d) => %d\n", mid, res); 
        return res; 
    }

}