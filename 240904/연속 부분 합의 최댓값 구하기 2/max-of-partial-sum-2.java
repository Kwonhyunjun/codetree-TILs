import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int answer = Integer.MIN_VALUE; 
        for(int i=0; i<N; i++){

            if((sum + arr[i]) < 0){
                sum = 0;     
                 answer = Math.max(answer, arr[i]);
            }else{
                sum += arr[i]; 
                answer = Math.max(answer, sum);
            }
            
        }

        System.out.println(answer); 

    }
}