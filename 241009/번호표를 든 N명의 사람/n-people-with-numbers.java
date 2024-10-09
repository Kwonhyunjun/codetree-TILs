import java.io.*;
import java.util.*;

public class Main {

    static int N, T, times[], answer; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        times = new int[N]; 
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(br.readLine()); 
        }

        int left = 1;
        int right = N; 
        int answer = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // System.out.printf("%d~%d : %d\n", left, right, mid); 

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

        // 만약 전체인원이 수용인원보다 작으면 true
        if(N <= mid) return true; 
        
        // 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<mid; i++){
            pq.offer(0 + times[i]);
        }

        int idx = mid; 
        int time = 1;

        while(time <= T){
            
            // 무대 내려갈 사람 찾기
            while(!pq.isEmpty() && pq.peek() == time){
                // System.out.println("무대 내려감 "+ pq.poll()); 
                pq.poll(); 
            }

            // 더 추가할 사람이 있다면
            while(idx < N && pq.size() < mid){
                // System.out.printf("%d분 -> %d번 입장\n", time, idx);
                pq.offer(time + times[idx++]);
            }

            time++; 
        }


        if(idx < N || !pq.isEmpty()) return false;

        return true; 
    }
}