import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 

        int[] iceberg = new int[N]; 

        int min = 1001; 
        int max = 0; 
        for(int i=0; i<N; i++){
            iceberg[i] = Integer.parseInt(br.readLine()); 
            min = Math.min(min, iceberg[i]);
            max = Math.max(max, iceberg[i]); 
        }
        int answer = 0; 

        for(int i=min; i<=max; i++){
            int cnt = 0;
            boolean prev = false; 
            
            for(int j=0; j<N; j++){

                if(iceberg[j] - i > 0){
                    if(!prev){
                        cnt++; 
                        prev = true; 
                    }
                }else{
                    if(prev) prev = false; 
                }
            }

            // System.out.println(i + " " + cnt);
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}