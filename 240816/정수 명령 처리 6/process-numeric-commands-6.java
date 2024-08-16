import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 

            switch(st.nextToken()){
                case "push" :
                    int n = Integer.parseInt(st.nextToken()); 
                    pq.add(n); 
                    break;
                case "pop" : 
                    sb.append(pq.poll()).append("\n"); 
                    break;
                case "size" : 
                    sb.append(pq.size()).append("\n"); 
                    break;
                case "empty" :
                    if(pq.isEmpty()){
                        sb.append(1).append("\n"); 
                    }else{
                        sb.append(0).append("\n"); 
                    } 
                    break;
                case "top" : 
                    sb.append(pq.peek()).append("\n"); 
                    break;
            }
        }

        System.out.println(sb); 
    }
}