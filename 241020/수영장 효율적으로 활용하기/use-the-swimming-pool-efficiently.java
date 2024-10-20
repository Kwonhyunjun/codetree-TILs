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
        int idx = 0; // 사람번호 
        int cnt = 1; // 레인수

        while(idx<N){
            if(times[idx] > mid) return false;
            if(cnt > M) return false;

            int sum = 0;
            while(idx<N && sum+times[idx] <= mid){
                sum += times[idx];
                idx++;
            }
            cnt++; 
        }

        return true;
    }
}