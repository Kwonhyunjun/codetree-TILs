import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE; 

        
        
        for(int i=1; i<=N/5; i++){
            int cur = i; 
            int rest = N - (5*i); 

            if((rest%2) != 0) continue;

            cur += (rest/2); 

            answer = Math.min(answer, cur);
        }

        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;

        System.out.println(answer); 
    }
}