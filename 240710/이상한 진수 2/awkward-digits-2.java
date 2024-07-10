import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int answer = -1; 


        for(int i=0; i<sb.length(); i++){
            char num = sb.charAt(i);
            char changed = (num == '0') ? '1' : '0'; 
            sb.setCharAt(i, changed);

            answer = Math.max(answer, Integer.parseInt(sb.toString(), 2));
            sb.setCharAt(i, num);

        }

        System.out.println(answer); 
    }   
}