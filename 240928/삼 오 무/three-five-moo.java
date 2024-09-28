import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1_000_000_000;

        int answer = Integer.MAX_VALUE; 

        while(left <= right){
            
            int mid = left + (right - left) / 2; 
            
            int order = check(mid); 

            // if(order == N){
            //     answer = mid; 
            //     break; 
            // }

            if(order >= N){
                // 해당 숫자가 순번이 더 클경우
                right = mid -1; 
                answer = Math.min(answer, mid); 
                
            }else{
                left = mid + 1; 
            }

        }

        System.out.println(answer); 
    }

    static int check(int num){
        int res = 0; 

        int three = (num / 3); 
        int five = num / 5; 
        int fifteen = num / 15; 

        res = num - (three + five - fifteen); 

        return res; 
    }
}