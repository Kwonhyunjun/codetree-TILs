import java.io.*;
import java.util.*;

public class Main {

    static int MAX_NUM = 1_000_000; 
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); 

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] nums = new int[MAX_NUM + 1];
        int[] prefix = new int[MAX_NUM + 1];
        int maxIdx = 0; 
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(st.nextToken());

            nums[idx]++; 
            maxIdx = Math.max(maxIdx, idx); 
        }

        Arrays.fill(prefix, N);
        prefix[0] = 0;
        for(int i=1; i<=maxIdx; i++){
            prefix[i] = prefix[i-1] + nums[i];      
        }

        // System.out.println(Arrays.toString(prefix));



        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()); 

            
            if(start != 0){
                sb.append(prefix[end]-prefix[start-1]).append("\n"); 
            }else{
                sb.append(prefix[end]-prefix[0]).append("\n"); 
            }
            
        }

        System.out.println(sb); 
        
    }
}