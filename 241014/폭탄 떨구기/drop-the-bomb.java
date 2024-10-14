import java.io.*;
import java.util.*; 

public class Main {

    static int N, K, points[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken());

        points = new int[N]; 
        for(int i=0; i<N; i++){
            points[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(points); 

        int left = 1;
        int right = points[N-1]; 
        int answer = Integer.MAX_VALUE;

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
        int cnt = 0; // 폭탄 터뜨리기
        int idx = 0; // 현재 점의 시작점
        
        while(idx < N){
            int start = points[idx]; 
            int end = start + (mid * 2);
            // System.out.printf("start(%d)~end(%d)\n", start, end);
            cnt++; 

            while(points[idx] <= end){
                idx++; 
                if(idx >= N) break;
            }
        }

        // System.out.printf("cnt : %d\n", cnt);

        return cnt <= K; 
    }
}