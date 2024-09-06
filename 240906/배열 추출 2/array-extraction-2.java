import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2){
                int n1 = Math.abs(o1);
                int n2 = Math.abs(o2);

                if(n1 == n2){
                    return o1 - o2; 
                }

                return n1 - n2; 
            }
        }); 
        StringBuilder sb = new StringBuilder(); 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n"); 
                }
            }else{
                pq.offer(num); 
            }
        }

        System.out.println(sb); 
    }
}