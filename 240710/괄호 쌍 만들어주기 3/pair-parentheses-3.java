import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); 
        
        int answer = 0;
        for(int i=0; i<input.length()-1; i++){
            for(int j=i+1; j<input.length(); j++){
                if(input.charAt(i) == '(' && input.charAt(j) == ')') answer ++;
            }
        }

        System.out.println(answer); 
    }
}