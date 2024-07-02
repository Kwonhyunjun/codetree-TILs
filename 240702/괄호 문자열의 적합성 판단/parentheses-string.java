import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()) {
                    System.out.printf("No\n");
                    return;
                }
                stack.pop();
            }
        }

        String answer = (stack.isEmpty()) ? "Yes" : "No"; 
        
        System.out.printf("%s", answer); 
    }
}