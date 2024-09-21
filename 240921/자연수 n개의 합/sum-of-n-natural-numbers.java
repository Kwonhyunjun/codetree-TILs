import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long left = 1L; 
        long right = N; 
        long maxNum = 1L; 


        while(left <= right){
            
            long mid = (left + right) / 2;

            // System.out.printf("%d ~ %d -> mid : %d\n", left, right, mid); 
            if(mid * (mid +1) / 2 <= N){
                
                left = mid +1; 
                maxNum = Math.max(maxNum, mid); 
            }else{ // 컸으면 
                right = mid -1; 
            }
        }

        System.out.println(maxNum); 

    }
}