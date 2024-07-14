import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());         
        int[] arr = new int[6];
        int answer = Integer.MAX_VALUE;
        int total = 0;
        for(int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i]; 
        }

        for(int i=0; i<6; i++){
            for(int j=i+1; j<6; j++){
                for(int k=j+1; k<6; k++){
                    int temp = arr[i] + arr[j] + arr[k];

                    answer = Math.min(answer, Math.abs((total-temp) - temp));  
                }
            }
        }

        System.out.println(answer); 
        
    }
}