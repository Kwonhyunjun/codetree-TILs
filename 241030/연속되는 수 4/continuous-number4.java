import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 

        int maxLength = 0; 
        
        int cnt = 1; 
        int prev = Integer.parseInt(br.readLine()); 

        for(int i=1; i<N; i++){
            int cur = Integer.parseInt(br.readLine());

            if(prev < cur){
                cnt++; 
            }else{
                maxLength = Math.max(maxLength, cnt); 
                cnt = 1; 
            }

            prev = cur; 
        }

        maxLength = Math.max(maxLength, cnt); 

        System.out.println(maxLength); 

    }
}