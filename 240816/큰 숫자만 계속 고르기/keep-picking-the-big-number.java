import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken())); 
        }

        for(int i=0; i<M; i++){
            int n = pq.poll();
            pq.add(n-1); 
        }

        System.out.println(pq.poll()); 
    }
}