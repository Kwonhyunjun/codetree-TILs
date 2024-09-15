import java.util.*;
import java.io.*;

public class Main {

    static long M, start, end; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Long.parseLong(br.readLine()); 

        st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        
        for(long i = start ; i<=end; i++){
            // System.out.printf("타겟값 : %d\n", i);
            // System.out.println(binary_search(i)); 
            long result = binary_search(i);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.printf("%d %d", min, max); 


    }


    static Long binary_search(long target){
        long cnt = 0;

        long left = 1; 
        long right = M; 

        while(left <= right){
            long mid = (left + right) / 2; 
            // System.out.printf("mid %d\n", mid);
            cnt++; 

            if(target == mid){
                break;
            }

            if(target < mid){
                right = mid - 1;
            }else{
                left = mid + 1; 
            }

        }

        return cnt;
    }
}