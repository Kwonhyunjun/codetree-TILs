import java.io.*;
import java.util.*;

public class Main {

    static int N, M, C, times[], answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        times = new int[N]; 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times); 

        int left = 1; 
        int right = C; 
        
        while(left <= right){
            int mid = left + (right - left) / 2; 

            // System.out.printf("%d~%d => %d\n", left, right, mid);

            if(isPossible(mid)){
                right = mid - 1; 
            }else{
                left = mid + 1; 
            }
        }

        System.out.println(answer);

    }

    static boolean isPossible(int mid){
        if((M * mid) < N) return false;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<M; i++){
            // 버스
            int first = Integer.MAX_VALUE;
            int last = Integer.MIN_VALUE;

            for(int j=0; j<mid; j++){
                // 인원
                int idx = (i*mid)+j;
                if(idx >= N) break;
                int cur = times[idx]; 
                first = Math.min(first, cur);
                last = Math.max(last, cur);
            }
            // System.out.printf("%d-%d=%d\n", last, first, last-first);
            max = Math.max(max,(last-first)); 
        }

        answer = Math.max(answer, max); 
        return true; 
    }
}