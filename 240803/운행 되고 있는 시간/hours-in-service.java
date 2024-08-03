import java.io.*;
import java.util.*;

public class Main {
    
    static int[] check; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0; 

        int N = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0; 

        int[][] times = new int[N][2];
        check = new int[1001]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            start = Math.min(start, times[i][0]);
            end = Math.max(end, times[i][1]-1); 

            for(int j=times[i][0]; j<times[i][1]; j++){
                check[j]++; 
            }
        }

        // System.out.println(Arrays.toString(check));

        for(int i=0; i<N; i++){
            for(int j=times[i][0]; j<times[i][1]; j++){
                check[j]--; 
            }
            int cnt = 0;
            for(int j=start; j<= end; j++){
                if(check[j] > 0) cnt++; 
            }
            answer= Math.max(answer, cnt);

            for(int j=times[i][0]; j<times[i][1]; j++){
                check[j]++; 
            }
        }

        System.out.println(answer); 
    }
}