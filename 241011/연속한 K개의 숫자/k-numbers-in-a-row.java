import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1]; 
        Arrays.fill(nums, 0);

        for(int i=0; i<B; i++){
            int idx = Integer.parseInt(br.readLine());
            nums[idx] = 1;
        }

        
        int[] prefix = new int[N+1];
        prefix[1] = nums[1];
        for(int i=2; i<=N; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int answer = Integer.MAX_VALUE;
        // System.out.println(Arrays.toString(prefix)); 
        for(int i=1; i<=N-K+1; i++){
            
            int start = prefix[i];
            int end = prefix[i+K-1]; 
            int cnt = prefix[i+K-1] - prefix[i-1]; 
            // System.out.printf("prefix[%d]~prefix[%d] : (%d-%d+1) => %d\n", i, i+K-1, prefix[i+K-1], prefix[i], cnt); 
            answer = Math.min(cnt, answer);
        }

        System.out.println(answer);



    }
}