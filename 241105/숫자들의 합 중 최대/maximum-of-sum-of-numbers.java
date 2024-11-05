import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int start = Integer.parseInt(st.nextToken()); 
        int end = Integer.parseInt(st.nextToken()); 
        int answer = 0; 

        for(int i=start; i<= end; i++){
            int num = i; 
            answer = Math.max(answer, sumDigit(num));
        }

        System.out.println(answer);
    }

    static int sumDigit(int num){
        int res = 0; 
        
        while(num > 0){
            res += (num % 10); 
            num /= 10; 
        }

        return res; 
    }
}