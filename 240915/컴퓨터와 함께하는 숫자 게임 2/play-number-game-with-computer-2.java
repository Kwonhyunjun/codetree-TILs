import java.util.*;
import java.io.*;

public class Main {

    static long M, start, end; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Long.parseLong(br.readLine()); 

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        
        for(long i = start ; i<=end; i++){
            // System.out.printf("타겟값 : %d\n", i);
            // System.out.println(binary_search(i)); 
            int result = binary_search(i);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.printf("%d %d", min, max); 


    }


    static int binary_search(long target){
        int cnt = 0;

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