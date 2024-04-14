import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int num = 0; 

            // System.out.println(list.toString()); 

            switch(st.nextToken()){
                case "push_back" :
                    num = Integer.parseInt(st.nextToken()); 
                    list.add(num); 
                    break;

                case "get" :
                    num = Integer.parseInt(st.nextToken()); 
                    sb.append(list.get(num-1)).append("\n"); 
                    break;

                case "size" :
                    sb.append(list.size()).append("\n"); 
                    break;

                case "pop_back" :
                    list.remove(list.size()-1); 
                    break;
            }
        }

        System.out.println(sb);
    }
}