import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, times[], answer; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        times = new int[N]; 
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(times); 
        
        int left = 1; 
        int right = Integer.MAX_VALUE; 

        while(left <= right){
            int mid = left + (right - left) / 2;

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

    static boolean isPossible(int mid){
        int cnt = 0; 

        for(int i=0; i<N; i++){
            cnt += (mid / times[i]); 
        }

        return cnt >= M; 
    }
}