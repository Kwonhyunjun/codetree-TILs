import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, C, times[];

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

        int answer = Integer.MAX_VALUE;
        int left = 1;
        int right = times[N-1] - times[0]; 

        while(left <= right){
            int mid = left + (right - left) / 2; 

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
        int cnt = 0; // 버스를 태운 인원
        int idx = 0; // 포인터

        for(int i=0; i<M; i++){ // 버스마다
            if(idx >= N) return true;
            int first = times[idx]; // 맨 처음 탄 인원 시간
            int temp = 0; // 현재 버스에 태운 인원
            while(idx < N){
                if(temp == C) break; // 인원을 초과하면 break
                if(Math.abs(first-times[idx]) > mid) break; // 기다리는 시간을 넘어가면
                
                idx++; 
                temp++;
            }
            cnt += temp; 
        }
        
        return cnt ==  N;
    }
}