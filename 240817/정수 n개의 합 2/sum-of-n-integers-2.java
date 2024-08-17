import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine()); 
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1]; 
        for(int i=1; i<N+1; i++){
            prefix[i] = prefix[i-1] + arr[i]; 
        }

        // System.out.println(Arrays.toString(prefix));

        int answer = Integer.MIN_VALUE;
        for(int i=K; i<N+1; i++){
            int end = i;
            int start = i-K; 

            answer = Math.max(answer, (prefix[end] - prefix[start])); 
            // System.out.printf("[%d %d] -> %d\n", start, end, prefix[end] - prefix[start]);
        }

        System.out.println(answer); 
    }
}