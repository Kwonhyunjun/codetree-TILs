import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            deque.addLast(i+1);
        }

        // System.out.printf("%s\n", deque); 

        while(deque.size() > 1){
            deque.pollFirst(); 
            deque.addLast(deque.pollFirst()); 
            // System.out.printf("%s\n", deque); 
        }

        System.out.printf("%d", deque.pollFirst()); 

    }
}