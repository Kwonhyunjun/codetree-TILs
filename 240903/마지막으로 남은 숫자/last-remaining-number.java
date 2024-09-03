import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2)); 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken())); 
        }

        while(pq.size() >= 2){
            int n1 = pq.poll();
            int n2 = pq.poll();

            int diff = n1 - n2; 

            if(diff == 0) continue;
            
            pq.offer(diff); 
        }

        int answer = (pq.isEmpty()) ? -1 : pq.poll();

        System.out.println(answer); 


    }
}