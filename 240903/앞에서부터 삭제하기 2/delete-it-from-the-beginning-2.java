import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        float sum = arr[N-1]; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        pq.offer(arr[N-1]); 

        float answer = 0f; 

        for(int i=N-2; i>=0; i--){
            int num = arr[i]; 
            
            sum += num;
            pq.offer(num); 

            answer = Math.max(answer, ((sum - pq.peek()) / (pq.size()-1))); 
        }

        System.out.printf("%.2f", answer);
    }
}