import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> min, max; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        

        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine()); 
            st = new StringTokenizer(br.readLine());

            min = new PriorityQueue<>();
            max = new PriorityQueue<>((o1, o2) -> -(o1 - o2));

            min.offer(Integer.parseInt(st.nextToken()));
            sb.append(min.peek()).append(" "); 
            int num = Integer.parseInt(st.nextToken());
            if(min.peek() < num){
                max.offer(min.poll());
                min.offer(num); 
            }else{
                max.offer(num); 
            }
            // PriorityQueue<Integer> minCopy = new PriorityQueue<>(min);
            // PriorityQueue<Integer> maxCopy = new PriorityQueue<>(max); 
            // System.out.println("2번째"); 
            // while(!minCopy.isEmpty()){
            //     System.out.print("min :"); 
            //     System.out.print(minCopy.poll()+" "); 
            // }
            // System.out.println(); 
            // while(!maxCopy.isEmpty()){
            //     System.out.print("max :"); 
            //     System.out.print(maxCopy.poll()+" "); 
            // }
            // System.out.println(); 

            for(int i=3; i<=N; i++){
                num = Integer.parseInt(st.nextToken());

                if(i%2 == 0){
                    // 짝수번
                    if(min.peek() < num){
                        max.offer(min.poll());
                        min.offer(num); 
                    }else{
                        max.offer(num); 
                    }

                }else{
                    // 홀수번
                    if(max.peek() > num){
                        min.offer(max.poll());
                        max.offer(num); 
                    }else{
                        min.offer(num); 
                    }

                    sb.append(min.peek()).append(" "); 
                }
                
                // minCopy = new PriorityQueue<>(min);
                // maxCopy = new PriorityQueue<>(max); 
                
                // System.out.println(i+"번째");
                // System.out.print("min :");  
                // while(!minCopy.isEmpty()){
                //     System.out.print(minCopy.poll()+" "); 
                // }
                // System.out.println(); 
                // System.out.print("max :"); 
                // while(!maxCopy.isEmpty()){
                //     System.out.print(maxCopy.poll()+" "); 
                // }
                // System.out.println(); 

            }

            sb.append("\n"); 
        }

        System.out.println(sb); 
    }


}