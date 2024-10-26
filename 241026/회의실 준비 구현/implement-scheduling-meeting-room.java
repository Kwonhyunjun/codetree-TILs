import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        int time = 0; 
        int answer = 0; 

        while(!pq.isEmpty()){
            // System.out.println(time);

            while(!pq.isEmpty() && pq.peek()[0] < time){
                pq.poll(); 
            }

            if(pq.isEmpty()) break;

            answer++;
            time = pq.poll()[1];
        }

        System.out.println(answer);
    }
}