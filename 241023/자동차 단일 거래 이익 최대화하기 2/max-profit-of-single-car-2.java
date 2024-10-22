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

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                answer = Math.max(answer, arr[j]-arr[i]);        
            }
        }

        System.out.println(answer); 
    }
}