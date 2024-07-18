import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int answer = Integer.MAX_VALUE; 
        StringBuilder sb = new StringBuilder(br.readLine());
        int length = sb.length();
        for(int i=0; i<length; i++){
            char front = sb.charAt(0);
            String str = sb.substring(1); 
            sb.setLength(0);
            sb.append(str).append(front); 
            // System.out.println(sb);

            answer = Math.min(answer, compress(sb.toString()).length()); 
        }
        System.out.println(answer);
    }

    static String compress(String str){
        StringBuilder result = new StringBuilder();

        int cnt = 1; 
        char lastChar = str.charAt(0);

        for(int i=1; i<str.length(); i++){
            if(lastChar == str.charAt(i)){
                cnt++;
            }else{
                result.append(lastChar).append(cnt); 
                cnt = 1; 
                lastChar = str.charAt(i);
            }
        } 
        result.append(lastChar).append(cnt); 
        // System.out.println(result);
        return result.toString(); 
    }
}