import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
    
        int answer = Integer.MAX_VALUE;
        int total = 0;

        for(int i=0;i <N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            total += arr[i];
        }

        // System.out.println(total); 

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int temp = total -(arr[i]+arr[j]);
                // System.out.printf("arr[%d]+arr[%d](%d + %d) -> temp : %d diff : %d \n", i, j, arr[i], arr[j], temp, Math.abs(S-temp));
                answer = Math.min(Math.abs(S-temp), answer); 
            }
        }

        System.out.println(answer); 
    }
}