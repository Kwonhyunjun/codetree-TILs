import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 
        
        int N = Integer.parseInt(br.readLine()); 
        Deque<Integer> deque = new ArrayDeque<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push_front" : 
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" : 
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back" : 
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "size" : 
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" : 
                    int num = (deque.isEmpty())? 1 : 0 ;
                    sb.append(num).append("\n");
                    break;
                case "front" :
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back" : 
                    sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.printf("%s", sb); 
    }
}