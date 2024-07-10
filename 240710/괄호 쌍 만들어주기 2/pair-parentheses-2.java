import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); 

        int N = str.length(); 

        int answer = 0; 

        for(int i=0; i<N-3; i++){
            if(str.charAt(i) == ')' || str.charAt(i+1) == ')') continue;
            for(int j=i+2; j<N-1; j++){
                if(str.charAt(j) == '(' || str.charAt(j+1) == '(') continue;
                // System.out.printf("%d %d\n", i, j); 
                answer++; 
            }
        }

        System.out.println(answer); 
    }
}