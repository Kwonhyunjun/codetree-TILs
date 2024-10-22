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

        int answer = 0; 

        int min = arr[0];

        for(int i=1; i<N; i++){
            if(min > arr[i]){
                min = arr[i]; 
            }else{
                answer = Math.max(arr[i]-min, answer);
            }
        }

        System.out.println(answer); 
    }
}