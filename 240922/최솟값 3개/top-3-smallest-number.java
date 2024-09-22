import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());

        long result = 1L; 

        StringBuilder sb = new StringBuilder(); 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            // pq에 넣기
            if(pq.size() <= 2){
                pq.offer(num);
                result *= num; 
            }else{
                if(pq.peek() > num){
                    result /= pq.poll(); 
                    pq.offer(num);
                    result *= num; 
                }
            }

            long answer = (pq.size() <= 2) ? -1 : result ; 
            sb.append(answer).append("\n"); 
        }

        System.out.println(sb); 
    }
}