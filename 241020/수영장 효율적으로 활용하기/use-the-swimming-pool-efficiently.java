import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, times[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 레인 수

        times = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }


        int left = 1; 
        int right = N;   
        int answer = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left) /2; 

            int res = isPossible(mid);
            if(res != -1){
                // 가능하면 레인당 수용인원을 줄이기
                right = mid - 1; 
                answer = Math.min(answer, res); 
            }else{
                left = mid + 1; 
            }
        }

        System.out.println(answer);
    }

    static int isPossible(int mid){
        int idx = 0; 
        int use_time = Integer.MIN_VALUE;
        boolean flag = false;

        if(mid * M < N) return -1; 

        for(int i=0; i<M; i++){
            int cur = 0; 
            for(int j=0; j<mid; j++){
                cur += times[idx++];
                if(idx >= N) flag = true;  
            }
            use_time = Math.max(use_time, cur);
            if(flag) break; 
        }

        return use_time; 
    }
}