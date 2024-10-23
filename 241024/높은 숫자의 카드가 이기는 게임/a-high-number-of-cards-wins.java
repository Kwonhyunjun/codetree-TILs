import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();  
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for(int i=1; i<=2*N; i++){
            if(list.contains(i)){
                pq1.offer(i); 
            }else{
                pq2.offer(i); 
            }
        }

        int answer = 0; 

        while(!pq1.isEmpty() && !pq2.isEmpty()){
            int cur = pq1.poll(); 

            boolean flag = false; 

            while(!pq2.isEmpty()){
                if(pq2.peek() > cur){
                    flag = true; 
                    break;
                }else{
                    pq2.poll(); 
                }
            }

            if(flag) answer++; 
        }

        System.out.println(answer);


    }
}