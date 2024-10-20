import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, times[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 레인 수

        int left = Integer.MAX_VALUE;;
        int right = 0;  
        int answer = Integer.MAX_VALUE;

        times = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
            left = Math.min(left, times[i]);
            right += times[i]; 
        }


        while(left <= right){
            int mid = left + (right - left) /2; 

            int res = isPossible(mid);
            if(res != -1){
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

        // System.out.printf("mid: %d\n", mid); 
        
        for(int i=0; i<M; i++){
            // 레인마다
            int cur = 0; 

            while(idx < N && cur+times[idx] < mid){
                cur += times[idx++]; 
            }
            // System.out.printf("%d번째 레인 : %d (%d번째 사람까지)\n", i, cur, idx-1);
            if(idx >= N) break;

            use_time = Math.max(use_time, cur); 
        }

        int res = (idx <= (N-1))? -1 : use_time; 

        // System.out.printf("isPossiebl(%b), res(%d)\n", (res != -1), res);

        return res; 
    }
}