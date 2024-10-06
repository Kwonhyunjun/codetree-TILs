import java.io.*;
import java.util.*; 

public class Main {

    static long N, M, times[], answer; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());
        answer = Integer.MAX_VALUE;

        times = new long[(int) N]; 
        for(int i=0; i<N; i++){
            times[i] = Long.parseLong(br.readLine()); 
        }

        Arrays.sort(times); 
        
        long left = 1; 
        long right = times[(int) N-1] * M ;

        while(left <= right){
            long mid = left + (right - left) / 2;

            // System.out.printf("%d~%d => %d\n", left, right, mid); 

            if(isPossible(mid)){
                right = mid - 1;
                answer = Math.min(answer, mid); 
            }else{
                left = mid + 1; 
            }

        }

        System.out.println(answer); 
    }

    static boolean isPossible(long mid){
        long cnt = 0; 

        for(int i=0; i<N; i++){
            cnt += (mid / times[i]); 
        }

        return cnt >= M; 
    }
}