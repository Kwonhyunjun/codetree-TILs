import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "size" : 
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" : 
                    int isEmpty = (stack.isEmpty()) ? 1 : 0; 
                    sb.append(isEmpty).append("\n");
                    break;
                case "pop" : 
                    sb.append(stack.pop()).append("\n");
                    break;
                case "top" : 
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.printf("%s \n", sb);
    }
}