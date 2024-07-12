import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[101]; 

        int min = 101;
        int max = 0; 
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken())-1;
            // System.out.printf("arr[%d] = %d\n", idx, candy);
            arr[idx] = candy;
            min = Math.min(min, idx);
            max = Math.max(max, idx);
        }

        // System.out.printf("%d %d", min, max);
        int len = 2*K +1;
        // System.out.printf("%d\n", len);
        for(int i=min; i<= (max - len); i++){
            // System.out.printf("i(%d) : ",i);
            int temp = 0;
            for(int j=0; j<len; j++){
                temp += arr[i+j]; 
                // System.out.printf("%d(%d) ",j+i,arr[j+1]);
            }

            // System.out.println(); 
            answer = Math.max(answer, temp);
        }
        
        System.out.println(answer);
    }
}