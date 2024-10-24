import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Long> pq = new PriorityQueue<>(); 

        int N = Integer.parseInt(br.readLine()); 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        long answer = 0; 

        while(pq.size() > 1){
            long fee = pq.poll() + pq.poll(); 

            answer += fee; 
            pq.offer(fee);    
        }

        System.out.println(answer);
    }
}