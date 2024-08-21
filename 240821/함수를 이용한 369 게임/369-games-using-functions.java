import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int a = Integer.parseInt(st.nextToken()); 
        int b = Integer.parseInt(st.nextToken()); 

        int answer = 0; 
        for(int i=a; i<=b; i++){
            if(solve(i)){
                // System.out.println(i); 
                answer++; 
            }
        }

        System.out.println(answer); 
    }

    public static boolean solve(int num){
        if(num % 3 == 0){
            return true;
        }

        String str = String.valueOf(num); 
        // System.out.println(str);
        for(int i=0; i<str.length(); i++){
            char ch =  str.charAt(i);
            // System.out.println(ch);
            if(ch == '3' || ch == '6' || ch == '9'){
                return true; 
            }
        }

        return false; 
    }
}