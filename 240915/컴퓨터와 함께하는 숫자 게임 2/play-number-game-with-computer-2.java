import java.util.*;
import java.io.*;

public class Main {

    static int M, start, end; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine()); 

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        
        for(int i = start ; i<=end; i++){
            // System.out.printf("타겟값 : %d\n", i);
            // System.out.println(binary_search(i)); 
            int result = binary_search(i);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.printf("%d %d", min, max); 


    }


    static int binary_search(int target){
        int cnt = 0;

        int left = 1; 
        int right = M; 

        while(left <= right){
            int mid = (left + right) / 2; 
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