import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder(); 

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int num = 0; 

            switch(st.nextToken()){
                case "push_front" :
                    num = Integer.parseInt(st.nextToken());
                    list.addFirst(num); 
                break;
                case "push_back" :
                    num = Integer.parseInt(st.nextToken());
                    list.addLast(num); 
                break;
                case "pop_front" :
                    num = list.pollFirst();
                    sb.append(num).append("\n");
                break;
                case "pop_back" :
                    num = list.pollLast();
                    sb.append(num).append("\n");
                break;
                case "size" :
                    sb.append(list.size()).append("\n");
                break;
                case "empty" :
                    num = (list.isEmpty()) ? 1 : 0; 
                    sb.append(num).append("\n");
                break;
                case "front" :
                    num = list.peekFirst();
                    sb.append(num).append("\n");
                break;
                case "back" :
                    num = list.peekLast();
                    sb.append(num).append("\n");
                break;
            }
        }
        
        System.out.println(sb);
    }
}